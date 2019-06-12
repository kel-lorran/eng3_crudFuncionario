package ViewHelper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.Result;

public class ExcluirVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Funcionario fu = new Funcionario();
		fu.setId(id);
		return fu;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}
