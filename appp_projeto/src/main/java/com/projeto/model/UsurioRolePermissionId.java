package com.projeto.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable

public class UsurioRolePermissionId {

	private Long idUsuario;
	private Long idRole;
	private Long idPermission;
	public UsurioRolePermissionId() {
		super();
	}
	public UsurioRolePermissionId(Long idUsuario, Long idRole, Long idPermission) {
		super();
		this.idUsuario = idUsuario;
		this.idRole = idRole;
		this.idPermission = idPermission;
	}
	@Column(name = "ID_USUARIO", insertable = false, updatable = false,nullable = false)
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Column(name = "ID_ROLE", insertable = false, updatable = false,nullable = false)
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	@Column(name = "ID_PERMISSION", insertable = false, updatable = false,nullable = false)
	public Long getIdPermission() {
		return idPermission;
	}
	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPermission, idRole, idUsuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsurioRolePermissionId other = (UsurioRolePermissionId) obj;
		return Objects.equals(idPermission, other.idPermission) && Objects.equals(idRole, other.idRole)
				&& Objects.equals(idUsuario, other.idUsuario);
	}
	
	
	
}
