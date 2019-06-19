package Strategy;

import dominio.EntidadeDominio;

public abstract class AbstractValidador implements IStrategy {
	
	protected StringBuilder sb = new StringBuilder();
	
	protected String verificaMsg() {
		
		if (sb.length() > 0) {
			return sb.toString();
		} else {
			return null;
		}
	}

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
