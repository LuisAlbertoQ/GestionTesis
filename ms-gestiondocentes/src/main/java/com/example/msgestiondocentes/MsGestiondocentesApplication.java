package com.example.msgestiondocentes;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsGestiondocentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestiondocentesApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("OPEN API MICROSERVICIO CATÁLOGO")
				.version("0.0.1")
				.description("servicios web catálogo")
				.termsOfService("http:// swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"))
		);
	}

}
