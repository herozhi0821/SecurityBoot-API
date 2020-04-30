package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;

/**
 * 无权访问
 * @author ZhiPengyu
 *
 */
@Component
public class MyAuthenctiationDeniedHandler implements AccessDeniedHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		logger.info("无权访问！");
		
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("403");
	    responseBody.setMessage("Need Authorities!");
	    
	    response.setContentType("application/json;charset=UTF-8");
	    response.getWriter().write(JSON.toJSONString(responseBody));
	}
}