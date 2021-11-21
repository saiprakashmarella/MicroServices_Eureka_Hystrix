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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	public static List<Order> orders;
	static {
		orders = new ArrayList<>();
		orders.add(new Order("order1", "product1", LocalDate.now()));
		orders.add(new Order("order2", "product2", LocalDate.now()));
		orders.add(new Order("order3", "product3", LocalDate.now()));
		orders.add(new Order("order4", "product4", LocalDate.now()));
	}

	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		try {
			orders.add(order);
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders(){
		try {
			
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Optional<Order>> getOrder(@PathVariable String orderId){
		try {
			Optional<Order> order=orders.stream().filter(ord -> ord.getOrderId().equals(orderId)).findFirst();
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
