package com.pilotes.pilotes_app.dto;

import java.math.BigDecimal;

public class OrderDTO {
	
	private Long id;
	
	private String deliveryAddress;
	
	private Long numberOfPilotes;

	private BigDecimal orderTotal; 
	
	private Boolean status;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Long getNumberOfPilotes() {
		return numberOfPilotes;
	}

	public void setNumberOfPilotes(Long numberOfPilotes) {
		this.numberOfPilotes = numberOfPilotes;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
