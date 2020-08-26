package com.project.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class EmbededInvoiceBill implements Serializable{
	
	@Column(name = "product_id",nullable = false)
	private Integer productId;
	
	@Column(name="bill_id",nullable = false)
	private Integer billId;
	
	public EmbededInvoiceBill() {}

	public EmbededInvoiceBill(Integer productId, Integer billId) {
		super();
		this.productId = productId;
		this.billId = billId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		EmbededInvoiceBill other = (EmbededInvoiceBill) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	
	
}
