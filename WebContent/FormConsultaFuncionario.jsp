
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="dominio.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUPER CONSULTA DE FUNCIONARIOS</title>
<style>
	form input{
	display: block;
	}
	
	input.btn-envio{
		margin:30px;
	}
	table{
		border: none!important;
		border-collapse: unset !important;
    	border-spacing: 0 !important
	}
	tr:hover{
		background-color: #aaa;
	}
	tr{
		height: 45px;
	}
	a{
		padding:7px;	
	}
	a:hover{
		background: #555;
		color: #fff;
	}

</style>
</head>
<body>
<!-- <a href="index.html">Home</a> -->
	<%
		List<EntidadeDominio> entidades = (List<EntidadeDominio>) request.getAttribute("resultado");
	%>

	<form action="ControleFuncionario" method="get">

		<label for="txtId">Id:</label> 
		<input type="text" id="txtId"name="txtId" /> </br> 
		<label for="txtNome">NOME:</label> 
		<input type="text" id="txtNome" name="txtNome" /> 
		<input class="btn-envio" type="submit" id="operacao" name="operacao" value="CONSULTAR" /> 
			
		</br>
	</form>


	<a href="FormFuncionario.html">Novo</a>

	<BR>

	<TABLE BORDER="5" WIDTH="50%" CELLPADDING="4" CELLSPACING="3">
		<TR>
			<TH COLSPAN="13"><BR>
				<H3>FUNCIONARIOS</H3></TH>
		</TR>

		<TR>
			<th></th>
			<TH>ID:</TH>
			<TH>STATUS:</TH>
			<TH>NOME:</TH>
			<TH>MATRICULA:</TH>
			<TH>SETOR:</TH>
			<TH>REGIONAL:</TH>
			<TH>EMAIL:</TH>
			<TH>CADASTRADO POR:</TH>
			<TH>CPF:</TH>
			<TH>DATA CADASTRO:</TH>
			<TH>CARGO:</TH>
			<TH>DATA DE CONTRATAÇÃO:</TH>
		</TR>

<% 
if (entidades != null) {			
				StringBuilder sbRegistro = new StringBuilder();

				
					for (int i = 0; i < entidades.size(); i++) {
						Funcionario p = (Funcionario) entidades.get(i);
						sbRegistro.setLength(0);
						//sbLink.setLength(0);

						//	<a href="nome-do-lugar-a-ser-levado">descrição</a>

						sbRegistro.append("<TR ALIGN='CENTER'>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append("<a href='delalt?acao=excluir&id="+p.getId()+"'>deletar</a>");			
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(p.getId());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getStatus());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getNome());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getMatricula());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getSetor());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getRegional());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getEmail());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getCadastradoPor());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getCpf());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getDtCadastro());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getCargo());			
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(p.getDtContratacao());			
						sbRegistro.append("</TD>");				

						sbRegistro.append("</TR>");

						out.print(sbRegistro.toString());

					}
				}

			
		%>


	</TABLE>


</body>
</html>