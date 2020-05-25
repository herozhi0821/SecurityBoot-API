package net.cnki.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

	/*
	 * 作者信息
	 */
	private static final Contact DEFAULT_CONTACT = new Contact("ZhiPengyu", "https://herozhi0821.github.io/", "herozhi0821@163.com");
	/*
	 * 全局响应状态
	 */
	private List<ResponseMessage> responseBuilder() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(101).message("会话到期!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("Success!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("Failure!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("登录失败!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(402).message("未登录!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("没有权限!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("内部服务器错误!").build());
        responseMessageList.add(new ResponseMessageBuilder().code(1002).message("参数为空!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(3001).message("接口异常!").responseModel(new ModelRef("ResponseBody")).build());
        return responseMessageList;
    }
	/*
	 * 全局请求头
	 */
	private List<Parameter> parameterBuilder(){
	    List<Parameter> pars = new ArrayList<Parameter>();
	    pars.add(new ParameterBuilder().name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("").build());
	    return pars;
	}
	
	@Bean
    public Docket createHomeRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户管理")
                .apiInfo(new ApiInfoBuilder().title("用户管理接口").description("用户管理描述").contact(DEFAULT_CONTACT).version("1.0").build())
                .globalResponseMessage(RequestMethod.GET,responseBuilder())
                .globalResponseMessage(RequestMethod.POST,responseBuilder())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.cnki.usermanage.controller"))
                .paths(PathSelectors.any())
                .build();
        		//.globalOperationParameters(parameterBuilder());
    }
	
	@Bean
    public Docket createUploadRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公共部分")
                .apiInfo(new ApiInfoBuilder().title("公共部分接口").description("公共部分描述").contact(DEFAULT_CONTACT).version("1.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.cnki.common"))
                .paths(PathSelectors.any())
                .build();
    }
    
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/");
     
     registry.addResourceHandler("doc.html")
     .addResourceLocations("classpath:/META-INF/resources/");
    
     registry.addResourceHandler("/webjars/**")
       .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
