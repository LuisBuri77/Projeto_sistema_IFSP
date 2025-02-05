package com.projeto.service;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.config.ConfigProjeto;
import com.projeto.model.Usuario;

public interface UsuarioService {

	public Usuario buscarUsuarioPorId(long id);
	
	public Usuario salvarUsuario(Usuario usuario);
	
	public Usuario alterarUsuario(long id,Usuario usuario);
	
	public void excluirUsuario(long id);
	
	public Page<Usuario> listaPaginada(
			String pageNumber,
			String pageSize,
			String props,
			String dir
			);
}
