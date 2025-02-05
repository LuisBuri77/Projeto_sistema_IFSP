package com.projeto.controllers.data.response;

public class UsuarioResponse {
	
	private long id;
	private String username;
	private String email;
	
	
	public UsuarioResponse(String username, String email,long id) {
		super();
		this.username = username;
		this.email = email;
		this.id = id;
	}


	

	public long getId() {
		return id;
	}


	public void setId(long id) {
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

	public UsuarioResponse() {
		super();
	}
	
	
}
