package com.artistwagon.web.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"GROUP\"")
public class Group {
	
	private Integer id;
	private String name;
	private String type;
	
	public Group() {
		
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
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
