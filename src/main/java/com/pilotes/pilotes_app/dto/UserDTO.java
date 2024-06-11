package com.pilotes.pilotes_app.dto;


import java.io.Serializable;
import java.util.List;


public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	
	private String phone;
	
	private List<OrderDTO> orders;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	
}
