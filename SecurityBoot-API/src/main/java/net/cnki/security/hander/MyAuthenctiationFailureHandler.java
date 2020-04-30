package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;

/**
 * 登录失败
 * @author ZhiPengyu
 *
 */
@Component("myAuthenctiationFailureHandler")
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.info("登录失败！");
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("401");
        responseBody.setMessage("Login Failure!");
        
        response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(JSON.toJSONString(responseBody));
	}
}
