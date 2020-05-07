package net.cnki.security.verify;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import net.cnki.usermanage.bean.SysUser;
import net.cnki.usermanage.service.SysUserService;

@Component
public class MyUserDetailService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
	
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	//用户验证前先验证是否有验证码
    	String requestCode = httpServletRequest.getParameter("vercode");
        if(StringUtils.isEmpty(requestCode)) {
        	logger.info("验证码不能为空！");
        	throw new UsernameNotFoundException("验证码不能为空！");
        }
        if(StringUtils.isEmpty(username)) {
        	logger.info("用户名不能为空！");
        	throw new UsernameNotFoundException("用户名不能为空！");
        }
        //通过用户名获取用户信息
        SysUser user =  null;
		try {
			user =sysUserService.selectByUserName(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("系统异常！");
		}
        //SysUser user = sysUserService.selectByUserName(username);
        if (user == null){
        	logger.info("登录用户"+username+"不存在！");
            throw new UsernameNotFoundException("登录用户不存在！");
        }else if(user.getStatus() == -1){
        	logger.info("登录用户"+username+"已禁用！");
        	throw new UsernameNotFoundException("登录用户已禁用！");
        }
        String role = "";
        if(user.getRole() ==1) {
        	role = "admin";
        }else if(user.getRole() ==2) {
        	role = "child";
        }
        //获取用户的角色
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //角色必须以`ROLE_`开头
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),//若入库密码已进行加密，此处则不需要解密
                grantedAuthorities);
    }
}