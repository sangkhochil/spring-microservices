package com.sangkhochil.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CurrencyExchange {
	
//	The value in the @JsonProperty annotation is used for both deserializing and serializing.
//	The value in the @JsonAlias annotation is only used for deserializing.
	
	@Id
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "currency_from")
	@JsonProperty("from")
	private String from;
	
	@Column(name = "currency_to")
	@JsonProperty("to")
	private String to;
	
	@JsonProperty("rate")
	private BigDecimal exchangeRate;
	
	@JsonProperty("environment")
	private String environment;

	public CurrencyExchange() {
	}

	public CurrencyExchange(Long id, String from, String to, BigDecimal exchangeRate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
