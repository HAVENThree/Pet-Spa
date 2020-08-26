package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.EmbededInvoiceBill;
import com.project.springboot.entity.InvoiceBill;

public interface InvoiceBillRepository extends JpaRepository<InvoiceBill, EmbededInvoiceBill>{

}
