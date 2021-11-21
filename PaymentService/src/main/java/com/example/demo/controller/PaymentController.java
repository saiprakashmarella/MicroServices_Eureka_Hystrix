package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payments;

@RestController
public class PaymentController {

	public static List<Payments> payments;
	
	static {
		payments=new ArrayList<>();
		payments.add(new Payments("Payment1","Rs.1000",LocalDate.now()));
		payments.add(new Payments("Payment2","Rs.2000",LocalDate.now()));
		payments.add(new Payments("Payment3","Rs.1000",LocalDate.of(2021, 11, 11)));
		payments.add(new Payments("Payment4","Rs.4000",LocalDate.now()));
	}
	
	@PostMapping("/makePayment")
	public ResponseEntity<Payments> makePayment(@RequestBody Payments payment){
		try {
			payments.add(payment);
			return new ResponseEntity<>(payment,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllPayments")
	public ResponseEntity<List<Payments>> getAllPayments(){
		try {
			return new ResponseEntity<>(payments,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getPayment/{paymentId}")
	public ResponseEntity<Optional<Payments>> getPayment(@PathVariable String paymentId){
		try {
			Optional<Payments> payment=payments.stream().filter(paym -> paym.getPaymentId().equals(paymentId)).findFirst();
			return new ResponseEntity<>(payment,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
