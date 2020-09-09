package com.project.springboot.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.springboot.entity.Product;
import com.project.springboot.services.ProductService;

<<<<<<< HEAD
@CrossOrigin
@RestController
=======
@Controller
>>>>>>> 617f3cc614deeae56eac849963a23355881a56fe
public class ProductController {
	@Autowired
	private ProductService productService;

<<<<<<< HEAD
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(
            @PathVariable("id") Integer id) {
        Optional<Product> product = productService.findById(id);

        if (!product.isPresent()) {
            return new ResponseEntity<>(product.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(
            @RequestBody Product product,
            UriComponentsBuilder builder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/products/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") Integer id,
            @RequestBody Product product) {
        Optional<Product> currentProduct = productService.findById(id);

        if (!currentProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentProduct.get().setName(product.getName());
        currentProduct.get().setPrice(product.getPrice());
=======
	@RequestMapping("/products")
	public String ViewProductList(Model model) {
		return "products";
	}
	
	 @RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	    public String productList(Model model) {
	 
	        model.addAttribute("products", productService.findAll());
	 
	        return "producrs";
	    }

//	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
//	public String ViewProductList(Model model) {
//		model.addAttribute("products", productService.findAll());
//		return "products";
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
>>>>>>> 617f3cc614deeae56eac849963a23355881a56fe

        productService.save(currentProduct.get());
        return new ResponseEntity<>(currentProduct.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(
            @PathVariable("id") Integer id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


