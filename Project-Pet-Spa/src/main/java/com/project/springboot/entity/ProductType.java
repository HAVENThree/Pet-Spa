package com.project.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_type")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 10)
	private String ptypCode;
	@Column(length = 50)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
	
	public ProductType() {}

	public ProductType(Integer id, String ptypCode, String name, List<Product> products) {
		super();
		this.id = id;
		this.ptypCode = ptypCode;
		this.name = name;
		this.products = products;
	}
	
	public String getPtypCode() {
		return ptypCode;
	}

	public void setPtypCode(String ptypCode) {
		this.ptypCode = ptypCode;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
