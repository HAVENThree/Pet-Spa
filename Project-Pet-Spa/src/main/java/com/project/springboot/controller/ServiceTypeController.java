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

import com.project.springboot.entity.ServiceType;
import com.project.springboot.services.ServicesTypeService;
@CrossOrigin
@RestController
public class ServiceTypeController {
	@Autowired
	private ServicesTypeService serviceTypeService;

	@RequestMapping(value = "/serviceTypes", method = RequestMethod.GET)
	public ResponseEntity<List<ServiceType>> findAll() {
		List<ServiceType> serviceTypes = serviceTypeService.findAll();
		if (serviceTypes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(serviceTypes, HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceTypes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceType> getServiceTypesById(@PathVariable("id") Integer id) {
		Optional<ServiceType> serviceTypes = serviceTypeService.findById(id);

		if (!serviceTypes.isPresent()) {
			return new ResponseEntity<>(serviceTypes.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(serviceTypes.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceTypes", method = RequestMethod.POST)
	public ResponseEntity<ServiceType> createServiceTypesTypes(@RequestBody ServiceType serviceTypes, UriComponentsBuilder builder) {
		serviceTypeService.save(serviceTypes);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/serviceTypes/{id}").buildAndExpand(serviceTypes.getId()).toUri());
		return new ResponseEntity<>(serviceTypes, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/serviceTypes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ServiceType> updateServiceTypes(@PathVariable("id") Integer id, @RequestBody ServiceType serviceTypes) {
		Optional<ServiceType> currentServiceTypes = serviceTypeService.findById(id);

		if (!currentServiceTypes.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentServiceTypes.get().setName(serviceTypes.getName());

		serviceTypeService.save(currentServiceTypes.get());
		return new ResponseEntity<>(currentServiceTypes.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceTypes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceType> deleteServiceTypes(@PathVariable("id") Integer id) {
		Optional<ServiceType> serviceTypes = serviceTypeService.findById(id);
		if (!serviceTypes.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		serviceTypeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
