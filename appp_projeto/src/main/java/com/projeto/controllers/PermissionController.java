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
import com.projeto.controllers.converter.ConverterPermission;
import com.projeto.controllers.data.request.PermissionRequest;
import com.projeto.controllers.data.response.PermissionResponse;
import com.projeto.controllers.response.MensagemSistema;
import com.projeto.model.Permission;
import com.projeto.service.PermissionService;
import com.projeto.service.paginacao.Pagination;

 
@RestController
@RequestMapping(value = "/rest/permission")
public class PermissionController {
	
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private MensagemSistema<PermissionResponse> mensagem;
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscarPermissionPorId (@PathVariable Long id) {
		
		var permission = permissionService.buscarPermissionPorId(id);

		var permissionResponse = ConverterPermission.toPermissionResponse(permission);
		
		
	
	return mensagem.showMensagem("usuário encontrado!",
			HttpStatus.OK.value(),
			permissionResponse);
	}
	
	

	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salverPermission(@RequestBody PermissionRequest user){
	
	var permission = ConverterPermission.toPermission(user);
	permission = permissionService.salvarPermission(permission);
	var permissionResponse = ConverterPermission.toPermissionResponse(permission);

	return mensagem.showMensagem("usuário cadastrado com sucesso!",
							HttpStatus.CREATED.value(),
							permissionResponse);
	
	}
	

	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarPermission(
			@PathVariable Long id, @RequestBody PermissionRequest user){
			
		var permission = ConverterPermission.toPermission(user);
		permission = permissionService.salvarPermission(permission);
		var permissionResponse = ConverterPermission.toPermissionResponse(permission);
			
	return mensagem.showMensagem("usurio modificado!",
			HttpStatus.OK.value(),
			permissionResponse);
	}
	
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> excluirPermission(@PathVariable Long id){
			
		permissionService.excluirPermission(id);
					
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
		
			
			var pagePermission = permissionService.listaPaginada(pageNumber, pageSize, props, dir);

			List<PermissionResponse> listaPermissionResponse = ConverterPermission.toPermissionResponse(pagePermission.getContent());
			
			Page<PermissionResponse> pagePermissionResponse = new PageImpl<>(listaPermissionResponse, pagePermission.getPageable(), pagePermission.getTotalElements());
			
			Pagination <PermissionResponse> pagination = new Pagination<PermissionResponse>(); 
			
			pagination.setContent(pagePermissionResponse.getContent());
			pagination.setPage(pagePermissionResponse.getNumber());
			pagination.setPageSize(pagePermissionResponse.getSize());
			pagination.setTotalElements(pagePermissionResponse.getTotalElements());
			pagination.setTotalPages(pagePermissionResponse.getTotalPages());

			return mensagem.showMensagem("lista gerada!", HttpStatus.OK.value(), pagination);

	
	}
			
	
}

	

	
