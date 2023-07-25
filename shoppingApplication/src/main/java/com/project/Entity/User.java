package com.project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String username;
	private String password;
	private String emailid;
	
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", emailid=" + emailid + "]";
	}
	
	
	
	
	
	

	
}
