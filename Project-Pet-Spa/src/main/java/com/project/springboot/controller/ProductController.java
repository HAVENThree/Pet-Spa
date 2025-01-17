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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.springboot.entity.Product;
import com.project.springboot.entity.ProductType;
import com.project.springboot.services.FileStorageService;
import com.project.springboot.services.ProductService;
import com.project.springboot.services.ProductTypeService;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService ptService;
	 @Autowired
	    private FileStorageService fileStorageService;
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/productType/{id}", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product,@PathVariable("id") Integer id,  @RequestParam("image") MultipartFile file) {

		ProductType pt = ptService.findById(id);
		product.setProductType(pt);
//        String fileName = fileStorageService.storeFile(file);
// 
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
		return 	productService.save(product);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		Optional<Product> currentProduct = productService.findById(id);

		if (!currentProduct.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentProduct.get().setProCode(product.getProCode());
		currentProduct.get().setName(product.getName());
		currentProduct.get().setPrice(product.getPrice());

		productService.save(currentProduct.get());
		return new ResponseEntity<>(currentProduct.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") Integer id) {
		Product product = productService.findById(id).get();
//		if (!product.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		productService.delete(product.getId());
		return product;
	}
	
//	@RequestMapping(value = {"alphabetAsc" }, method = RequestMethod.GET)
//	public String ViewProductListAlphabetAsc(Model model) {
//		Comparator<Product> compareName = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());
//		List<Product> list = new ArrayList<Product>(productService.findAll());
//		Collections.sort(list, compareName);
//		model.addAttribute("products", list);
//		return "productList";
//	}
}
