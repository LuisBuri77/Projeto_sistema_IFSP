package com.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.config.ConfigProjeto;
import com.projeto.controllers.converter.ConverterRole;
import com.projeto.controllers.data.request.RoleRequest;
import com.projeto.controllers.data.response.RoleResponse;
import com.projeto.controllers.response.MensagemSistema;
import com.projeto.model.Role;
import com.projeto.service.RoleService;
import com.projeto.service.paginacao.Pagination;

 
@RestController
@RequestMapping(value = "/rest/role")
public class RoleController {
	
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MensagemSistema<RoleResponse> mensagem;
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscarRolePorId (@PathVariable Long id) {
		
		var role = roleService.buscarRolePorId(id);

		var roleResponse = ConverterRole.toRoleResponse(role);
		
		
	
	return mensagem.showMensagem("usuário encontrado!",
			HttpStatus.OK.value(),
			roleResponse);
	}
	
	

	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salverRole(@RequestBody RoleRequest user){
	
	var role = ConverterRole.toRole(user);
	role = roleService.salvarRole(role);
	var roleResponse = ConverterRole.toRoleResponse(role);

	return mensagem.showMensagem("usuário cadastrado com sucesso!",
							HttpStatus.CREATED.value(),
							roleResponse);
	
	}
	

	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarRole(
			@PathVariable Long id, @RequestBody RoleRequest user){
			
		var role = ConverterRole.toRole(user);
		role = roleService.salvarRole(role);
		var roleResponse = ConverterRole.toRoleResponse(role);
			
	return mensagem.showMensagem("usurio modificado!",
			HttpStatus.OK.value(),
			roleResponse);
	}
	
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> excluirRole(@PathVariable Long id){
			
		roleService.excluirRole(id);
					
	return mensagem.showMensagem("Usuariio deletado!!",
			HttpStatus.OK.value());
		
	
	}

	@GetMapping(value="/listar")
	public ResponseEntity<?> listaPaginada(
			@RequestParam(defaultValue = ConfigProjeto.PAGE_NUMBER, required = false) String pageNumber,
			@RequestParam(defaultValue = ConfigProjeto.PAGE_SIZE, required = false ) String pageSize,
			@RequestParam(defaultValue = ConfigProjeto.PROPS, required = false ) String props,
			@RequestParam(defaultValue = ConfigProjeto.DIR, required = false ) String dir
			){
		
			
			var pageRole = roleService.listaPaginada(pageNumber, pageSize, props, dir);

			List<RoleResponse> listaRoleResponse = ConverterRole.toRoleResponse(pageRole.getContent());
			
			Page<RoleResponse> pageRoleResponse = new PageImpl<>(listaRoleResponse, pageRole.getPageable(), pageRole.getTotalElements());
			
			Pagination <RoleResponse> pagination = new Pagination<RoleResponse>(); 
			
			pagination.setContent(pageRoleResponse.getContent());
			pagination.setPage(pageRoleResponse.getNumber());
			pagination.setPageSize(pageRoleResponse.getSize());
			pagination.setTotalElements(pageRoleResponse.getTotalElements());
			pagination.setTotalPages(pageRoleResponse.getTotalPages());

			return mensagem.showMensagem("lista gerada!", HttpStatus.OK.value(), pagination);

	
	}
			
	
}

	

	
