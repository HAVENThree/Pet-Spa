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

import com.project.springboot.entity.ProductType;
import com.project.springboot.entity.Service;
import com.project.springboot.services.ProductTypeService;
import com.project.springboot.services.ServicesService;

@CrossOrigin
@RestController
public class ServiceController {
	@Autowired
	private ServicesService servicesService;

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public ResponseEntity<List<Service>> findAll() {
		List<Service> service = servicesService.findAll();
		if (service.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(service, HttpStatus.OK);
	}

	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Service> getServiceById(@PathVariable("id") Integer id) {
		Optional<Service> service = servicesService.findById(id);

		if (!service.isPresent()) {
			return new ResponseEntity<>(service.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(service.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public ResponseEntity<Service> createService(@RequestBody Service service, UriComponentsBuilder builder) {
		servicesService.save(service);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/service/{id}").buildAndExpand(service.getId()).toUri());
		return new ResponseEntity<>(service, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/service/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Service> updateService(@PathVariable("id") Integer id, @RequestBody Service service) {
		Optional<Service> currentService = servicesService.findById(id);

		if (!currentService.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		currentService.get().setName(service.getName());

		servicesService.save(currentService.get());
		return new ResponseEntity<>(currentService.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Service> deleteService(@PathVariable("id") Integer id) {
		Optional<Service> service = servicesService.findById(id);
		if (!service.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		servicesService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
