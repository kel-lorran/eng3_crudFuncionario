package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Strategy.IStrategy;
import Strategy.ValidarDadosFuncionario;
import Strategy.ValidarFuncionario;
import dao.FuncionarioDAO;
import dao.IDAO;
import dominio.Funcionario;
import fachada.IFachada;
import util.Result;
import dominio.EntidadeDominio;

public class Fachada implements IFachada {
	
	private Map<String,Map<String,List<IStrategy>>> regras;
	private Map<String,IDAO> daos;
	private Result resultado;
	StringBuilder sb;
	
	public Fachada() {
		regras = new HashMap<String,Map<String,List<IStrategy>>>();
		daos = new HashMap<String,IDAO>();
		sb = new StringBuilder();
	

		/*
		 * Strategies
		 */

		ValidarFuncionario vlForm = new ValidarFuncionario();
		ValidarDadosFuncionario vlFunc = new ValidarDadosFuncionario();
		
		/*
		 * criar e adicionar uma lista de Strategy para salvar
		 */
		
		List<IStrategy> salvarFuncionario = new ArrayList <IStrategy>();
		
		salvarFuncionario.add(vlForm);
		salvarFuncionario.add(vlFunc);
		
		Map<String,List<IStrategy>> rnsFuncionario = HashMap<String,List<IStrategy>>();
		rnsFuncionario.put("SALVAR",salvarFuncionario);
		
		/*
		 * regras de negocio para consultar
		 */
		
		List<IStrategy> consultarFuncionario = new ArrayList<IStrategy>();
		
		rnsFuncionario.put("CONSULTAR", consultarFuncionario);
		
		/*
		 * regras de negocio para alterar
		 */
		
		List<IStrategy> alterarFuncionario = new ArrayList <IStrategy>();
		
		alterarFuncionario.add(vlForm);
		alterarFuncionario.add(vlFunc);
		
		rnsFuncionario.put("ALTERAR",alterarFuncionario);
		
		regras.put(Funcionario.class.getName(), rnsFuncionario);
		
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());
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

	@Override
	public Result salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
