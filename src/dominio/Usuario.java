package dominio;

import dominio.EntidadeDominio;
import dominio.Funcionario;

public class Usuario extends EntidadeDominio {
	private String login;
	private String senha;
	private boolean podeCadastrar;
	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public boolean isPodeCadastrar() {
		return podeCadastrar;
	}
	public void setPodeCadastrar(boolean podeCadastrar) {
		this.podeCadastrar = podeCadastrar;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario(int id, String login, String senha, boolean podeCadastrar,
			Funcionario funcionario) {
		super();
		this.login = login;
		this.senha = senha;
		this.podeCadastrar = podeCadastrar;
		this.funcionario = funcionario;
	}

	
}

