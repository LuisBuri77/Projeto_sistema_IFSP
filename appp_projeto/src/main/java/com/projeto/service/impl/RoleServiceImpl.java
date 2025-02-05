package com.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Role;
import com.projeto.repository.Rolerepository;
import com.projeto.service.RoleService;
import com.projeto.service.execption.EntityNotFoundException;
import com.projeto.service.paginacao.PaginacaoConfig;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private Rolerepository roleRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Role buscarRolePorId(long id) {
		var role = roleRepository
		 .findById(id)
		 .orElseThrow(
		 ()-> new EntityNotFoundException("Role não encontrado"));
		return role;
	}

	@Override
	public Role salvarRole(Role role) {

		return roleRepository.saveAndFlush(role);
	}

	@Override
	public Role alterarRole(long id, Role role) {
		var roleCadastrado = buscarRolePorId(id);
		roleCadastrado.setNomeRole(role.getNomeRole());
		
		roleCadastrado = roleRepository.saveAndFlush(roleCadastrado);		
		return roleCadastrado;
	}

	@Override
	public void excluirRole(long id) {
		// TODO Auto-generated method stub
		var role = buscarRolePorId(id);
		roleRepository.delete(role);
	}

	@Override
	public Page<Role> listaPaginada(String pageNumber, String pageSize, String props, String dir) {
		Pageable pageable = PaginacaoConfig.gerarPagina(pageNumber, pageSize, props, dir);
		
		return roleRepository.findAll(pageable);
	}

}
