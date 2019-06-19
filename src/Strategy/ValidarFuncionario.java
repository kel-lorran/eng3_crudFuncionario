package Strategy;

import dominio.EntidadeDominio;
import dominio.Funcionario;

public class ValidarFuncionario extends AbstractValidador {

	@Override
	public String processar(EntidadeDominio entidade) {

		String nmClasse = entidade.getClass().getName();
		StringBuilder sb = new StringBuilder();
		
		if(nmClasse.equals(Funcionario.class.getName())) {
			Funcionario funcionario = (Funcionario) entidade;
			if(funcionario.getNome().equals("")) {
				sb.append("Campo vazio");
			}
			if(funcionario.getNome().length()<5) {
				sb.append("o nome digitado não eh valido");
			}
		}
		return verificaMsg();
	}

}
