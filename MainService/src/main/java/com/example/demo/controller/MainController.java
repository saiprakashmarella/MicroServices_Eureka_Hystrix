package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderApiService;

@RestController
public class MainController {

	@Autowired
	private OrderApiService orderService;
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders(){
		try {
		return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

	