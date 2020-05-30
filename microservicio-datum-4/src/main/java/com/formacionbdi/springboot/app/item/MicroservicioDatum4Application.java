package com.formacionbdi.springboot.app.item;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroservicioDatum4Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioDatum4Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(
	        RestTemplateBuilder restTemplateBuilder) {

	    return restTemplateBuilder
	            .setConnectTimeout(Duration.ofSeconds(500))
	            .setReadTimeout(Duration.ofSeconds(500))
	            .build();
	}

}
