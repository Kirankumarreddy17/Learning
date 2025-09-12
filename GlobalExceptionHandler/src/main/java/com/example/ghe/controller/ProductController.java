package com.example.ghe.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ghe.model.Product;
import com.example.ghe.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping
public class ProductController {

	@Autowired 
	public ProductService productService;
	
	@GetMapping("/welcome")
	public String message()
	{
		return "Product Example! It's working";
	}
	
	//Parameterized Mapping
	@GetMapping("view/{id}")
	public Product getProduct(@PathVariable Long id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping("viewall")
	public Collection<Product> getAllProduct()
	{
		
		return productService.getAllProducts();
	}
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    Product savedProduct = productService.addProduct(product);
	    return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	
}