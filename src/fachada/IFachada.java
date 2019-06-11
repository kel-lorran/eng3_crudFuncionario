package fachada;

import dominio.EntidadeDominio;
import util.Result;

public interface IFachada {

	Result salvar(EntidadeDominio entidade);
	Result alterar(EntidadeDominio entidade);
	Result consultar(EntidadeDominio entidade);
	Result apagar(EntidadeDominio entidade);
}
