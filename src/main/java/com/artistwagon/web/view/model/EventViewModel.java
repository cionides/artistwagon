package com.artistwagon.web.view.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.artistwagon.web.domain.EventPayee;
import com.artistwagon.web.domain.Group;
import com.artistwagon.web.domain.User;
import com.artistwagon.web.service.UserService;

public class EventViewModel {
	
	private Integer id;
	private String date;
	private Group owner;
	private Group payer;
	private String status;
	private Double totalAmount = 0.0;
	private List<EventPayee> payees = new ArrayList<EventPayee>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Group getOwner() {
		return owner;
	}
	public void setOwner(Group owner) {
		this.owner = owner;
	}
	
	public Group getPayer() {
		return payer;
	}
	public void setPayer(Group payer) {
		this.payer = payer;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Double gettotalAmount() {
		
		for(EventPayee eventPayee : this.getPayees()) {
			totalAmount = totalAmount + eventPayee.getAmount() + eventPayee.getAgencyFee();
		}
		
		return totalAmount;
	}
	
	public List<EventPayee> getPayees() {
		return payees;
	}

	public void setPayees(List<EventPayee> payees) {
		this.payees = payees;
	}
	
	public boolean isPaid() {
		if(this.getStatus().equals("Paid")) {
			return true;
		} else {
			return false;
		}
	}
}
