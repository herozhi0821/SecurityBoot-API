package net.cnki.security.hander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import net.cnki.common.ResponseBody;

/**
 * 已被其他用户登录
 * @author ZhiPengyu
 *
 */
@Component
public class MyAuthenctiationSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("已被其他用户登录！");
		ResponseBody responseBody = new ResponseBody();
	    responseBody.setCode("101");
	    responseBody.setMessage("Session Expires!Other users login！");
	    
	    HttpServletResponse response = event.getResponse();
	    response.setContentType("application/json;charset=UTF-8");
	    response.getWriter().write(JSON.toJSONString(responseBody));
	}

}
