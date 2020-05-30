package com.formacionbdi.springboot.app.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ejemplo/datum")
public class MainController {
	
	@GetMapping("/saludoMicroTres")
	public String saludo(@RequestParam String parametro) {
		System.out.print(Integer.parseInt(parametro)*2);
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8082/ejemplo/datum/saludoMicroCuatro";
		ResponseEntity<String> response= restTemplate.getForEntity(fooResourceUrl, String.class);
		System.out.println(response.getBody() + " desde el microservicio 3");
		return "Hola, soy el microservicio 3";
	}

}
