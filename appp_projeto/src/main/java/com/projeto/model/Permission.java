package com.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Permission {
	
	private Long idPermission;
	private String nomePermission;
	
	
	
	public Permission() {
		super();
	}
	public Permission(Long idPermission, String nomePermission) {
		super();
		this.idPermission = idPermission;
		this.nomePermission = nomePermission;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERMISSION")
	public Long getIdPermission() {
		return idPermission;
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

