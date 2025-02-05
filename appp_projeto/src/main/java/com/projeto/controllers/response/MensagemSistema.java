package com.projeto.controllers.response;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.projeto.service.paginacao.Pagination;;


@Component
public class MensagemSistema <T> {

	private Integer status; 
	private String mensagem;
	private T objeto;
	private List<T>lista;
	private Pagination<T>page;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@JsonInclude(Include.NON_NULL)
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	@JsonInclude(Include.NON_NULL)
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	@JsonInclude(Include.NON_NULL)
	public List<T> getLista() {
		return lista;
	}
	public void setLista(List<T> lista) {
		this.lista = lista;
	}
	@JsonInclude(Include.NON_NULL)
	public Pagination<T> getPage() {
		return page;
	}
	public void setPage(Pagination<T> page) {
		this.page = page;
	}
	
	public ResponseEntity<?> showMensagem(String mensagem, Integer status){
		ClearData ();
		this.setMensagem(mensagem);
		this.setStatus(status);
		return ResponseEntity.status(status).body(this);		
	}
	
	
	public ResponseEntity<?> showMensagem(String mensagem, Integer status, T objeto){
		ClearData ();
		this.setMensagem(mensagem);
		this.setObjeto(objeto);
		this.setStatus(status);
		return ResponseEntity.status(status).body(this);		
	}
	
	
	public ResponseEntity<?> showMensagem(String mensagem, Integer status,List <T> lista){
		ClearData ();
		this.setMensagem(mensagem);
		this.setLista(lista);
		this.setStatus(status);
		return ResponseEntity.status(status).body(this);		
	}
	
	
	
	public ResponseEntity<?> showMensagem(String mensagem, Integer status,Pagination <T> page){
		ClearData ();
		this.setMensagem(mensagem);
		this.setPage(page);
		this.setStatus(status);
		return ResponseEntity.status(status).body(this);	
	}
	
	private void ClearData () {
		
		this.setMensagem(null);
		this.setPage(null);
		this.setStatus(null);
		this.setObjeto(null);
		this.setLista(null);
	}
}




