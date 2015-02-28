package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BAND")
public class Group {
	
	private Integer id;
	private String name;
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);
	
	public Group() {
		
	}
	
	public Group(Integer id, String name,
			Set<UserGroup> userGroups) {
		this.id = id;
		this.name = name;
		this.userGroups = userGroups;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GROUP_ID", 
		unique = true, nullable = false)
	public Integer getId() {
		return id;
	} 
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "NAME", length = 60)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	@OneToMany(mappedBy = "group")
	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

}
