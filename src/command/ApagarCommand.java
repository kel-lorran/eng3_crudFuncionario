package command;

import dominio.EntidadeDominio;
import util.Result;

public class ApagarCommand extends AbstractCommand {
	
	@Override
	public Result executar(EntidadeDominio entidade) {
		return fachada.apagar(entidade);
	}

}
