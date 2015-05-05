package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_PAYEE")
public class EventPayee {
	
	private Integer id;
	private Event event;
	private Group group;
	private Double amount;
	private Double agencyFee;
	
	public EventPayee() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EVENT_PAYEE_ID", 
		nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EVENT_ID")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GROUP_ID")
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	@Column(name = "AMOUNT")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Column(name = "AGENCY_FEE")
	public Double getAgencyFee() {
		return agencyFee;
	}

	public void setAgencyFee(Double agencyFee) {
		this.agencyFee = agencyFee;
	}
}
