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
    
    		
		<h1>Produto em Estoque</h1><br>
		
		<%@ page import = "java.util.*,br.com.stockProduts.DAO.ListaProdutoDao,
				br.com.stockProduts.modelo.Produto" %>
		
		<table border="1"  >
			<tbody><tr>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>ID</th>
				<% ListaProdutoDao lista = new ListaProdutoDao();
				List<Produto> produto = lista.getLista();
				
				for(Produto produtos: produto){ %>
				
				<tr>
					<td><%=produtos.getProduto() %></td>
					<td><%=produtos.getQuantidade() %></td>
					<td><%=produtos.getCodigo() %></td>
				
				</tr>
				<%
				}
				%>
		</tbody></table><br><br>
		<div id="footer">
				<%@include file="includes_pages/footer.jsp" %>
		</div>
 
</body>
</html>