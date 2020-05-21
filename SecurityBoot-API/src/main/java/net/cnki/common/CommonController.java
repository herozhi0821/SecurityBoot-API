package net.cnki.common;

import java.awt.image.BufferedImage;
import java.security.Principal;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.google.code.kaptcha.Producer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "科技查重项目 Rest API",tags = {"公共管理模块"})
@ApiSort(120)
@RestController
public class CommonController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ResultGenerator resultGenerator;
	@Autowired
	Producer captchaProducer;
	@Autowired
	AuthenticationUser authenticationUser;
	
	/**
	 * Kaptcha生成验证码
	 */
	@ApiOperation(value = "Kaptcha生成验证码", notes="Kaptcha生成验证码",httpMethod = "GET")
	@ApiOperationSupport(order = 1)
	@GetMapping("getVerify")  
    public void defaultKaptcha(HttpServletRequest request,HttpServletResponse response) throws Exception{  
		logger.info("获取登录页验证图片！");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute("captcha",capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi,"jpg",out);
		try{
			out.flush();
		}finally{
			out.close();
		}
	}
	
	@ApiOperation(value = "session到期", notes="session到期",httpMethod = "GET")
	@ApiOperationSupport(order = 2)
	@RequestMapping("/session/invalid")
	public ResponseBody sessioninvalid() {
		logger.info("session过期！");
		return resultGenerator.getFreeResult(ResultCode.SESSION_EXPIRES);
	}
	
	@ApiOperation(value = "获取当前用户", notes="获取当前用户",httpMethod = "GET")
	@ApiOperationSupport(order = 3)
	@RequestMapping("/admin")
	public String currentUserName(Principal principal) {
		System.out.println(authenticationUser.getActiveUser());
        return principal.getName();
    }
}
