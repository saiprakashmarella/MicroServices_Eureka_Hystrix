package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Order;
import com.example.demo.model.Payments;

@Service
public class OrderApiService {
	
	@Value("${payment.username}")
	private  String pUsername;


	@Value("${payment.password}")
	private  String pPswd;;

	@Value("${order.username}")
	private String oUsername;


	@Value("${order.password}")
	private  String oPswd;;
	
	private HttpHeaders getHeaders() {
		String adminuserCredentials = oUsername+":"+oPswd;
		String encodedCredentials = new String(Base64.encodeBase64(adminuserCredentials.getBytes()));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic " + encodedCredentials);
		return httpHeaders;
	}

	@Autowired
	private RestTemplate restTemplate;

	public List<Order> getAllOrders(){
		 HttpHeaders httpHeaders = getHeaders();
		 HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<Order[]> response=restTemplate.exchange("http://GATEWAY-SERVICE/order/getAllOrders", HttpMethod.GET,httpEntity,Order[].class);
		List<Order> orders=Arrays.asList(response.getBody());
		return orders;
	}
	
	public List<Payments> getAllPayments(){
		 HttpHeaders httpHeaders = getHeaders();
		 HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<Payments[]> response=restTemplate.exchange("http://PaymentService/getAllPayments", HttpMethod.GET,httpEntity,Payments[].class);
		List<Payments> payments=Arrays.asList(response.getBody());
		return payments;
	}
}
 