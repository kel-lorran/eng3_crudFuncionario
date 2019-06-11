package util;

import dominio.EntidadeDominio;
import java.util.ArrayList;
import java.util.List;

public class Result {
	private String mensagem;
	private List<EntidadeDominio> entidades;
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String msg) {
		this.mensagem = mensagem;
	}
	
	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}
	
	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
	public void addEntidades(EntidadeDominio entidade) {
		if (entidades == null) {
			entidades = new ArrayList<EntidadeDominio>();
		}
		entidades.add(entidade);
	}

}
