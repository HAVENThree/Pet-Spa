package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.BillRepository;
import com.project.springboot.entity.Bill;
@Service
@Transactional
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	public List<Bill> findAll(){
		return billRepository.findAll();
	}
	public Optional<Bill> findById(Integer id) {
		return billRepository.findById(id);
	}
	public Bill save(Bill bill) {
		return billRepository.save(bill);
	}
	public void delete(Integer id) {
		billRepository.deleteById(id);
	}
}
