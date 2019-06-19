package Strategy;

import dominio.EntidadeDominio;
import dominio.Funcionario;

public class ValidadorCpf implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		if (nmClasse.equals(Funcionario.class.getName()))
			return verificarCPFFuncionario(entidade);
		else
			return verificarCPFFuncionario(entidade);
	}
	private String verificarCPFFuncionario(EntidadeDominio entidade) {
		Funcionario funcionario = (Funcionario)entidade;
		int soma = 0, resultado, i, peso, numero;
		char digitoVerificador10, digitoVerificador11;
		
		String cpf = funcionario.getCpf().replaceAll("[^0-9]", "");
		
		// verificação se o cpf possui 11 caracteres
		if (cpf.length()!=11) {
			return "Por favor, informe um numero de cpf valido";
		} else {
			// verifica se o 10 digito eh valido
			for (i=0, peso=10; i < 9; i++, peso--) {
				numero = (int) cpf.charAt(i) - 48;
				soma += (numero * peso);
			}
			resultado = 11 - (soma % 11);
			
			if(resultado == 10 || resultado == 11)
				digitoVerificador10 = 0;
			else
				digitoVerificador10 = (char) (resultado + 48);
			
			//verifica se o 11 caracter eh valido
			soma = 0;
			for (i = 0, peso = 11; i < 10; i++, peso--) {
				numero = (int) cpf.charAt(i) - 48;
				soma += numero * peso;
			}

			resultado = 11 - (soma % 11);

			if (resultado == 10 || resultado == 11)
				digitoVerificador11 = 0;
			else
				digitoVerificador11 = (char) (resultado + 48);

			// verifica se os dígitos (10 e 11) calculados batem com os informados pelo usuário
			if ((digitoVerificador10 == cpf.charAt(9)) && (digitoVerificador11 == cpf.charAt(10)))
				return null;
			else
				return "Por favor, informe um cpf válido\n";
		}
	}

}
