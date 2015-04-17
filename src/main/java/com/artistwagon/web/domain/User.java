package com.artistwagon.web.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER")
public class User {
 
	private String username;
	private String password;
	private Boolean enabled;
	private Group group;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
 
	public User() {
	}
 
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
 
	public User(String username, String password, 
		boolean enabled, Set<UserRole> userRole){
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRole;
	}
 
	@Id
	@Column(name = "USERNAME", unique = true, 
		nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	@Column(name = "PASSWORD", 
		nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	@Column(name = "IS_ENABLED", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}
 
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}
 
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "GROUP_ID")
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	@Transient
	public Boolean isPayer() {
		
		if(this.getGroup().getType().equals("Venue")) {
			return true;
		} else {
			return false;
		}	
	}
	
	@Transient
	public Boolean isPayee() {
		
		if(this.getGroup().getType().equals("Artist") || this.getGroup().getType().equals("Agent")) {
			return true;
		} else {
			return false;
		}	
	}
}