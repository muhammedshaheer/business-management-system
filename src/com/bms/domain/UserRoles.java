package com.bms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")

public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;

	private String role_name;
	
	public UserRoles(String username,String role){
		
		this.username = username;
		
		this.role_name = role;
		
	}

	public String getUsername() {
		
		return username;
		
	}

	public void setUsername(String username) {
		
		this.username = username;
		
	}

	public String getRole_name() {
		
		return role_name;
	
	}

	public void setRole_name(String role_name) {
	
		this.role_name = role_name;
	
	}


	
}
