package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;
import dao.IDAO;
import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.ConverteDate;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/**
 * Servlet implementation class ControleFuncionario
 */
@WebServlet("/ControleFuncionario")
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String txtId = request.getParameter("txtId");
		int id = 0;
		
		if( txtId != null){
			if(isNumeric(txtId)){
				id = Integer.parseInt(txtId);
			}					
		}
		String nome = request.getParameter("txtNome");
		
		Funcionario funcionario = new Funcionario(id, nome);
		
		IDAO dao = new FuncionarioDAO();
		
		List<EntidadeDominio> funcionarios = dao.consultar(funcionario);
		
		request.setAttribute("resultado", funcionarios);
		
		//RequestDispatcher rd= request.getRequestDispatcher("FormConsultaFuncionario.jsp");  		
		RequestDispatcher rd= request.getRequestDispatcher("tableResult.jsp");  
		  
		rd.forward(request, response);//method may be include or forward  
	}
	
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
  			Date txtDtContratacao = ConverteDate.converteStringDate(request.getParameter("txtDtContratacao"));
  			//Date txtDtContratacao = request.getParameter("txtDtContratacao");
  			
  			Funcionario fu = new Funcionario(txtStatus, txtFuncionario, txtMatricula, txtSetor, txtRegional, txtEmail,
  					txtCadastradoPor, txtCPF, txtCargo, txtDtContratacao);
  			fu.setDtCadastro(new Date());			
  			
  			Fachada fachada = new Fachada();
  			
  			String msg = fachada.salvar(fu);
  			
  			PrintWriter out = response.getWriter();
  			out.print(msg);
  		} else {
  			String txtStatus = request.getParameter("txtStatus");
  			String txtFuncionario = request.getParameter("txtFuncionario");
  			String txtMatricula = request.getParameter("txtMatricula");
  			String txtSetor = request.getParameter("txtSetor");
  			String txtRegional = request.getParameter("txtRegional");
  			String txtEmail = request.getParameter("txtEmail");
  			String txtCadastradoPor = request.getParameter("txtCadastradoPor");
  			String txtCPF = request.getParameter("txtCPF");
  			String txtCargo = request.getParameter("txtCargo");
  			Date txtDtContratacao = ConverteDate.converteStringDate(request.getParameter("txtDtContratacao"));
  			//Date txtDtContratacao = request.getParameter("txtDtContratacao");
  			
  			Funcionario fu = new Funcionario(txtStatus, txtFuncionario, txtMatricula, txtSetor, txtRegional, txtEmail,
  					txtCadastradoPor, txtCPF, txtCargo, txtDtContratacao);	
  			fu.setId( id);
  			
  			Fachada fachada = new Fachada();
  			
  			fachada.alterar(fu);
  		}
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String txtId = request.getParameter("id");
  		int id = 0;
  		
  		if( txtId != null){
  			if(isNumeric(txtId)){
  				id = Integer.parseInt(txtId);
  			}					
  		}
  		
  		Funcionario fu = new Funcionario(id, null);
  		
  		Fachada fachada = new Fachada();
  		
  		fachada.excluir(fu);
  		

          // Redireciona para a listagem com sendRedirect - evita o problema com o Reload (F5).

			PrintWriter out = response.getWriter();
			out.print("exclusão com sucesso");
          return;

		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	private int userIdByUrl(HttpServletRequest req) {
		String pathInfo = req.getPathInfo();
	      if (pathInfo.startsWith("/")) {
	          pathInfo = pathInfo.substring(1);
	      }
	      return Integer.parseInt(pathInfo);
		
	}
	
	}
