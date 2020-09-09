package com.project.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.entity.Product;
import com.project.springboot.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/productList")
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public List<Product> listProducts(){
		return productService.findAll();
	}
}
