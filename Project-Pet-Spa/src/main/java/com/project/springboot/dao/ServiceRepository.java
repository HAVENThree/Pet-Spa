package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer>{

}
