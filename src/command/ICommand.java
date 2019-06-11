package command;

import dominio.EntidadeDominio;
import util.Result;

public interface ICommand {
	
	Result executar(EntidadeDominio entidade);

}
