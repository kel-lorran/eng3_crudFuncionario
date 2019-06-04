<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page
	import="dominio.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>:::: CADASTRO DE FUNCIONARIO::::</title>
</head>
<body>

<%
		List<EntidadeDominio> entidades = (List<EntidadeDominio>) request.getAttribute("resultado");
	%>
	
	
	<form action="ControleFuncionario" method="post">
	
	<% 
if (entidades != null) {			
				StringBuilder sbRegistro = new StringBuilder();

				
					for (int i = 0; i < entidades.size(); i++) {
						Funcionario p = (Funcionario) entidades.get(i);
						sbRegistro.setLength(0);
						//sbLink.setLength(0);

						//	<a href="nome-do-lugar-a-ser-levado">descrição</a>

						
						
						%>
						
		<select id="txtStatus" name="txtStatus">
			<option value="Ativo" <%= p.getStatus().equals("Ativo") ? "selected" : "" %>>ATIVO</option>
			<option value="Inativo" <%= p.getStatus().equals("Ativo") ? "selected" : "" %>>INATIVO</option>
		</select>	
		
		<label for="txtFuncionario">Nome:</label>
		<input type="text" value="<%= p.getNome() %>" id="txtFuncionario" name="txtFuncionario"/>
		<br />
		
		<label for="txtMatricula">Matricula:</label>
		<input type="text" value="<%= p.getMatricula() %>" id="txtMatricula" name="txtMatricula"/>
		<br />
		
		<label for="txtSetor">Setor:</label>
		<input type="text" value="<%= p.getSetor() %>" id="txtSetor" name="txtSetor"/>
		<br />
		
		<label for="txtRegional">Regional:</label>
		<input type="text" value="<%= p.getRegional() %>" id="txtRegional" name="txtRegional"/>
		<br />	
		
		<label for="txtEmail">Email:</label>
		<input type="text" value="<%= p.getEmail() %>" id="txtEmail" name="txtEmail"/>
		<br />
		
		<label for="txtCadastradoPor">Cadastrado Por:</label>
		<input type="text"  id="txtCadastradoPor" name="txtCadastradoPor"/>
		<br />
		
		<label for="txtCPF">CPF:</label>
		<input type="text" id="txtCPF" name="txtCPF"/>
		<br />
		
		<label for="txtCargo">Cargo:</label>
		<input type="text" id="txtCargo" name="txtCargo"/>
		<br />
		
		<label for="txtDtContratacao">Data de contratação:</label>
		<input type="text" id="txtDtContratacao" name="txtDtContratacao"/>
		<br />
		
						
						<%
						
					}
}
	%>
	
		<input type="submit" id="operacao" name="operacao" value="SALVAR_FUNCIONARIO"/>
<!-- 		<input type="submit" id="operacao" name="operacao" value="EXCLUIR_FUNCIONARIO"/> -->
	
	</form>
</body>
</html>