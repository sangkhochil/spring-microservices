package com.sangkhochil.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangkhochil.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {
	@GetMapping(path = "/limits")
	public Limits retriveLimits() {
		return new Limits(1, 1000);
	}
}
