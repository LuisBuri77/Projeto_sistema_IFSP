package com.projeto.controllers.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projeto.controllers.response.MensagemSistema;
import com.projeto.service.execption.EntityNotFoundException;
import com.projeto.service.execption.RegisteredEmail;

@RestControllerAdvice(basePackages = "com.projeto")
public class GlobalExeceptionHandler {

	@Autowired
	private MensagemSistema<?> mensagem;
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleGeneralExeceptions (EntityNotFoundException ex){
		
		return mensagem.showMensagem(ex.getMessage(),
				HttpStatus.BAD_REQUEST.value());
		
	}
	
	
	@ExceptionHandler(RegisteredEmail.class)
	public ResponseEntity<?> handleGeneralExeceptions (RegisteredEmail ex){
		
		return mensagem.showMensagem(ex.getMessage(),
				HttpStatus.BAD_REQUEST.value());
		
	}
}
