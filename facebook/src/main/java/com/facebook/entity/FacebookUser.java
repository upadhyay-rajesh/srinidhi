package com.facebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //this annotation help to map entity on table
@Table(name = "socialmedia") //this one help to change table name
public class FacebookUser {
	
	@Column(name="username", length = 34) //this annotation help to change structure of column in table like name size etc.
	private String name;
	private String password;
	
	@Id   //this annotation help to create primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //this line help to generate primary key automatically
	private long userId;
	
	
	
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
