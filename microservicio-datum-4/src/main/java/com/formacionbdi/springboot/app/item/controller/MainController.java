package com.formacionbdi.springboot.app.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ejemplo/datum")
public class MainController {
	
	@GetMapping("/saludoMicroCuatro")
	public String saludo() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8083/ejemplo/datum/saludoMicroCinco";
		ResponseEntity<String> response= restTemplate.getForEntity(fooResourceUrl, String.class);
		System.out.println(response.getBody() + " desde el microservicio 4");
		return "Hola, soy el microservicio 4";
	}

}
