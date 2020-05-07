package net.cnki.common;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;

@RestController
public class CommonController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ResultGenerator resultGenerator;
	@Autowired
	Producer captchaProducer;
	
	/**
	 * Kaptcha生成验证码
	 */
	@RequestMapping("getVerify")  
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
	
	@RequestMapping("/session/invalid")
	public ResponseBody sessioninvalid() {
		logger.info("session过期！");
		return resultGenerator.getFreeResult(ResultCode.SESSION_EXPIRES);
	}
}
