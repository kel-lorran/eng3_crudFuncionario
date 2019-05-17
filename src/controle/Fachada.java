package controle;

import java.util.List;

import dao.FuncionarioDAO;
import dao.IDAO;
import dominio.Funcionario;
import dominio.EntidadeDominio;

public class Fachada {

	public String salvar(EntidadeDominio entidade) {
		Funcionario fu = (Funcionario)entidade;
		StringBuilder sb = new StringBuilder();
		
		//TO DO		
		//validaNull(sb, cliente.validarDados());
		//validaNull(sb, validarExistencia());
		
		if(sb.length()==0){
			IDAO dao = new FuncionarioDAO();
			dao.salvar(fu);
			return "FUNCIONARIO SALVO COM SUCESSO!";
		}		
		
		return sb.toString();
	}

	public String alterar(EntidadeDominio entidade) {
		IDAO dao = new FuncionarioDAO();
		dao.alterar(entidade);
		
		
		
		return null;
	}

	public String excluir(EntidadeDominio entidade) {	
		IDAO dao = new FuncionarioDAO();
		dao.excluir(entidade);
		
		return null;
	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validaNull(StringBuilder sb, String msg){
		if(msg != null){
			sb.append(msg);
		}
	}

}
