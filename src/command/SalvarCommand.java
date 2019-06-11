package command;

import dominio.EntidadeDominio;
import util.Result;

public class SalvarCommand extends AbstractCommand {
	
	@Override
	public Result executar(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}

}
