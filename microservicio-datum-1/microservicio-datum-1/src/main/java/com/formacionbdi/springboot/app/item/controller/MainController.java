package com.formacionbdi.springboot.app.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.opentracing.Tracer;

@RestController
@RequestMapping("/ejemplo/datum")
public class MainController {
	
	
	@Autowired
    private Tracer tracer;
	
	@GetMapping("/saludoMicroUno")
	public String saludo(@RequestHeader("User-Agent") String userAgent,@RequestHeader(value = "user-preference", required = false) String userPreference,@RequestParam String parametro) {
		
		tracer.activeSpan().setBaggageItem("user-agent", userAgent);
        if (userPreference != null && !userPreference.isEmpty()) {
            tracer.activeSpan().setBaggageItem("user-preference", userPreference);
        }

		
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/ejemplo/datum/saludoMicroDos";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl);
		builder.queryParam("parametro", parametro);

		ResponseEntity<String> response= restTemplate.getForEntity(builder.toUriString(), String.class);
		System.out.println("Respuesta recibida del microservicio 2: " + response.getBody());
		return "Hola, soy el microservicio 1";
	}

}
