package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
