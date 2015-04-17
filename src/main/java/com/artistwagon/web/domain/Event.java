package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class Event {
	
	private Integer id;
	private String date;
	private String payee;
	private String payer;
	private Double price;
	private String payerSlug;
	private String payeeSlug;
	private String status;
	
	public Event() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EVENT_ID", 
		nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "DATE",
			nullable = false)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name = "PAYEE",
			nullable = false)
	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	@Column(name = "PAYER",
			nullable = false)
	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	@Column(name = "PRICE",
			nullable = false)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name = "STATUS",
			nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "PAYER_SLUG",
			nullable = false)
	public String getPayerSlug() {
		return payerSlug;
	}

	public void setPayerSlug(String payerSlug) {
		this.payerSlug = payerSlug;
	}
	
	@Column(name = "PAYEE_SLUG",
			nullable = false)
	public String getPayeeSlug() {
		return payeeSlug;
	}

	public void setPayeeSlug(String payeeSlug) {
		this.payeeSlug = payeeSlug;
	}
}