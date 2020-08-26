package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
