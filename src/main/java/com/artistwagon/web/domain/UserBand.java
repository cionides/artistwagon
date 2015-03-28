package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BAND")
public class UserBand {
	
	private Integer id;
	private User user;
	private Band band;
	private Double balance;
	private Boolean isActive;
	
	public UserBand() {
		
	}
	
	public UserBand(int id, String username, User user, Band band,
			Double balance) {
		this.id = id;
		this.band = band;
		this.user = user;
		this.balance = balance;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_GROUP_ID", unique = true, 
		nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "GROUP_ID")
	public Band getBand() {
		return band;
	}
	
	public void setBand(Band band) {
		this.band = band;
	}
	
	@Column(name = "BALANCE")
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "USERNAME")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "IS_ACTIVE")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
