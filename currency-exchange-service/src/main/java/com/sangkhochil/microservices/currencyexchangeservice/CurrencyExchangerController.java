package com.sangkhochil.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangerController {
	@Autowired
	CurrencyExchangeRepository reposity;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from, to, BigDecimal.valueOf(85.909));
		
		CurrencyExchange currencyExchange = reposity.findByFromAndTo(from, to);
		if(currencyExchange == null)
			throw new RuntimeException(String.format("Unable to retrive convertion rate for %s to %s",from, to));
		
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}
