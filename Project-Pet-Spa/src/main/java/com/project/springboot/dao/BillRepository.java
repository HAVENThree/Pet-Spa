package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
