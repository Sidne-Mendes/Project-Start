<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ESTOQUE</title>
<meta charset="UTF-8">

<style>
body {
	background-color: powderblue;
	font-variant: small-caps;
	padding: 10px;
}

input {
	width: 100%;
}

input#botao {
	width: 10%;
	background-color: white;
	color: #259;
	border: none;
}

input#botao:hover {
	background-color: #259;
	color: white;
	border: none;
}
</style>

</head>
<body>

 	<table>
		<tbody><tr><td><img src="logo.jpg" alt="imagem não encontrada" width="200" height="200"></td>
		<td><p></p><h2>Cadastro de Produto</h2><p></p></td>
	</tr></tbody></table>
	<br><br>
	<form method="post" action="CadastroProduto">
		<input type="text" name="produto" placeholder="Produto"><br>
		<input type="number" name="quantidade" placeholder="Quantidade"><br>
		<input type="number" name="codigo" placeholder="ID"><br><br>
		<input type="submit" id="botao" value="Salvar" name="Salvar"><br>
	</form>	
 
</body>
</html>