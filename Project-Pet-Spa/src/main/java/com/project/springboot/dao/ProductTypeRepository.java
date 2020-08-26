package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

}
