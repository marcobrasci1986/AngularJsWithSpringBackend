package com.realdolmen.domain;

import javax.persistence.Entity;

@Entity
public class Roles extends AbstractEntity{
	
	private String username; 
	private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	


}
