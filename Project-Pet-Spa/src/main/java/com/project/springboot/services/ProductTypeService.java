package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.ProductTypeRepository;
import com.project.springboot.entity.ProductType;

@Service
@Transactional
public class ProductTypeService {
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	public List<ProductType> findAll(){
		return productTypeRepository.findAll();
	}
    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).get();
    }
	public ProductType save(ProductType productType){
		return productTypeRepository.save(productType);
	}
	public void delete(Integer id) {
		productTypeRepository.deleteById(id);
	}
}
