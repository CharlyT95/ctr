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

	@GetMapping("/saludoMicroDos")
	public String saludo(@RequestParam String parametro) {
		String respuesta = "Hola, soy el microservicio 2";
		try {
			RestTemplate restTemplate = new RestTemplate();
			String fooResourceUrl = "http://localhost:8081/ejemplo/datum/saludoMicroTres";
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl);
			builder.queryParam("parametro", parametro);
			ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
			System.out.println(response.getBody() + " desde el microservicio 2");

		} catch (Exception ex) {
			System.out.print(ex);
			respuesta = "El Microservice 3 fallo!!!! :(";
		}

		return respuesta;
	}

}
