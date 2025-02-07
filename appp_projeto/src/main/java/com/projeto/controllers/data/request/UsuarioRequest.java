package com.projeto.controllers.data.request;

import java.util.Objects;

import jakarta.persistence.Column;


public class UsuarioRequest {

	private Long id ;
	private String username;
	private String email;
	private String password;
	public UsuarioRequest(Long id, String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsuarioRequest() {
		super();
	}
	
	 
	
	
}
