package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	
	@RequestMapping("/orderFallBack")
	public Mono<String> orderFallBack(){
		return Mono.just("Order Service is down or taking too long to respond. Please try again after sometime");
	}
	
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentFallBack(){
		return Mono.just("Payment Service is down or taking too long to respond. Please try again after sometime");
	}
}
