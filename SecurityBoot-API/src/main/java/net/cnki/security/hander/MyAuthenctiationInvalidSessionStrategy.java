package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;


/**
 * session到期
 * @author ZhiPengyu
 *
 */
@Component
public class MyAuthenctiationInvalidSessionStrategy implements InvalidSessionStrategy{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		logger.info("session到期！");
		
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("101");
	    responseBody.setMessage("Session Expires!");
	    
	    response.setContentType("application/json;charset=UTF-8");
	    response.getWriter().write(JSON.toJSONString(responseBody));
		
	}
	

}
