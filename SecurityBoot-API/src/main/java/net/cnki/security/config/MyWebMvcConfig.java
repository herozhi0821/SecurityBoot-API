package net.cnki.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
	//-----------------------------------跨域----------------------------------
	private CorsConfiguration buildConfig() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    corsConfiguration.addAllowedOrigin("http://192.168.52.26:3000");//"http://192.168.52.26:3000"
	    corsConfiguration.addAllowedHeader("*");
	    corsConfiguration.addAllowedMethod("*");
	    corsConfiguration.addExposedHeader("Authorization");
	    return corsConfiguration;
	}
	 
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", buildConfig());
	    return new CorsFilter(source);
	}
	 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")//设置允许跨域的路径
	            .allowedOrigins("http://192.168.52.26:3000")//设置允许跨域请求的域名,为*时跨域不成功，指定明确域名"http://192.168.52.26:3000"
	            .allowCredentials(true)//是否允许证书 不再默认开启
	            .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")//设置允许的方法
	            .maxAge(3600);//跨域允许时间
	}
	
}