package com.cognizant.authenticate.entity;

import java.util.Scanner;

public class Users {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	String name;
	String username;
	String password;
	String email;
	String active="n";
	String role="user";
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		
		
	}


