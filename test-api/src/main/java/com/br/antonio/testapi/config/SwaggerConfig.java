package com.br.antonio.testapi.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.br.antonio.testapi"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(
				"API REST ALUNO",
				"API REST para CRUD aluno", 
				"VERSAO 1.0", null, "ak.cremonese@gmail.com", null, null);
		
		 return apiInfo;
	}
}
