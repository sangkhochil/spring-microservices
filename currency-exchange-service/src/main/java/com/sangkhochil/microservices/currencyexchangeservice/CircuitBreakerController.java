package com.sangkhochil.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping(path="/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedresponse")
	public String sampleApi() {
		logger.info("sample-api call received");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		return response.getBody();
	}
	
	public String hardCodedresponse(Exception ex) {
		return "fallback response";
	}
}
