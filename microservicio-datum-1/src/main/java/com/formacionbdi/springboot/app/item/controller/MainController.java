package com.formacionbdi.springboot.app.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ejemplo/datum")
public class MainController {
	
	@GetMapping("/saludoMicroUno")
	public String saludo(@RequestParam String parametro) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/ejemplo/datum/saludoMicroDos";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl);
		builder.queryParam("parametro", parametro);

		ResponseEntity<String> response= restTemplate.getForEntity(builder.toUriString(), String.class);
		System.out.println("Respuesta recibida del microservicio 2: " + response.getBody());
		return "Hola, soy el microservicio 1";
	}

}
