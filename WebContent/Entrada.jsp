<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
		<title>STOCK PRODUTS</title>
		<meta charset="UTF-8">
		<meta name="Viewsport" content="width=device-width">

			<%@ include file="includes_pages/style.jsp" %>
	</head>
	<body>
		
		    <header>
    <%@ include file ="includes_pages/menu.jsp" %>
    </header>
    
    <div id="sairOu longin">
        
    </div>
    <div id="slide">
        <center><img src="img/logo1.jpeg"></center>
    </div>
	
	<table>
	<br><br>
		<h1>Devolução</h1><br>
		
		<form action="ControleEntradaServlet" method="post">
			<input type="number" maxlength="9" name="codigoM" required placeholder="Codigo da movimentação"><br>
			<input type="number" maxlength="9" name="quantidade" required placeholder="Quantidade"><br>
			<input type="text" maxlength="150" name="funcionario" required placeholder="matricula do funcionario"><br><br>
			<input type="text" maxlength="50" name="operador" required placeholder="login"><br>
			<input type="password" maxlength="30" name="senha" required placeholder="Senha"><br><br>
			<input type="submit" id="botao" value="Salvar" name="Salvar"><br><br>
		</form>
			
	</table><br>
	
	<div id= "footer">
        <%@include file="includes_pages/footer.jsp" %>
    </div>
	
	
</body></html>