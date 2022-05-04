package com.BackendTech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguracion {
	
	@Bean
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Prueba Tech- API SERVICIOS RESTFULL ").description(
				"Api Rest - es el directorio de servicios enfocados al uso del los servicios rest.")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("").version("1.0.0")
				.contact(new springfox.documentation.service.Contact("Backend - Tech Mahindra", "",
						""))
				.build();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.BackendTech.controlador")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

}
