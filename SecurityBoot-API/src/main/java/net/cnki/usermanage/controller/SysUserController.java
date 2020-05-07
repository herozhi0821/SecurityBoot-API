package net.cnki.usermanage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.cnki.common.ResponseBody;
import net.cnki.common.ResultCode;
import net.cnki.common.ResultGenerator;
import net.cnki.usermanage.bean.SysUser;
import net.cnki.usermanage.service.SysUserService;

@RestController
public class SysUserController{
	Logger logger = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	ResultGenerator resultGenerator;

	@RequestMapping(value = "testjson")
	public ResponseBody testjson() {
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		return resultGenerator.getSuccessResult(sysUser);
	}
	@RequestMapping(value = "testjson1")
	public ResponseBody testjson1() {
		return resultGenerator.getFailResult("message");
	}
	@RequestMapping(value = "testjson2")
	public ResponseBody testjson2() {
		return resultGenerator.getFailResult();
	}
	@RequestMapping(value = "testjson3")
	public ResponseBody testjson3() {
		SysUser aSysUser = new SysUser("1", "1", "1", "1", "1", "1", 1, 1, 1, 1, 1);
		
		return resultGenerator.getFreeResult(ResultCode.PARAM_IS_BLANK,aSysUser);
	}
	
	
	@PreAuthorize("hasRole('ROLE_admin')")
	@RequestMapping(value = "getSysUserAdmin")
	public ResponseBody getSysUserAdmin() {
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("200");
	    responseBody.setMessage("Sccess!");
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		responseBody.setData(JSON.toJSONString(sysUser));
		sysUser.stream().forEach(pm->{pm.setCompany("CNKICESHI");});
		return resultGenerator.getSuccessResult(sysUser);
	}
	@PreAuthorize("hasRole('ROLE_child')")
	@RequestMapping(value = "getSysUserChild")
	public ResponseBody getSysUserChild() {
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("200");
	    responseBody.setMessage("Sccess!");
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		responseBody.setData(JSONObject.toJSONString(sysUser));
		
		return responseBody;
	}
	
	// 查询指定的用户
	@RequestMapping("getSysUser")
	public SysUser getSysUser(Integer id) {
		logger.info("跳转到用户编辑页面！");
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		return sysUser;
	}

	// 查看用户账户修改密码权限信息
	@RequestMapping(value = "getSysUserPwdRole")
	public int getSysUserPwdRole(String username) {
		SysUser user = sysUserService.selectByUserName(username);
		if (user != null) {
			return user.getPwdRole();
		}
		return -1;
	}

}
