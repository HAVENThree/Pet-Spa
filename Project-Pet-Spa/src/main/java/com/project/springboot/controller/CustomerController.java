package com.project.springboot.controller;

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

import com.project.springboot.entity.Customer;
import com.project.springboot.services.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customer = customerService.findAll();
		if (customer.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Optional<Customer> customer = customerService.findById(id);

		if (!customer.isPresent()) {
			return new ResponseEntity<>(customer.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customer.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
		customerService.save(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri());
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		Optional<Customer> currentCustomer = customerService.findById(id);

		if (!currentCustomer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentCustomer.get().setName(customer.getName());

		customerService.save(currentCustomer.get());
		return new ResponseEntity<>(currentCustomer.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
		Optional<Customer> customer = customerService.findById(id);
		if (!customer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
