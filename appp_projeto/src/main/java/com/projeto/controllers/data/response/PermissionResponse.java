package com.projeto.controllers.data.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class PermissionResponse {

	private Long idPermission;
	private String nomePermission;

	public PermissionResponse() {
		super();
	}


	public Long getIdPermission() {
		return idPermission;
	}

	public PermissionResponse(Long idPermission, String nomePermission) {
		super();
		this.idPermission = idPermission;
		this.nomePermission = nomePermission;
	}

	
	
	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	
	public String getNomePermission() {
		return nomePermission;
	}

	public void setNomePermission(String nomePermission) {
		this.nomePermission = nomePermission;
	}

}
