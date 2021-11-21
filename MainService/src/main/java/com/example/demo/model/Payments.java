package com.example.demo.model;

import java.time.LocalDate;

public class Payments {

	private String paymentId;
	private String paymentAmount;
	private LocalDate paymentDate;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Payments(String paymentId, String paymentAmount, LocalDate paymentDate) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}

	public Payments() {

	}
}
