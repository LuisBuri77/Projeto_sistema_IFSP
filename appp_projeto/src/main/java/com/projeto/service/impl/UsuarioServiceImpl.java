package com.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;
import com.projeto.service.UsuarioService;
import com.projeto.service.execption.EntityNotFoundException;
import com.projeto.service.paginacao.PaginacaoConfig;
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Usuario buscarUsuarioPorId(long id) {
		var usuario = usuarioRepository
		 .findById(id)
		 .orElseThrow(
		 ()-> new EntityNotFoundException("Usuario não encontrado"));
		return usuario;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {

		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public Usuario alterarUsuario(long id, Usuario usuario) {
		var usuarioCadastrado = buscarUsuarioPorId(id);
		usuarioCadastrado.setEmail(usuario.getEmail());
		usuarioCadastrado.setUsername(usuario.getUsername());
		
		usuarioCadastrado = usuarioRepository.saveAndFlush(usuarioCadastrado);		
		return usuarioCadastrado;
	}

	@Override
	public void excluirUsuario(long id) {
		// TODO Auto-generated method stub
		var usuario = buscarUsuarioPorId(id);
		usuarioRepository.delete(usuario);
	}

	@Override
	public Page<Usuario> listaPaginada(String pageNumber, String pageSize, String props, String dir) {
		Pageable pageable = PaginacaoConfig.gerarPagina(pageNumber, pageSize, props, dir);
		
		return usuarioRepository.findAll(pageable);
	}

}
