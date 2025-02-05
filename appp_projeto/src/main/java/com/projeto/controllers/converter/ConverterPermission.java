package com.projeto.controllers.converter;

import java.util.ArrayList;
import java.util.List;

import com.projeto.controllers.data.request.PermissionRequest;
import com.projeto.controllers.data.response.PermissionResponse;
import com.projeto.model.Permission;

public class ConverterPermission {

	public static PermissionResponse toPermissionResponse (Permission permission) {
		
		
		
		return new PermissionResponse(
		 permission.getIdPermission(),
		 permission.getNomePermission()
		 
		);
	}
	
	public static Permission toPermission (PermissionRequest permissionRequest) {

		return new Permission(
				 permissionRequest.getIdPermission(),
				 permissionRequest.getNomePermission()
				);
			}
 public static List<PermissionResponse> toPermissionResponse (List<Permission> listaPermission){
	 
	 List <PermissionResponse> listaPermissionResponse = new ArrayList<PermissionResponse>();
	 
	 
	 for(Permission permission: listaPermission) {
		 var permissionResponse = toPermissionResponse(permission);
		 listaPermissionResponse.add(permissionResponse);
		 
	 }
	 return listaPermissionResponse;
 }
	
}
