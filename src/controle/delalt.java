package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Funcionario;

/**
 * Servlet implementation class delalt
 */
@WebServlet("/delalt")
public class delalt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delalt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
		}

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		

        try {
        	
        	 if (null != request.getParameter("acao")) {
                 // Se for ação de exclusão, exclui o registro do banco de dados.
                 if (request.getParameter("acao").equals("excluir")) {
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
                     response.sendRedirect(request.getContextPath() + "/ControleFuncionario");
                     return;
                 }
        	 }
            // Verificar se foi recebida alguma ação.
//            if (null != request.getParameter("acao")) {
//                // Se for ação de exclusão, exclui o registro do banco de dados.
//                if (request.getParameter("acao").equals("excluir")  || request.getParameter("acao").equals("editar")) {
//                	String txtId = request.getParameter("txtId");
//            		int id = 0;
//            		
//            		if( txtId != null){
//            			if(isNumeric(txtId)){
//            				id = Integer.parseInt(txtId);
//            			}					
//            		}
//            		
//            		Funcionario funcionario = new Funcionario(id, null);
//            		
//            		IDAO dao = new FuncionarioDAO();
//            		
//            		List<EntidadeDominio> funcionarios = dao.consultar(funcionario);
//            		
//            		PrintWriter out = response.getWriter();
//
////                    // escreve o texto
////                    out.println("<!DOCTYPE html> <html> <head> <meta charset=\"ISO-8859-1\"> <title>:::: CADASTRO DE FUNCIONARIO::::</title> </head> <body> <form action=\"ControleFuncionario\" method=\"post\">");
////                    out.println("<body>");
//            		
//            	
//                    return;
//                } 
//
//            }
            } catch (Exception erro) {
            erro.printStackTrace();
        }
    

}
}
