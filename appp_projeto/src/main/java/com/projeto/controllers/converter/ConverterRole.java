package com.projeto.controllers.converter;

import java.util.ArrayList;
import java.util.List;

import com.projeto.controllers.data.request.RoleRequest;
import com.projeto.controllers.data.response.RoleResponse;
import com.projeto.model.Role;

public class ConverterRole {

	public static RoleResponse toRoleResponse (Role role) {
		
		
		
		return new RoleResponse(
		 role.getIdRole(),
		 role.getNomeRole()
		 
		);
	}
	
	public static Role toRole (RoleRequest roleRequest) {

		return new Role(
				 roleRequest.getIdRole(),
				 roleRequest.getNomeRole()
				);
			}
 public static List<RoleResponse> toRoleResponse (List<Role> listaRole){
	 
	 List <RoleResponse> listaRoleResponse = new ArrayList<RoleResponse>();
	 
	 
	 for(Role role: listaRole) {
		 var roleResponse = toRoleResponse(role);
		 listaRoleResponse.add(roleResponse);
		 
	 }
	 return listaRoleResponse;
 }
	
}
