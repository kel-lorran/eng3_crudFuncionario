<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="dominio.*, java.util.*"%>
	<%
		List<EntidadeDominio> entidades = (List<EntidadeDominio>) request.getAttribute("resultado");
	%>
	
<!DOCTYPE html>
<html>

<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <link rel="stylesheet" href="assets/css/style.css">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
    <main class="container">
        <div class="row"><h1 class="center-align">CRUD de Funcionarios</h1></div>
        <div class="row flex-center">
            <div class="my-form">
                <div>
                    <form action="ControleFuncionario" method="post">
                        <div class="row">
                            <div class="input-field col s12">
                                <input disabled="disabled" placeholder="Id" id="txtId" type="number" class="validate my-input" name="txtId">
                                <label for="txtId" class="">Id</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <select id="txtStatus" name="txtStatus">
                                    <option value="" disabled selected>Status:</option>
                                    <option value="Ativo">Ativo</option>
                                    <option value="Inativo">Inativo</option>
                                </select>
                            </div>

                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Nome" id="txtFuncionario" type="text" class="validate my-input" name="txtfuncionario">
                                <label for="txtFuncionario" class="">Nome</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Matricula" id="txtMatricula" type="text" class="validate my-input" name="txtMatricula">
                                <label for="txtMatricula" class="">Matricula</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Setor" id="txtSetor" type="text" class="validate my-input" name="txtSetor">
                                <label for="txtSetor" class="">Setor</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Regional" id="txtRegional" type="text" class="validate my-input" name="txtRegional">
                                <label for="txtRegional" class="">Regional</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Email" id="txtEmail" type="email" class="validate my-input" name="txtEmail">
                                <label for="txtEmail" class="">E-mail</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Cad. P/" id="txtCadastradoPor" type="text" class="validate my-input" name="txtCadastradoPor">
                                <label for="txtCadastradoPor" class="">Cad. P/</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="CPF" id="txtCPF" type="text" class="validate my-input" name="txtCPF">
                                <label for="txtCPF" class="">CPF</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Cargo" id="txtCargo" type="text" class="validate my-input" name="txtCargo">
                                <label for="txtCargo" class="">Cargo</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Data Contra." id="txtDtContratacao" type="text" class="validate my-input" name="txtDtContratacao">
                                <label for="txtDtContratacao" class="">Data Contra.</label>
                                <span class="helper-text" data-error="valor invalido" data-success="correto"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <a disabled="disabled" class="waves-effect waves-light btn">ATUALIZAR</a>
                            </div>
                        </div>      
                    </form>
                </div>
            </div>
            <div class="my-table" id="table-01">
                <div>
                    <table class="highlight">
                        <thead>
                            <tr>
                                <th></th>
                                <th>ID</th>
                                <th>STATUS</th>
                                <th>NOME</th>
                                <th>MATRICULA</th>
                                <th>SETOR</th>
                                <th>REGIONAL</th>
                                <th>EMAIL</th>
                                <th>CADASTRADO POR</th>
                                <th>CPF</th>
                                <th>DATA CADASTRO</th>
                                <th>CARGO</th>
                                <th>DATA DE CONTRATAÇÃO</th>
                            </tr>
                        </thead>
                        <tbody>
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
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('select');
            var instances = M.FormSelect.init(elems, {});
        })
    </script>
</body>

</html>