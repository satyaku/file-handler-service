package com.fileManagementApp.filehandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FileHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileHandlerServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fileManagementApp"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfoBuilder()
				.title("fileManagement - File Handling Service")
				.description("CRUD Apis to upload, download, copy or delete a file.")
				.contact(new Contact("Satyam kumar", "", "satyam.bppimt@gmail.com"))
				.build();
	}
	

}
