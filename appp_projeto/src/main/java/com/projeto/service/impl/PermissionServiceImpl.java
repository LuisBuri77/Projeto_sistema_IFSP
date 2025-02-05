package com.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Permission;
import com.projeto.repository.PermissionReposiitory;
import com.projeto.service.PermissionService;
import com.projeto.service.execption.EntityNotFoundException;
import com.projeto.service.paginacao.PaginacaoConfig;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionReposiitory permissionRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Permission buscarPermissionPorId(long id) {
		var permission = permissionRepository
		 .findById(id)
		 .orElseThrow(
		 ()-> new EntityNotFoundException("Permission não encontrado"));
		return permission;
	}

	@Override
	public Permission salvarPermission(Permission permission) {

		return permissionRepository.saveAndFlush(permission);
	}

	@Override
	public Permission alterarPermission(long id, Permission permission) {
		var permissionCadastrado = buscarPermissionPorId(id);
		permissionCadastrado.setNomePermission(permission.getNomePermission());
		
		permissionCadastrado = permissionRepository.saveAndFlush(permissionCadastrado);		
		return permissionCadastrado;
	}

	@Override
	public void excluirPermission(long id) {
		// TODO Auto-generated method stub
		var permission = buscarPermissionPorId(id);
		permissionRepository.delete(permission);
	}

	@Override
	public Page<Permission> listaPaginada(String pageNumber, String pageSize, String props, String dir) {
		Pageable pageable = PaginacaoConfig.gerarPagina(pageNumber, pageSize, props, dir);
		
		return permissionRepository.findAll(pageable);
	}

}
