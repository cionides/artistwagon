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
public class UserGroup {
	
	private Integer id;
	private User user;
	private Group group;
	private Double balance;
	private Boolean isActive;
	
	public UserGroup() {
		
	}
	
	public UserGroup(int id, String username, User user, Group group,
			Double balance) {
		this.id = id;
		this.group = group;
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
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
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
