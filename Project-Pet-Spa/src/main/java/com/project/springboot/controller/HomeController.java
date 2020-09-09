package com.project.springboot.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.entity.Product;
import com.project.springboot.services.ProductService;

@CrossOrigin
@RestController
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
    public String getHomepage() {
        return "index";
    }

	
	
	//	public String viewIndex(Model model) {
//		List<Product> temp = productService.findAll();
//		model.addAttribute("products", productService.findAll()
//				.stream().collect(Collectors.toList()));
//		return "index";
//	}
}
