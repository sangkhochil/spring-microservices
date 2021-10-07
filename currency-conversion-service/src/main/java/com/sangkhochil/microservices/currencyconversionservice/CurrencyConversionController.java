package com.sangkhochil.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertion calculateCurrencyConversion(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConvertion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConvertion.class,
				uriVariable);
		
		CurrencyConvertion conversionData = responseEntity.getBody();
		
		return new CurrencyConvertion(conversionData.getId(), from, to, quantity, conversionData.getConversionRate(), conversionData.getEnvironment());
	}
}
