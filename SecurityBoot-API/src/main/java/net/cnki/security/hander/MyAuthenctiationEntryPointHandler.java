package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;

/**
 * 未登录
 * @author ZhiPengyu
 *
 */
@Component
public class MyAuthenctiationEntryPointHandler implements AuthenticationEntryPoint{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.info("未登录！");
		
		ResponseBody responseBody = new ResponseBody();
        responseBody.setStatus("402");
        responseBody.setMsg("Need Login!");
        
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(responseBody));
	}
}
