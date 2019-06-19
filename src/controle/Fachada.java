package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Strategy.IStrategy;
import Strategy.ValidadorCpf;
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
		ValidadorCpf vCpf = new ValidadorCpf();
		/*
		 * criar e adicionar uma lista de Strategy para salvar
		 */
		
		List<IStrategy> salvarFuncionario = new ArrayList <IStrategy>();
		
		salvarFuncionario.add(vlForm);
		salvarFuncionario.add(vlFunc);
		salvarFuncionario.add(vCpf);
		
		Map<String,List<IStrategy>> rnsFuncionario = new HashMap<String,List<IStrategy>>();
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
		alterarFuncionario.add(vCpf);
		
		rnsFuncionario.put("ALTERAR",alterarFuncionario);
		
		regras.put(Funcionario.class.getName(), rnsFuncionario);
		
		daos.put(Funcionario.class.getName(), new FuncionarioDAO());
	}
		
	private void validaNull(StringBuilder sb, String msg){
		if(msg != null){
			sb.append(msg);
		}
	}

	@Override
	public Result salvar(EntidadeDominio entidade) {
		
		sb.setLength(0);
		resultado = new Result();
		String classe = entidade.getClass().getName();
		
		Map<String,List<IStrategy>> rn = regras.get(classe);
		
		List<IStrategy> rns = rn.get("SALVAR");
		if(rns!=null) {
			for (IStrategy strategies :rns) {
				String msg= strategies.processar(entidade);
				if (msg!=null) {
					sb.append(msg + "\n");
				}
			}
		}
		
		if(sb.length() !=0) {
			resultado.setMensagem(sb.toString());
		}else {
			daos.get(classe).salvar(entidade);
			
		}
		resultado.addEntidades(entidade);
		
		return resultado;
	}

	@Override
	public Result alterar(EntidadeDominio entidade) {
		sb.setLength(0);
		resultado = new Result();
		String classe = entidade.getClass().getName();
		
		Map<String,List<IStrategy>> rn = regras.get(classe);
		
		
		List<IStrategy> rns = rn.get("ALTERAR");
		if(rns!=null) {
			
			for (IStrategy strategies :rns) {
				String msg = strategies.processar(entidade);
				if (msg!=null) {
					sb.append(msg + "\n");
				}
			}
		}
		if (sb.length() !=0) {
			resultado.setMensagem(sb.toString());
		} else {
			daos.get(classe).alterar(entidade);

		}
		resultado.addEntidades(entidade);

		return resultado;
	}

	@Override
	public Result consultar(EntidadeDominio entidade) {
		sb.setLength(0);
		resultado = new Result();
		String classe = entidade.getClass().getName();
		
		Map<String,List<IStrategy>> rn = regras.get(classe);
		
		
		if(rn.get("CONSULTAR")!=null) {
			List<IStrategy> rns = rn.get("CONSULTAR");
				
			for (IStrategy strategies :rns) {
				String msg= strategies.processar(entidade);
				if (msg!=null) {
					sb.append(msg);
				}
			}
		}	
		
		
		if (sb.length() !=0) {
			resultado.setMensagem(sb.toString());
		} else {
			List<EntidadeDominio> lista= daos.get(classe).consultar(entidade);
			if (lista == null) {
				resultado.setMensagem("Sem retorno");
			} else {
				for (int i = 0 ; i<lista.size();i++) {
					resultado.addEntidades(lista.get(i));
				}
				
			}

		}
		
		return resultado;

	}

	@Override
	public Result apagar(EntidadeDominio entidade) {
		resultado = new Result();
		String classe = entidade.getClass().getName();

		if (sb.length() !=0) {
			resultado.setMensagem(sb.toString());
		} else {
			daos.get(classe).excluir(entidade);

		}
		resultado.addEntidades(entidade);
		return resultado;

	}

}
