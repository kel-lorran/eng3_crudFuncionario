package ViewHelper;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.ConverteDate;
import util.Result;

public class AlterarVH implements IViewHelper {
	private String tipo;

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("txtId"));
		String txtStatus = request.getParameter("txtStatus");
		String txtFuncionario = request.getParameter("txtFuncionario");
		String txtMatricula = request.getParameter("txtMatricula");
		String txtSetor = request.getParameter("txtSetor");
		//System.out.print(request.getContentLength());
		String txtRegional = request.getParameter("txtRegional");
		String txtEmail = request.getParameter("txtEmail");
		String txtCadastradoPor = request.getParameter("txtCadastradoPor");
		String txtCPF = request.getParameter("txtCPF");
		String txtCargo = request.getParameter("txtCargo");
		Date txtDtContratacao = ConverteDate.converteStringDate(request.getParameter("txtDtContratacao"));
		//Date txtDtContratacao = request.getParameter("txtDtContratacao");
		
		Funcionario fu = new Funcionario(txtStatus, txtFuncionario, txtMatricula, txtSetor, txtRegional, txtEmail,
				txtCadastradoPor, txtCPF, txtCargo, txtDtContratacao);
		fu.setDtCadastro(new Date());
		fu.setId(id);
		return fu;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}
