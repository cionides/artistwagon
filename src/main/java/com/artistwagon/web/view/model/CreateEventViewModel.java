package com.artistwagon.web.view.model;

import org.springframework.util.AutoPopulatingList;

public class CreateEventViewModel {

	private String date;
	private AutoPopulatingList<String> payees = 
			new AutoPopulatingList<String>(String.class);
	private Integer payer;
	private Double price;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public AutoPopulatingList<String> getPayees() {
		return payees;
	}
	public void setPayees(AutoPopulatingList<String> payees) {
		this.payees = payees;
	}
	
	public Integer getPayer() {
		return payer;
	}
	public void setPayer(Integer payer) {
		this.payer = payer;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
