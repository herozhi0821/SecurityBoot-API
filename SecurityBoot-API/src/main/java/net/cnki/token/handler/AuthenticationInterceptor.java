package net.cnki.token.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import net.cnki.token.annotation.PassToken;
import net.cnki.token.annotation.VerifyToken;
import net.cnki.token.exception.TokenAuthenticationException;

import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 
 * @author ZhiPengyu
 * @ClassName:    [AuthenticationInterceptor.java]
 * @Description:  [拦截器类，根据注解是否验证token]
 * @CreateDate:   [2020年5月21日 下午3:24:04]
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
    	//1、从 http请求头中取出 token
    	String token = httpServletRequest.getHeader("Authorization");
        //2、如果不是映射到方法直接通过，没有验证注解则不执行一下内容
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //3、检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //4、检查有没有需要用户权限的注解VerifyToken，跑出异常会被拦截并统一返回
        if (method.isAnnotationPresent(VerifyToken.class)) {
        	VerifyToken verifyToken = method.getAnnotation(VerifyToken.class);
            if (verifyToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new TokenAuthenticationException("无Token，请重新请求！");
                }
                // 获取 token 中的用户名
                String client_id;
                try {
                	client_id = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new TokenAuthenticationException("401");
                }
                String client_secret = client_id;//数据库或Redis获取相应秘钥信息
                if (client_secret == null) {
                    throw new TokenAuthenticationException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(client_secret)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new TokenAuthenticationException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
