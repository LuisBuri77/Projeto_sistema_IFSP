package com.projeto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Table
@Entity
public class UsuarioRolePermission {

	private UsurioRolePermissionId id;
	
	private Usuario usuario;
	private Role role;
	private Permission permission;
	public UsuarioRolePermission() {
		super();
	}
	public UsuarioRolePermission(UsurioRolePermissionId id) {
		super();
		this.id = id;
	}
	public UsuarioRolePermission(UsurioRolePermissionId id, Usuario usuario, Role role, Permission permission) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.role = role;
		this.permission = permission;
	}
	
	@EmbeddedId
	public UsurioRolePermissionId getId() {
		return id;
	}
	public void setId(UsurioRolePermissionId id) {
		this.id = id;
	}
	
	@ManyToOne
	@MapsId("idUsuario")
	@JoinColumn(name ="ID_USUARIO",  insertable = false, updatable = false,nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	@MapsId("idRole")
	@JoinColumn(name ="ID_ROLE",  insertable = false, updatable = false,nullable = false)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne
	@MapsId("idPermission")
	@JoinColumn(name ="ID_PERMISSION",  insertable = false, updatable = false,nullable = false)
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	
	
	
}
