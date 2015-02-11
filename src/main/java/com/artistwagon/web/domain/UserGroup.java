package com.artistwagon.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_GROUP")
public class UserGroup {
	
	private Integer id;
	private User user;
	private Group group;
	private Double balance;
	
	public UserGroup() {
		
	}
	
	public UserGroup(int id, User user, Group group,
			double balance) {
		this.id = id;
		this.user = user;
		this.group = group;
		this.balance = balance;
	}
	
	@Id
	@Column(name = "USER_GROUP_ID", unique = true, 
		nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
    @JoinColumn(name = "USERNAME")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
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
	
}
