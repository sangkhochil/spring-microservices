package com.sangkhochil.microservices.currencyconversionservice;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyConvertion {
	
//	The value in the @JsonProperty annotation is used for both deserializing and serializing.
//	The value in the @JsonAlias annotation is only used for deserializing.

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("from")
	private String from;
	
	@JsonProperty("to")
	private String to;
	
	private BigDecimal quantity;
	
	@JsonProperty("rate")
	private BigDecimal conversionRate;
	
	private BigDecimal totalCalculatedAmount;
	
	@JsonProperty("environment")
	private String environment;

	public CurrencyConvertion() {
	}

	public CurrencyConvertion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionRate,
			String environment) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.quantity = quantity;
		this.environment = environment;
		this.totalCalculatedAmount = this.quantity.multiply(conversionRate);
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

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
