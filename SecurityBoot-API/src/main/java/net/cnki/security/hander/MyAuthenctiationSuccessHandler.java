package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;

/**
 * 登录成功
 * @author ZhiPengyu
 *
 */
@Component("myAuthenctiationSuccessHandler")
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("登录成功！");
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("200");
    	responseBody.setMessage("Login Success!");
    	
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().write(JSON.toJSONString(responseBody));
	}  
}
