package com.projeto.controllers.data.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class RoleRequest {

	private Long idRole;
	private String nomeRole;

	public RoleRequest() {
		super();
	}

	
	
	public Long getIdRole() {
		return idRole;
	}

	public RoleRequest(Long idRole, String nomeRole) {
		super();
		this.idRole = idRole;
		this.nomeRole = nomeRole;
	}

	
	
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	
	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

}
