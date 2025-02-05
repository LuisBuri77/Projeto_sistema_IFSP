package com.projeto.service;

import org.springframework.data.domain.Page;

import com.projeto.model.Role;

public interface RoleService {

	public Role buscarRolePorId(long id);

	public Role salvarRole(Role role);

	public Role alterarRole(long id, Role role);

	public void excluirRole(long id);

	public Page<Role> listaPaginada(String pageNumber, String pageSize, String props, String dir);
}
