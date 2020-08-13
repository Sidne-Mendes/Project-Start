<%@page import="br.com.stockProduts.modelo.Funcionario"%>
<%@page import="br.com.stockProduts.DAO.ListaFuncionarioDao"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEWARRAY"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
			<title>STOCK PRODUTS</title>
		<meta charset="UTF-8">
		<meta name="Viewsport" content="width=device-width">

		<%@include file="includes_pages/style.jsp" %>
	</head>
	<body>
	<header>
    <%@include file="includes_pages/menu.jsp" %>
    </header>
    <div id="slide">
        <center><img src="img/logo1.jpeg"></center>
    </div>
    
	<br><br>
		<h1>Lista de Funcionarios</h1><br>
		
		<%@ page import = "java.util.*,br.com.stockProduts.DAO.ListaProdutoDao,
				br.com.stockProduts.modelo.Produto" %>
		
		<table border="1">
			<tbody>
			<tr>
				<th>Nome</th>
				<th>Função</th>
				<th>Matricula</th>
				
				<%ListaFuncionarioDao lista = new ListaFuncionarioDao(); 
				List<Funcionario> funcionario = lista.getLista();
				
				for(Funcionario funcionarios: funcionario){%>
				
				<tr>
					<td><%=funcionarios.getNome() %></td>
					<td><%=funcionarios.getFuncao() %></td>
					<td><%=funcionarios.getMatricula() %></td>
					
				</tr>
				<%
				}
				%>
			</tbody></table><br><br>
			
			<div id ="footer">
			<%@include file="includes_pages/footer.jsp" %>
			</div>
	  
</body></html>