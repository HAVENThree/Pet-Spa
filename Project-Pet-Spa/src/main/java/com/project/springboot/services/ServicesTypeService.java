package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.entity.ServiceType;


@Service
@Transactional
public class ServicesTypeService {
	@Autowired
	private ServicesTypeService serviceTypeRepository;
	
	public List<ServiceType> findAll(){
		return serviceTypeRepository.findAll();
	}
    public Optional<ServiceType> findById(Integer id) {
        return serviceTypeRepository.findById(id);
    }
	public ServiceType save(ServiceType serviceType) {
		return serviceTypeRepository.save(serviceType);
	}
	public void delete(Integer id) {
		serviceTypeRepository.delete(id);;
	}
}
