package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.UsuarioRolePermission;
import com.projeto.model.UsurioRolePermissionId;

public interface UsuarioRolePermissionRepository extends JpaRepository<UsuarioRolePermission, UsurioRolePermissionId>{

}
