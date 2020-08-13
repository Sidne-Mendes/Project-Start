<!DOCTYPE html>
<html>
<head>

   <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>

<title>Home Stock Produts</title>
 
    <%@include file ="includes_pages/style.jsp" %>
</head>
<body>
    <header>
    <%@include file="includes_pages/menu.jsp" %>
    </header>
    <div id="slide">
        <center><img src="img/logo1.jpeg"></center>
    </div>
    
    		<br><br>
		<h1>Movimentações do Estoque</h1><br>
		
		<%@ page import = "java.util.*,br.com.stockProduts.DAO.RelatorioControleDao,
				br.com.stockProduts.modelo.Controle" %>
		
		<table id=tabelaspec border="1">
			<tbody><tr>
				<th>Codigo do Produto</th>
				<th>Quantidade</th>
				<th>Matricula</th>
				<th>Codigo da movimentação</th>
				<th>Data da movimentação</th>
				<th>Status</th>
				<th>Operador</th>
				
				<% RelatorioControleDao lista = new RelatorioControleDao();
				List<Controle> controle = lista.getLista();
				
				for(Controle controles: controle){ %>
				
				<tr>
					<td><%=controles.getCodProduto() %></td>
					<td><%=controles.getQuantidade() %></td>
					<td><%=controles.getMatricula() %></td>
					<td><%=controles.getCodigoM() %></td>
					<td><%=controles.getData() %></td>
					<td><%=controles.getStatus() %></td>
					<td><%=controles.getNomeOperador() %></td>
				
				</tr>
				<%
				}
				%>
		</tbody></table><br><br>
		<div id ="footer">
		<%@include file="includes_pages/footer.jsp" %>
		</div>
    
</body>
</html>