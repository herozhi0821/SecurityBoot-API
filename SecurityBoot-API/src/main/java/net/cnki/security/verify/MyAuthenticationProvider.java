package net.cnki.security.verify;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义校验-密码、图片验证码
 * @author ZhiPengyu
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);
	
    @Autowired
    private MyUserDetailService userService;
    @Autowired
    HttpServletRequest httpServletRequest;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails user = userService.loadUserByUsername(username);
        
        //加密过程在这里体现
        logger.info("结果CustomUserDetailsService后，已经查询出来的数据库存储密码:" + user.getPassword());
        if (!passwordEncoder().matches(password, user.getPassword())) {
        	logger.info("登录用户密码错误！");
            throw new DisabledException("登录用户密码错误！");
        }
 
        String requestCode = httpServletRequest.getParameter("vercode");
        HttpSession session = httpServletRequest.getSession();
		String saveCode = (String) session.getAttribute("captcha");
		//获取到session验证码后随时清除
		if(!StringUtils.isEmpty(saveCode)) {
			session.removeAttribute("captcha");
		}
		logger.info("requestCode:"+requestCode+",saveCode:"+saveCode);
		if(StringUtils.isEmpty(saveCode) || StringUtils.isEmpty(requestCode) || !requestCode.equals(saveCode)) { 
			logger.info("图片验证码错误！");
			throw new DisabledException("图形验证码错误！"); 
		}
		logger.info("登录成功");
		
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
