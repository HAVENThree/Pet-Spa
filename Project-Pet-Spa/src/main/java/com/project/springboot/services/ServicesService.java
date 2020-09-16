package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.ServiceRepository;


@Service
@Transactional
public class ServicesService {
	@Autowired
	private ServiceRepository servideRepository;
	
	public List<com.project.springboot.entity.Service> findAll(){
		return servideRepository.findAll();
	}
    public Optional<com.project.springboot.entity.Service> findById(Integer id) {
        return servideRepository.findById(id);
    }
	public com.project.springboot.entity.Service save(com.project.springboot.entity.Service product) {
		return servideRepository.save(product);
	}
	public void delete(Integer id) {
		servideRepository.deleteById(id);
	}
}
