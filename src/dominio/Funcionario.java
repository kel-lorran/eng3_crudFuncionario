package dominio;

import java.util.Date;

public class Funcionario extends EntidadeDominio {
	private String status;
	private String nome;
	private String matricula;
	private String setor;
	private String regional;
	private String email;
	private String cadastradoPor;
	private String cpf;
	private Date dtCadastro;
	private String cargo;
	private Date dtContratacao;
	
	public Funcionario(String status, String nome, String matricula, String setor, String regional, String email,
			String cadastradoPor, String cpf, Date dtCadastro, String cargo, Date dtContratacao) {
		super();
		this.status = status;
		this.nome = nome;
		this.matricula = matricula;
		this.setor = setor;
		this.regional = regional;
		this.email = email;
		this.cadastradoPor = cadastradoPor;
		this.cpf = cpf;
		this.dtCadastro = dtCadastro;
		this.cargo = cargo;
		this.dtContratacao = dtContratacao;
	}
	
	public Funcionario(int id, String status, String nome, String matricula, String setor, String regional, String email,
			String cadastradoPor, String cpf, Date dtCadastro, String cargo, Date dtContratacao) {
		super();
		super.setId(id);
		this.status = status;
		this.nome = nome;
		this.matricula = matricula;
		this.setor = setor;
		this.regional = regional;
		this.email = email;
		this.cadastradoPor = cadastradoPor;
		this.cpf = cpf;
		this.dtCadastro = dtCadastro;
		this.cargo = cargo;
		this.dtContratacao = dtContratacao;
	}
	
	// 07 de maio - Criei um construtor sem a data cadastro, para que so preencha esse campo quando salvar no banco
	public Funcionario(String status, String nome, String matricula, String setor, String regional, String email,
			String cadastradoPor, String cpf, String cargo, Date dtContratacao) {
		super();
		this.status = status;
		this.nome = nome;
		this.matricula = matricula;
		this.setor = setor;
		this.regional = regional;
		this.email = email;
		this.cadastradoPor = cadastradoPor;
		this.cpf = cpf;
		this.cargo = cargo;
		this.dtContratacao = dtContratacao;
	}

	public Funcionario(int id, String nome2) {
		super.setId(id);
		this.nome = nome2;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getRegional() {
		return regional;
	}
	public void setRegional(String regional) {
		this.regional = regional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCadastradoPor() {
		return cadastradoPor;
	}
	public void setCadastradoPor(String cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getDtContratacao() {
		return dtContratacao;
	}
	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}
	
	public String toString() {
		return "\n"+super.getId()+"__"+status+"__"+nome+"__"+matricula+"__"+setor+"__"+regional+"__"+email+"__"+cadastradoPor+"__"+cpf+"__"+dtCadastro+"__"+cargo+"__"+dtContratacao;
	}
	
}
