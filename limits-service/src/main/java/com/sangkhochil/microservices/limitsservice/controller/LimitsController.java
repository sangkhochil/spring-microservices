package com.sangkhochil.microservices.limitsservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangkhochil.microservices.limitsservice.Configuration.Configuration;
import com.sangkhochil.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping(path = "/limits")
	public Limits retriveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
