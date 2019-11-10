package com.gagan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gagan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();

		responseMessageList.add(new ResponseMessageBuilder().code(500).message("500 message")
				.responseModel(new ModelRef("Error")).build());
		responseMessageList.add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				
				.apis(RequestHandlerSelectors.basePackage("com.gagan.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getResponseMessageList());

	}

	private ApiInfo apiInfo() {
		/*ApiInfo apiInfo = new ApiInfo("XSM-SX Rest API", "ServiceXchange Rest API.", "XSM 1.0", "Terms of service", "",
				// new
				// Contact("XSM","https://xsm-d2c.mybluemix.net/serviceManagement/","myeaddress@company.com"),
				// new Contact(java.lang.String name, java.lang.String url,
				// java.lang.String email)
				"", "");*/

		
		  ApiInfo apiInfo = new ApiInfo("Outh2 Jwt", "Java Outh2 Jwt Implementation",
		  "1.0", "", new Contact("","",""), "", "");
		 
		return apiInfo;
	}

	private List<ResponseMessage> getResponseMessageList() {

		List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();

		responseMessageList.add(new ResponseMessageBuilder().code(500).message("500 message")
				.responseModel(new ModelRef("Error")).build());
		responseMessageList.add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());
		return responseMessageList;
	}

}