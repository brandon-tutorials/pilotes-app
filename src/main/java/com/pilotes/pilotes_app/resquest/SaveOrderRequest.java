package com.pilotes.pilotes_app.resquest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaveOrderRequest {
	
	@NotNull(message="userId is required.")
	private Long userId;

	@NotBlank(message="deliveryAddress is required.")
	@NotNull(message="deliveryAddress is required.")
	private String deliveryAddress;
	
	@NotNull(message="numberOfPilotes is required.")
	private Long numberOfPilotes;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

}
