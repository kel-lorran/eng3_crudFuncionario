package command;

import dominio.EntidadeDominio;
import util.Result;

public class ConsultarCommand extends AbstractCommand {
	
	@Override
	public Result executar (EntidadeDominio entidade) {
		return fachada.consultar(entidade);
	}

}
