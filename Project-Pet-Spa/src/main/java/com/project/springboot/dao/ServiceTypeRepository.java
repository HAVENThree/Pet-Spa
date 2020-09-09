package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer>{

}
