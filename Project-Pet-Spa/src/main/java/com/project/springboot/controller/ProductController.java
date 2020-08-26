package com.project.springboot.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.springboot.entity.Product;
import com.project.springboot.services.ProductService;

@Controller
public class ProductController {
//	@Autowired
//	private ProductService productService;
//
//	@RequestMapping(value = { "/productList" }, method = RequestMethod.GET)
//	public String ViewProductList(Model model) {
//		model.addAttribute("products", productService.findAll());
//		return "productList";
//	}
//
//	@RequestMapping(value = { "alphabetAsc" }, method = RequestMethod.GET)
//	public String ViewProductListAlphabetAsc(Model model) {
//		Comparator<Product> compareName = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());
//		List<Product> list = new ArrayList<Product>(productService.findAll());
//		Collections.sort(list, compareName);
//		model.addAttribute("products", list);
//		return "productList";
//	}
//
//	@RequestMapping(value = { "alphabetDesc" }, method = RequestMethod.GET)
//	public String ViewProductListAlphabetDesc(Model model) {
//		Comparator<Product> compareName = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());
//		List<Product> list = new ArrayList<Product>(productService.findAll());
//		Collections.sort(list, compareName.reversed());
//		model.addAttribute("products", list);
//		return "productList";
//	}
//
//	@RequestMapping(value = { "highToLowPrice" }, method = RequestMethod.GET)
//	public String ViewProductListHighToLowPrice(Model model) {
//		Comparator<Product> comparePrice = (Product p1, Product p2) -> p1.getPrice().compareTo(p2.getPrice());
//		List<Product> list = new ArrayList<Product>(productService.findAll());
//		Collections.sort(list, comparePrice.reversed());
//		model.addAttribute("products", list);
//		return "productList";
//	}
//
//	@RequestMapping(value = { "lowToHighPrice" }, method = RequestMethod.GET)
//	public String ViewProductListLowToHighPrice(Model model) {
//		Comparator<Product> comparePrice = (Product p1, Product p2) -> p1.getPrice().compareTo(p2.getPrice());
//		List<Product> list = new ArrayList<Product>(productService.findAll());
//		Collections.sort(list, comparePrice);
//		model.addAttribute("products", list);
//		return "productList";
//	}

}
