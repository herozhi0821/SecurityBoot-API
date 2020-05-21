package net.cnki.usermanage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.cnki.common.ResponseBody;
import net.cnki.common.ResultGenerator;
import net.cnki.usermanage.bean.SysUser;
import net.cnki.usermanage.service.SysUserService;

@Api(value = "科技查重项目 Rest API",tags = {"用户管理模块"})
@ApiSort(100)
@RestController
public class SysUserController{
	Logger logger = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	ResultGenerator resultGenerator;

	@ApiOperation(value = "获取用户信息", notes="获取用户信息")
	@ApiOperationSupport(order = 1)
	@GetMapping(value = "testjson")
	public ResponseBody testjson() {
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		return resultGenerator.getSuccessResult(sysUser);
	}
	
	@ApiOperation(value = "管理员获取用户信息", notes="获取用户信息")
	@ApiOperationSupport(order = 2)
	@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping(value = "getSysUserAdmin")
	public ResponseBody getSysUserAdmin() {
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("200");
	    responseBody.setMessage("Sccess!");
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		responseBody.setData(JSON.toJSONString(sysUser));
		sysUser.stream().forEach(pm->{pm.setCompany("CNKICESHI");});
		return resultGenerator.getSuccessResult(sysUser);
	}
	
	// 查询指定的用户
	@ApiOperation(value = "查询指定的用户", notes="查询指定的用户")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户令牌", required = true,dataType = "String")
		})
	@PostMapping("getSysUser")
	public SysUser getSysUser(Integer id) {
		logger.info("跳转到用户编辑页面！");
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		return sysUser;
	}

	// 查看用户账户修改密码权限信息
	@ApiOperation(value = "权限信息", notes="权限信息",httpMethod = "GET")
	@ApiOperationSupport(order = 4)
	@ApiImplicitParam(name = "username", value = "用户", required = false, dataType = "String")
	@GetMapping(value = "getSysUserPwdRole")
	public int getSysUserPwdRole(String username) {
		SysUser user = sysUserService.selectByUserName(username);
		if (user != null) {
			return user.getPwdRole();
		}
		return -1;
	}

}
