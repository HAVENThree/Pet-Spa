package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.InvoiceBillRepository;
import com.project.springboot.entity.Bill;
import com.project.springboot.entity.EmbededInvoiceBill;
import com.project.springboot.entity.InvoiceBill;
@Service
@Transactional
public class InvoiceBillService {
	@Autowired
	private InvoiceBillRepository invoiceBillRepository;
	public List<InvoiceBill> findAll(){
		return invoiceBillRepository.findAll();
	}
	public InvoiceBill save(InvoiceBill invoiceBill) {
		return invoiceBillRepository.save(invoiceBill);
	}
	public void delete(Integer productId,Integer serviceId,Integer billId) {
		EmbededInvoiceBill em = new EmbededInvoiceBill(productId, serviceId, billId);
		invoiceBillRepository.deleteById(em);
	}
}
