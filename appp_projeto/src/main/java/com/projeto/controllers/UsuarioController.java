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
import com.projeto.controllers.converter.ConverterUsuario;
import com.projeto.controllers.data.request.UsuarioRequest;
import com.projeto.controllers.data.response.UsuarioResponse;
import com.projeto.controllers.response.MensagemSistema;
import com.projeto.model.Usuario;
import com.projeto.service.UsuarioService;
import com.projeto.service.paginacao.Pagination;

 
@RestController
@RequestMapping(value = "/rest/usuario")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MensagemSistema<UsuarioResponse> mensagem;
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioPorId (@PathVariable Long id) {
		
		var usuario = usuarioService.buscarUsuarioPorId(id);

		var usuarioResponse = ConverterUsuario.toUsuarioResponse(usuario);
		
		
	
	return mensagem.showMensagem("usuário encontrado!",
			HttpStatus.OK.value(),
			usuarioResponse);
	}
	
	

	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salverUsuario(@RequestBody UsuarioRequest user){
	
	var usuario = ConverterUsuario.toUsuario(user);
	usuario = usuarioService.salvarUsuario(usuario);
	var usuarioResponse = ConverterUsuario.toUsuarioResponse(usuario);

	return mensagem.showMensagem("usuário cadastrado com sucesso!",
							HttpStatus.CREATED.value(),
							usuarioResponse);
	
	}
	

	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarUsuario(
			@PathVariable Long id, @RequestBody UsuarioRequest user){
			
		var usuario = ConverterUsuario.toUsuario(user);
		usuario = usuarioService.salvarUsuario(usuario);
		var usuarioResponse = ConverterUsuario.toUsuarioResponse(usuario);
			
	return mensagem.showMensagem("usurio modificado!",
			HttpStatus.OK.value(),
			usuarioResponse);
	}
	
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id){
			
		usuarioService.excluirUsuario(id);
					
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
		
			
			var pageUsuario = usuarioService.listaPaginada(pageNumber, pageSize, props, dir);

			List<UsuarioResponse> listaUsuarioResponse = ConverterUsuario.toUsuarioResponse(pageUsuario.getContent());
			
			Page<UsuarioResponse> pageUsuarioResponse = new PageImpl<>(listaUsuarioResponse, pageUsuario.getPageable(), pageUsuario.getTotalElements());
			
			Pagination <UsuarioResponse> pagination = new Pagination<UsuarioResponse>(); 
			
			pagination.setContent(pageUsuarioResponse.getContent());
			pagination.setPage(pageUsuarioResponse.getNumber());
			pagination.setPageSize(pageUsuarioResponse.getSize());
			pagination.setTotalElements(pageUsuarioResponse.getTotalElements());
			pagination.setTotalPages(pageUsuarioResponse.getTotalPages());

			return mensagem.showMensagem("lista gerada!", HttpStatus.OK.value(), pagination);

	
	}
			
	
}

	

	
