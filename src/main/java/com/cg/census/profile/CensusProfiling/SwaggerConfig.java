package com.cg.census.profile.CensusProfiling;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//private static final Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);

//	@Bean
//	public Docket api() {
//		LOG.info("Docket api");
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//	}
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(Arrays.asList(apiKey()));
	}

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Sig-Predict REST API Document")
	            .description("work in progress")
	            .termsOfServiceUrl("localhost")
	            .version("1.0")
	            .build();
	}

	private ApiKey apiKey() {
	    return new ApiKey("jwtToken", "Authorization", "header");
	}
	
	///@ApiOperation(value = "deleteUserById", authorizations = { @Authorization (value="jwtToken") })
	
}