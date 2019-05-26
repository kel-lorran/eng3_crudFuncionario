<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="dominio.*, java.util.*"%>
	<%
		List<EntidadeDominio> entidades = (List<EntidadeDominio>) request.getAttribute("resultado");
	%>
	
                            <% 
								if (entidades != null) {			
												StringBuilder sbRegistro = new StringBuilder();
								
												
													for (int i = 0; i < entidades.size(); i++) {
														Funcionario p = (Funcionario) entidades.get(i);
														sbRegistro.setLength(0);
														//sbLink.setLength(0);
								
														//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
								
														sbRegistro.append("<TR ALIGN='CENTER' id='funcionario-id-"+p.getId()+"' >");
														
														sbRegistro.append("<TD>");
														sbRegistro.append("<a href='#' class='del-btn' data-func-id='"+p.getId()+"'><i class='fas fa-user-times' data-func-id='"+p.getId()+"' ></i></a>");			
														sbRegistro.append("</TD>");
														
														sbRegistro.append("<TD>");
														sbRegistro.append("<a href='#' class='edit-btn' data-func-id='"+p.getId()+"'><i class='fas fa-user-edit' data-func-id='"+p.getId()+"'></i></a>");			
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
                            