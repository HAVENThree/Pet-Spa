package com.project.springboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 10)
	private String billCode;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private Customer customer;
	
//	@OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
//	private List<InvoiceBill> invoiceBills;
	

	public Bill() {}
	


	public Bill(Integer id, String billCode, Date date, Customer customer) {
	super();
	this.id = id;
	this.billCode = billCode;
	this.date = date;
	this.customer = customer;
	}

	public String getBillCode() {
		return billCode;
	}
	public Bill(Integer id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}



	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Bill other = (Bill) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
