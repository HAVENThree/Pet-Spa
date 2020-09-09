package com.project.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_bill")
public class InvoiceBill implements Serializable{
	@EmbeddedId
	private EmbededInvoiceBill id = new EmbededInvoiceBill();
	@ManyToOne()
	@MapsId("productId")
	private Product product;
	
	@ManyToOne()
	@MapsId("serviceId")
	private Service service;
	
	@ManyToOne()
	@MapsId("billId")
	private Bill bill;
	
	@Column(length = 10)
	private Integer amount;
	@Column(length = 10)
	private Integer price;
	@Column(length = 200)
	private String discription;
	
	
	public InvoiceBill() {}
	public InvoiceBill(EmbededInvoiceBill id, Product product, Service service, Bill bill, Integer amount,
			Integer price, String discription) {
		super();
		this.id = id;
		this.product = product;
		this.service = service;
		this.bill = bill;
		this.amount = amount;
		this.price = price;
		this.discription = discription;
	}
	public EmbededInvoiceBill getId() {
		return id;
	}
	public void setId(EmbededInvoiceBill id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceBill other = (InvoiceBill) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}
	
	
}
