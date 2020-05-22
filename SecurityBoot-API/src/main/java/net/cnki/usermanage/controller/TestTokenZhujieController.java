package net.cnki.usermanage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import net.cnki.common.ResponseBody;
import net.cnki.common.ResultGenerator;
import net.cnki.token.annotation.PassToken;
import net.cnki.token.annotation.VerifyToken;
import net.cnki.usermanage.bean.SysUser;
import net.cnki.usermanage.service.SysUserService;

@Api(value = "科技查重项目 Rest API",tags = {"测试注解"})
@ApiSort(110)
@RequestMapping("api")
@RestController
public class TestTokenZhujieController{
	Logger logger = LoggerFactory.getLogger(TestTokenZhujieController.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	ResultGenerator resultGenerator;

	@ApiOperation(value = "测试1", notes="首页所显示统计数据",httpMethod = "GET")
	@ApiOperationSupport(order = 1)
	@VerifyToken
	@RequestMapping(value = "testzhuie1")
	public ResponseBody testzhuie1() {
		List<SysUser> sysUser = sysUserService.selectSysUserByUnameOrCompany(null, null);
		sysUser.stream().forEach(pm->{pm.setCompany("CNKICESHI");});
		return resultGenerator.getSuccessResult(sysUser);
	}
	@ApiOperation(value = "测试2", notes="首页所显示统计数据",httpMethod = "GET")
	@ApiOperationSupport(order = 2)
	@PassToken
	@RequestMapping(value = "testzhuie2")
	public ResponseBody testzhuie2() {
		return resultGenerator.getSuccessResult();
	}

}
