package com.project.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.springboot.entity.ProductType;
import com.project.springboot.services.ProductTypeService;

@CrossOrigin
@RestController
@RequestMapping("")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping(value = "/productTypes", method = RequestMethod.GET)
	public ResponseEntity<List<ProductType>> findAll() {
		List<ProductType> productTypes = productTypeService.findAll();
		if (productTypes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productTypes, HttpStatus.OK);
	}

	@RequestMapping(value = "/productTypes/{id}", method = RequestMethod.GET)
	public ProductType getProductTypeById(@PathVariable("id") Integer id) {
		ProductType productType = productTypeService.findById(id);

		return productType;
	}

//	@RequestMapping(value = "/productTypes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ProductType> getProductTypesById(@PathVariable("id") Integer id) {
//		Optional<ProductType> productTypes = productTypeService.findById(id);
//
//		if (!productTypes.isPresent()) {
//			return new ResponseEntity<>(productTypes.get(), HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(productTypes.get(), HttpStatus.OK);
//	}

	@RequestMapping(value = "/productTypes", method = RequestMethod.POST)
	public ResponseEntity<ProductType> createProductTypes(@RequestBody ProductType productTypes,
			UriComponentsBuilder builder) {
		productTypeService.save(productTypes);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/productTypes/{id}").buildAndExpand(productTypes.getId()).toUri());
		return new ResponseEntity<>(productTypes, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/productTypes/{id}", method = RequestMethod.PUT)
	public ProductType updateProductTypes(@PathVariable("id") Integer id, @RequestBody @Validated ProductType productTypes) {
		
		productTypeService.findById(id);
		return productTypeService.save(productTypes);
	}

	@RequestMapping(value = "/productTypes/{id}", method = RequestMethod.DELETE)
	public void deleteProductTypes(@PathVariable("id") Integer id) {
		ProductType productType = productTypeService.findById(id);
		productTypeService.delete(productType.getId());
	}
}
