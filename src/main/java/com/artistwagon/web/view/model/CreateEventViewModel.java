package com.artistwagon.web.view.model;

import org.springframework.util.AutoPopulatingList;

public class CreateEventViewModel {

	private String date;
	private AutoPopulatingList<EventPayeeViewModel> payees = 
			new AutoPopulatingList<EventPayeeViewModel>(EventPayeeViewModel.class);
	private Integer payer;
	private Double agencyFee;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public AutoPopulatingList<EventPayeeViewModel> getPayees() {
		return payees;
	}
	public void setPayees(AutoPopulatingList<EventPayeeViewModel> payees) {
		this.payees = payees;
	}
	
	public Integer getPayer() {
		return payer;
	}
	public void setPayer(Integer payer) {
		this.payer = payer;
	}
	
	public Double getAgencyFee() {
		return agencyFee;
	}
	public void setAgencyFee(Double agencyFee) {
		this.agencyFee = agencyFee;
	}
}
