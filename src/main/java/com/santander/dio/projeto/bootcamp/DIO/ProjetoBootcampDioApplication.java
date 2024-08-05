package com.santander.dio.projeto.bootcamp.DIO;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API BANCARIA DIO/SANTANDER", version = "1.0.0", description = "API de sistemas bancários da DIO"))
public class ProjetoBootcampDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBootcampDioApplication.class, args);
	}

}
