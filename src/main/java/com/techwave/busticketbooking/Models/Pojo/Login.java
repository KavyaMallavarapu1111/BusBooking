package com.techwave.busticketbooking.Models.Pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Login {
	@Id
	@Column(length=25)
	private String userId;
	@Column(length=25)
	private String password;
	@Column(length=25)
	private String type;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userId, String password, String type) {
		super();
		this.userId = userId;
		this.password = password;
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
