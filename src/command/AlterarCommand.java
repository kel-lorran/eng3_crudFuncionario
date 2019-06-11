package command;
import dominio.EntidadeDominio;
import util.Result;

public class AlterarCommand extends AbstractCommand {
	
	@Override
	public Result executar(EntidadeDominio entidade) {
		return fachada.alterar(entidade);
	}

}
