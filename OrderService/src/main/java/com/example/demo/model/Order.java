package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {

	private String OrderId;
	private String ProductId;
//	@JsonSerialize(using=JsonDateSerializer.class)
//	@JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDate orderDate;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Order(String orderId, String productId, LocalDate orderDate) {
		super();
		OrderId = orderId;
		ProductId = productId;
		this.orderDate = orderDate;
	}
	
	public Order() {
		
	}
	
	
}
