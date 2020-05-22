package net.cnki.token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.cnki.token.handler.AuthenticationInterceptor;
/**
 * 
 * @author ZhiPengyu
 * @ClassName:    [InterceptorConfig.java]
 * @Description:  [请求拦截类，让拦截器生效]
 * @CreateDate:   [2020年5月21日 下午3:23:18]
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/api/**")//拦截
                .excludePathPatterns("/login");//放过
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
