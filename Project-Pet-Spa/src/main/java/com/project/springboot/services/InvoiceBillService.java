package com.project.springboot.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.InvoiceBillRepository;
import com.project.springboot.entity.EmbededInvoiceBill;
import com.project.springboot.entity.InvoiceBill;
import com.project.springboot.entity.ProductType;
@Service
@Transactional
public class InvoiceBillService {
	@Autowired
	private InvoiceBillRepository invoiceBillRepository;
	
	
	public InvoiceBill save(InvoiceBill invoiceBill) {
		return invoiceBillRepository.save(invoiceBill);
	}
	public void delete(Integer productId, Integer billId) {
		EmbededInvoiceBill em = new EmbededInvoiceBill(productId, billId);
		invoiceBillRepository.deleteById(em);
	}
}
