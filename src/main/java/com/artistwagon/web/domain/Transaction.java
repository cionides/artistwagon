package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	private Integer id;
	private Integer userGroupId;
	private Date date;
	private String type;
	private String description;
	private String status;
	private Double amount;
	
	public Transaction() {
		
	}
 
	public Transaction(Integer id, Integer userGroupId, 
			Date date, String type, String description, 
			String status, Double amount) {
		this.id = id;
		this.userGroupId = userGroupId;
		this.date = date;
		this.type = type;
		this.description = description;
		this.status = status;
		this.amount = amount;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRANSACTION_ID", 
		unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "USER_GROUP_ID")
	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}
	
	@Column(name = "DATE")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "AMOUNT")
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
