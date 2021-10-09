package com.sangkhochil.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping(path="/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedresponse")
	public String sampleApi() {
		logger.info("sample-api get called");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		return response.getBody();
	}
	
	@GetMapping(path="/sample-circuitbreaker-api")
	@CircuitBreaker(name="default", fallbackMethod = "hardCodedresponse")
	public String sampleCircuitBreakerApi() {
		logger.info("sample-circuitbreaker-api get called");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		return response.getBody();
	}
	
	@GetMapping(path="/sample-ratelimiter-api")
	@RateLimiter(name="default", fallbackMethod = "hardCodedresponse")
	public String sampleRateLimiterApi() {
		logger.info("sample-ratelimiter-api get called");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		return response.getBody();
	}
	
	public String hardCodedresponse(Exception ex) {
		return "fallback response";
	}
}
