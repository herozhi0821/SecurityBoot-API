package net.cnki.security.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {//必须post登录
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        //如果是application/json类型，做如下处理
        if(request.getContentType() != null && (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)||request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE))){
            //以json形式处理数据
            String username = null;
            String password = null;
            String vercode = null;

            try {
            	//将请求中的数据转为map
                Map<String,String> map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
                username = map.get("username");
                password = map.get("password");
//                vercode = map.get("vercode");
                
//                request.getSession().setAttribute("vercode", vercode);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            if (vercode == null) {
            	vercode = "";
            }
            
            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);

            return this.getAuthenticationManager().authenticate(authRequest);
        }
        //否则使用官方默认处理方式
        return super.attemptAuthentication(request, response);
    }
}

