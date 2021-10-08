package com.sangkhochil.microservices.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
	
	@GetMapping(path="/sample-api")
	public String sampleApi() {
		return "Sample API";
	}
}
