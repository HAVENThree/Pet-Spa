package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.CustomerRepository;
import com.project.springboot.entity.Customer;
@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	public Optional<Customer> findById(Integer id) {
		return customerRepository.findById(id);
	}
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
}
