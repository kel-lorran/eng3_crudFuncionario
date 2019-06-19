package Strategy;

import dominio.EntidadeDominio;
import dominio.Funcionario;

public class ValidarDadosFuncionario extends AbstractValidador {

	@Override
	public String processar(EntidadeDominio entidade) {

		Funcionario funcionario = (Funcionario) entidade;
		
		if(funcionario.getStatus().trim().equals("")) {
			sb.append("\nStatus do funcionario invalido!");
		}
		if(funcionario.getNome().trim().equals("")) {
			sb.append("\nNome do funcionario invalido!");
		}
		if(funcionario.getMatricula().trim().equals("")) {
			sb.append("\nMatricula do funcionario invalido!");
		}
		if(funcionario.getSetor().trim().equals("")) {
			sb.append("\nSetor do funcionario invalido!");
		}
		if(funcionario.getRegional().trim().equals("")) {
			sb.append("\nRegional do funcionario invalido!");
		}
		if(funcionario.getEmail().trim().equals("")) {
			sb.append("\nEmail do funcionario invalido!");
		}
		if(funcionario.getCadastradoPor().trim().equals("")) {
			sb.append("\nFavor informar quem realizou o Cadastro!");
		}
		if(funcionario.getCpf().trim().equals("")) {
			sb.append("\nCpf do funcionario invalido!");
		}
		if(funcionario.getCargo().trim().equals("")) {
			sb.append("\nCargo do funcionario invalido!");
		}
		
		return verificaMsg();
	}

}
