package net.cnki.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import net.cnki.security.hander.MyAuthenctiationDeniedHandler;
import net.cnki.security.hander.MyAuthenctiationEntryPointHandler;
import net.cnki.security.hander.MyAuthenctiationFailureHandler;
import net.cnki.security.hander.MyAuthenctiationInvalidSessionStrategy;
import net.cnki.security.hander.MyAuthenctiationLogoutSuccessHandler;
import net.cnki.security.hander.MyAuthenctiationSessionInformationExpiredStrategy;
import net.cnki.security.hander.MyAuthenctiationSuccessHandler;
import net.cnki.security.verify.MyAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyAuthenctiationEntryPointHandler myAuthenctiationEntryPointHandler;//未登录
	@Autowired
	MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;//登陆成功
	@Autowired
	MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;//登录失败
	@Autowired
	MyAuthenctiationDeniedHandler myAuthenctiationDeniedHandler;//无权访问
	@Autowired
	MyAuthenctiationLogoutSuccessHandler myAuthenctiationLogoutSuccessHandler;//退出成功
	@Autowired
	MyAuthenctiationInvalidSessionStrategy mMyAuthenctiationInvalidSessionStrategy;//session到期
	@Autowired
	MyAuthenctiationSessionInformationExpiredStrategy myAuthenctiationSessionStrategy;//session到期,被登陆

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/getVerify","/session/invalid").permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling()
				.authenticationEntryPoint(myAuthenctiationEntryPointHandler)//未登录402
				.accessDeniedHandler(myAuthenctiationDeniedHandler)//无权访问403
			.and()
			.formLogin() //定义登录拦截
				.successHandler(myAuthenctiationSuccessHandler)//登陆成功200
				.failureHandler(myAuthenctiationFailureHandler)//登陆失败401
				.permitAll()
				.and()
			.sessionManagement()//session到期提示
//				.invalidSessionUrl("/session/invalid")//效果略有差异，此处即便有过期session，多次访问后都会进入未登录拦截，下边则只要存在过期cookies就会一直在过期拦截
				.invalidSessionStrategy(mMyAuthenctiationInvalidSessionStrategy)//session到期101
				.and()
			.requestCache().disable()
			.logout()
				.logoutSuccessHandler(myAuthenctiationLogoutSuccessHandler)//退出登陆200
//				.deleteCookies("JSESSIONID")
				.permitAll()//退出
				.and()
			.csrf().disable();//csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());//csrf放开配置方式可以为cookie
//		http.sessionManagement().maximumSessions(1).expiredSessionStrategy(myAuthenctiationSessionStrategy);//101只允许一个登陆，新的顶替就得
	}

	//加入中间验证层，可实现自定义验证用户等信息
	@Bean
    public AuthenticationProvider authenticationProvider() {
        AuthenticationProvider provider = new MyAuthenticationProvider();
        return provider;
    }
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}