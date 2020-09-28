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

import com.project.springboot.entity.Bill;
import com.project.springboot.entity.Service;
import com.project.springboot.services.BillService;
import com.project.springboot.services.ServicesService;

@CrossOrigin
@RestController
public class BillController {
	@Autowired BillService billService;

	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public ResponseEntity<List<Bill>> findAll() {
		List<Bill> bill = billService.findAll();
		if (bill.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bill> getBillById(@PathVariable("id") Integer id) {
		Optional<Bill> bill = billService.findById(id);

		if (!bill.isPresent()) {
			return new ResponseEntity<>(bill.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bill.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/bills", method = RequestMethod.POST)
	public ResponseEntity<Bill> createBill(@RequestBody Bill bill, UriComponentsBuilder builder) {
		billService.save(bill);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/bills/{id}").buildAndExpand(bill.getId()).toUri());
		return new ResponseEntity<>(bill, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Bill> updateBill(@PathVariable("id") Integer id, @RequestBody Bill bill) {
		Optional<Bill> currentBill = billService.findById(id);

		if (!currentBill.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentBill.get().setBillCode(bill.getBillCode());
		currentBill.get().setDate(bill.getDate());
		
		billService.save(currentBill.get());
		return new ResponseEntity<>(currentBill.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Bill> deleteBill(@PathVariable("id") Integer id) {
		Optional<Bill> bill = billService.findById(id);
		if (!bill.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		billService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
