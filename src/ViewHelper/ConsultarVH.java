package ViewHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.Fachada;
import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.ConverteDate;
import util.Result;

public class ConsultarVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String txtId = request.getParameter("txtId");
		int id = 0;
  		
  		if( txtId != null){
  			if(isNumeric(txtId)){
  				id = Integer.parseInt(txtId);
  			}					
  		}
  		
  		if( id == 0) {
  			
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
  			Date txtDtContratacao = request.getParameter("txtDtContratacao") != null ? ConverteDate.converteStringDate(request.getParameter("txtDtContratacao")) : null;
  			//Date txtDtContratacao = request.getParameter("txtDtContratacao");
  			
  			Funcionario fu = new Funcionario(txtStatus, txtFuncionario, txtMatricula, txtSetor, txtRegional, txtEmail,
  					txtCadastradoPor, txtCPF, txtCargo, txtDtContratacao);
  			fu.setDtCadastro(request.getParameter("txtDtCadastro") != null ? ConverteDate.converteStringDate(request.getParameter("txtDtContratacao")) : null);
  			return fu;
  		} else {
  			Funcionario funcionario = new Funcionario();
			funcionario.setId(id);
			return funcionario;
		}
		//return null;
	}

	@Override
	public void setView(Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		if(resultado.getMensagem()==null) {
			if(resultado.getEntidades().size()==1) {
				List<EntidadeDominio> entidade = new ArrayList<EntidadeDominio>();
				entidade.add( resultado.getEntidades().get(0));
				request.setAttribute("listagem", entidade);
				
			}else {
				List<EntidadeDominio> entidade = new ArrayList<EntidadeDominio>();
				for (int i = 0; i<resultado.getEntidades().size();i++) {
					entidade.add(resultado.getEntidades().get(i));
				}
				request.setAttribute("listagem", entidade);
			}
			try {
				
				RequestDispatcher rd= request.getRequestDispatcher("tableResult.jsp");  
				  
				rd.forward(request, response);//method may be include or forward

			} catch(ServletException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/erro.html");
		}

	}
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
		}

}
