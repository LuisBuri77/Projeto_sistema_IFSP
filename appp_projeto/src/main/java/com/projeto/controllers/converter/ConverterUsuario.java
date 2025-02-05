package com.projeto.controllers.converter;

import java.util.ArrayList;
import java.util.List;

import com.projeto.controllers.data.request.UsuarioRequest;
import com.projeto.controllers.data.response.UsuarioResponse;
import com.projeto.model.Usuario;

public class ConverterUsuario {

	public static UsuarioResponse toUsuarioResponse (Usuario usuario) {
		
		
		
		return new UsuarioResponse(
		 usuario.getUsername(),
		 usuario.getEmail(),
		 usuario.getId()
		);
	}
	
	public static Usuario toUsuario (UsuarioRequest usuarioRequest) {

		return new Usuario(
				 usuarioRequest.getId(),
				 usuarioRequest.getUsername(),
				 usuarioRequest.getEmail(),
				 usuarioRequest.getPassword()
				);
			}
 public static List<UsuarioResponse> toUsuarioResponse (List<Usuario> listaUsuario){
	 
	 List <UsuarioResponse> listaUsuarioResponse = new ArrayList<UsuarioResponse>();
	 
	 
	 for(Usuario usuario: listaUsuario) {
		 var usuarioResponse = toUsuarioResponse(usuario);
		 listaUsuarioResponse.add(usuarioResponse);
		 
	 }
	 return listaUsuarioResponse;
 }
	
}
