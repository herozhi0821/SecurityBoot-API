package net.cnki.usermanage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
@ApiSort(110)
@RestController
public class SysUserSwaggerController{
	Logger logger = LoggerFactory.getLogger(SysUserSwaggerController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	ResultGenerator resultGenerator;

	@ApiOperation(value = "用户首页数据", notes="首页所显示统计数据",httpMethod = "GET")
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "param1", value = "参数1", required = true, dataType = "int"),
		@ApiImplicitParam(name = "param2", value = "参数2", required = false, dataType = "String")
		})
	@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping(value = "SwaggerAdmin")
	public ResponseBody getSysUserAdmin(Integer param1,String param2) {
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("200");
	    responseBody.setMessage("Sccess!");
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		responseBody.setData(JSON.toJSONString(sysUser));
		sysUser.stream().forEach(pm->{pm.setCompany("CNKICESHI");});
		return resultGenerator.getSuccessResult(sysUser);
	}


}
