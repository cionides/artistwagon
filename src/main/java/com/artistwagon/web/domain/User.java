package com.artistwagon.web.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
 
	private String username;
	private String password;
	private Boolean enabled;
	private String firstName;
	private String lastName;
	private String address;
	private String token;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
 
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
		this.userRole = userRole;
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

	@Column(name = "MARQETA_TOKEN")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}