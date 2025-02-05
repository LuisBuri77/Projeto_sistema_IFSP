package com.projeto.service;

import org.springframework.data.domain.Page;

import com.projeto.model.Permission;

public interface PermissionService {

	public Permission buscarPermissionPorId(long id);

	public Permission salvarPermission(Permission permission);

	public Permission alterarPermission(long id, Permission permission);

	public void excluirPermission(long id);

	public Page<Permission> listaPaginada(String pageNumber, String pageSize, String props, String dir);
}
