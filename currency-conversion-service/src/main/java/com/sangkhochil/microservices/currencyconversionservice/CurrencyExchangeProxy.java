package com.sangkhochil.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConvertion retriveExchangeValue(@PathVariable String from, @PathVariable String to);
}
