package com.bms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private String passwordSalt;
	
	public User(String username,String password){
		
		this.username = username;
		
		this.password = password;
		
	}

	public String getUsername() {
		
		return username;
	
	}

	public void setUsername(String username) {
	
		this.username = username;
	
	}

	public String getPassword() {
	
		return password;
	
	}

	public void setPassword(String password) {
	
		this.password = password;
	
	}

	public String getPasswordSalt() {
	
		return passwordSalt;
	
	}

	public void setPasswordSalt(String passwordSalt) {
	
		this.passwordSalt = passwordSalt;
	
	}

	

	
}
