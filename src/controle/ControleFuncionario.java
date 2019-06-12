package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ViewHelper.AlterarVH;
import ViewHelper.ConsultarVH;
import ViewHelper.ExcluirVH;
import ViewHelper.FuncionarioVH;
import ViewHelper.IViewHelper;
import command.AlterarCommand;
import command.ApagarCommand;
import command.ConsultarCommand;
import command.ICommand;
import command.SalvarCommand;
import dao.FuncionarioDAO;
import dao.IDAO;
import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.ConverteDate;
import util.Result;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/**
 * Servlet implementation class ControleFuncionario
 */
@WebServlet("/ControleFuncionario")
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map <String, ICommand> commands;
	private Map <String, IViewHelper> vhs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleFuncionario() {
        super();
        commands = new HashMap<String,ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("APAGAR", new ApagarCommand());
        
        vhs = new HashMap<String,IViewHelper>();
        
        vhs.put("salvar-funcionario", new FuncionarioVH());
        vhs.put("consultarDados", new ConsultarVH());
        vhs.put("alterarDados", new AlterarVH());
        vhs.put("excluirDados", new ExcluirVH());
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("OPERACAO");
		String rota = request.getParameter("ROTA");
		
		IViewHelper vh = vhs.get(rota);
		
		EntidadeDominio entidade = vh.getEntidade(request);
		Result resultado = commands.get(operacao).executar(entidade);
		vh.setView(resultado,request, response);
		
	}
    
	
}
