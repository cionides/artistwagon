package com.artistwagon.web.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
 
	private String username;
	private String password;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);
 
	public User() {
	}
 
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
 
	public User(String username, String password, 
		boolean enabled, Set<UserRole> userRole,
		Set<UserGroup> userGroups){
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
		this.userGroups = userGroups;
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
 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}
 
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}
	
	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
}