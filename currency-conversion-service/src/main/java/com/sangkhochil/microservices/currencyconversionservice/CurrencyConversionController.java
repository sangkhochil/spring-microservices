package com.sangkhochil.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertion calculateCurrencyConversion(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity) {
		
		String port = environment.getProperty("local.server.port");
		
		return new CurrencyConvertion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, port);
	}
}
