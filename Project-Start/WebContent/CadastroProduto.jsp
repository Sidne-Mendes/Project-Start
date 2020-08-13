<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
		
		<title>STOCK PRODUTS</title>
		<meta charset="UTF-8">
	<head>
		<%@ include file= "includes_pages/style.jsp" %>

	</head>
	<body>
		
    <header>
  	
  		<%@ include file= "includes_pages/menu.jsp" %>
  		 
    </header>
    
    <div id="sairOu longin">
        
    </div>
    <div id="slide">
        <center><img src="img/logo1.jpeg"></center>
    </div>
	
	<table>
	<br><br>
		<h1>Estoque</h1><br>
		
		<form action="CadastroProdutoServlet" method="post">
			<input type="text" maxlength="60" name="produto"  placeholder="Produto"><br>
			<input type="number" maxlength="9" name="quantidade" required placeholder="Quantidade"><br>	
			<input type="text" maxlength="9" name="codigo" required placeholder="ID"><br><br>
			<input type="submit" id="botao" value="Salvar" name="Salvar"><br>
		</form>	
	</table>
	
	<div id= "footer">
       <%@ include file="includes_pages/footer.jsp" %>
    </div>
	
	
</body></html>