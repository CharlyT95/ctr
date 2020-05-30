package com.formacionbdi.springboot.app.item.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejemplo/datum")
public class MainController {
	
	@GetMapping("/saludoMicroCinco")
	public String saludo() {
		/*RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8090/ejemplo/datum/saludoMicroUno";
		ResponseEntity<String> response= restTemplate.getForEntity(fooResourceUrl, String.class);
		System.out.println(response.getBody() + " desde el microservicio 5");*/
		return "Hola, soy el microservicio 5";
	}

}
