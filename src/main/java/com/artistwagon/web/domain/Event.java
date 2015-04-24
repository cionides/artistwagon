package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "EVENT")
public class Event {
	
	private Integer id;
	private String date;
	private Group owner;
	private Group payer;
	private String status;
	private Double agencyFee;
	private List<EventPayee> payees = new ArrayList<EventPayee>(); 
	
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
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PAYER_ID",
			nullable = false)
	public Group getPayer() {
		return payer;
	}

	public void setPayer(Group payer) {
		this.payer = payer;
	}
	
	@Column(name = "STATUS",
			nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="event")
	public List<EventPayee> getPayees() {
		return payees;
	}

	public void setPayees(List<EventPayee> payees) {
		this.payees = payees;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID")
	public Group getOwner() {
		return owner;
	}

	public void setOwner(Group owner) {
		this.owner = owner;
	}
	
	@Column(name = "AGENCY_FEE")
	public Double getAgencyFee() {
		return agencyFee;
	}

	public void setAgencyFee(Double agencyFee) {
		this.agencyFee = agencyFee;
	}
}
