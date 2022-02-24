package com.mps.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.entity.Product;
import com.mps.repository.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo repo;
	
	@GetMapping(value="/products",produces = "application/json")
	public ResponseEntity<List<Product>> getAllProductss()
	{
		List<Product> products = repo.findAll();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PostMapping(value="/addproduct",consumes = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody Product product)
	{
		repo.save(product);
		return new ResponseEntity<String>("Product Saved!!",HttpStatus.CREATED);
	}
	
}
