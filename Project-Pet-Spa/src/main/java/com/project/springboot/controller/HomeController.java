package com.project.springboot.controller;

import java.util.List;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
=======

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> 617f3cc614deeae56eac849963a23355881a56fe
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.entity.Product;
import com.project.springboot.services.ProductService;

@CrossOrigin
@RestController
<<<<<<< HEAD
@RequestMapping(value = "/productList")
public class HomeController {
	@Autowired
	private ProductService productService;
=======
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
    public String getHomepage() {
        return "index";
    }

	
>>>>>>> 617f3cc614deeae56eac849963a23355881a56fe
	
	@GetMapping("")
	public List<Product> listProducts(){
		return productService.findAll();
	}
}
