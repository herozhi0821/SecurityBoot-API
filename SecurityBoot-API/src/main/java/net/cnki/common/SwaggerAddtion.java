package net.cnki.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;

import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

@Component
public class SwaggerAddtion implements ApiListingScannerPlugin {

	@Override
	public boolean supports(DocumentationType delimiter) {
		// TODO Auto-generated method stub
		return DocumentationType.SWAGGER_2.equals(delimiter);
	}

	ApiDescription aaApiDescription = new ApiDescription("系统接口","/login","用户登录入口",null,false);
	@Override
	public List<ApiDescription> apply(DocumentationContext context) {
		// TODO Auto-generated method stub
		return new ArrayList<ApiDescription>(
				Arrays.asList(
						new ApiDescription("系统接口","/login","用户登录入口",
								Arrays.asList( 
										new OperationBuilder(new CachingOperationNameGenerator())
                                        	.method(HttpMethod.POST)
                                        	.produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                                         	.summary("用户登录")
                                         	.notes("用户登录,需要提前获取图片验证码。")//方法描述
                                         	.tags(Sets.newHashSet("登入登出"))//归类标签
                                         	.uniqueId("login")
                                         	.position(1)
                                         	.responseMessages(responseBuilder())
                                         	.parameters(
                                            	Arrays.asList(
                                                	new ParameterBuilder().description("用户名").type(new TypeResolver().resolve(String.class)).name("username").parameterType("query").parameterAccess("access").required(true).modelRef(new ModelRef("string")).build(),
                                                    new ParameterBuilder().description("密码").type(new TypeResolver().resolve(String.class)).name("password").parameterType("query").parameterAccess("access").required(true).modelRef(new ModelRef("string")).build(),
                                                    new ParameterBuilder().description("图片验证码").type(new TypeResolver().resolve(String.class)).name("vercode").parameterType("query").parameterAccess("access").required(true).modelRef(new ModelRef("string")).build()
                                                 )
                                             ).build()
                                  ),false),
						new ApiDescription("系统接口","/logout","用户登出入口",
								Arrays.asList( 
										new OperationBuilder(new CachingOperationNameGenerator())
                                        	.method(HttpMethod.GET)
                                        	.produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                                         	.summary("用户登出")
                                         	.notes("用户登出,退出当前用户在系统的会话。")//方法描述
                                         	.tags(Sets.newHashSet("登入登出"))//归类标签
                                         	.responseMessages(responseBuilder())
                                         	.uniqueId("logout")
                                         	.position(2)
                                         	.build()
                                  ),false)
						)
				);
	}

	private Set<ResponseMessage> responseBuilder() {
		Set<ResponseMessage> responseMessageList = new HashSet<>();	
        responseMessageList.add(new ResponseMessageBuilder().code(101).message("会话到期!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("Success!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("Failure!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("登录失败!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(402).message("未登录!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("没有权限!").responseModel(new ModelRef("ResponseBody")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("内部服务器错误!").build());
        return responseMessageList;
    }
}
