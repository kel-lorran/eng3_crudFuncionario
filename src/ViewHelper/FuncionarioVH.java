package ViewHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import dominio.EntidadeDominio;
import util.ConverteDate;
import util.Result;
import dominio.Funcionario;

public class FuncionarioVH implements IViewHelper {
	List<Funcionario> listaFuncionarios;
	Funcionario funcionario;

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
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
		return fu;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if (listaFuncionarios == null) {
			listaFuncionarios = new ArrayList<Funcionario>();
		}
		if(resultado.getMensagem() == null) {
			//List<EntidadeDominio> listaEntidades = resultado.getEntidades();
		
			
			//request.setAttribute("resultado", listaEntidades);
			
			//RequestDispatcher rd= request.getRequestDispatcher("FormConsultaFuncionario.jsp");  		
			//RequestDispatcher rd= request.getRequestDispatcher("tableResult.jsp");  
			  
			//rd.forward(request, response);//method may be include or forward

		}
		
	}

}
