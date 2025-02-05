package com.projeto.controllers.data.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class PermissionRequest {

	private Long idPermission;
	private String nomePermission;

	public PermissionRequest() {
		super();
	}

	
	
	public Long getIdPermission() {
		return idPermission;
	}

	public PermissionRequest(Long idPermission, String nomePermission) {
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
