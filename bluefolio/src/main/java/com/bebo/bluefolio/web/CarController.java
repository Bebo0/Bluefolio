package com.bebo.bluefolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bebo.bluefolio.domain.Stock;
import com.bebo.bluefolio.domain.StockRepository;

@RestController
public class CarController {
	
	@Autowired
	private StockRepository repository;
	
	// By default, @RequestMapping handles all HTTP methods (GET PUT POST etc.)
	// You can define which method is accepted with the following:
	// @RequestMapping("/cars", method=GET). Now this method handles only GET requests
	// from the /cars endpoint.
	@RequestMapping("/cars") // When a user navigates to the /cars endpoint, getCars() is executed.
	public Iterable<Stock> getCars() {
		return repository.findAll();
		
		
		
		
		
		
		
	}
		
}
