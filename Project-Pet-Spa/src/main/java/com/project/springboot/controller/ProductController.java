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

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

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


