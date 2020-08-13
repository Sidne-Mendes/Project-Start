<%@ include file="includes_pages/style.jsp" %>
	</head>
	<body>
		
		    <header>
    
    	<%@ include file="includes_pages/menu.jsp" %>
    	
    </header>
    
    <div id="sairOu longin">
        
    </div>
    <div id="slide">
        <center><img src="img/logo1.jpeg"></center>
    </div>
	
	<table>
	<br><br>
		<h1>Funcionario</h1><br>
		
		<form action="CadastroFuncionarioServlet" method="post">
			<input type="text" maxlength="150" name="nome" required  placeholder="Nome"><br>
			<input type="number" maxlength="9" name="matricula" required  placeholder="Matricula"><br>	
			<input type="text" maxlength="50" name="cargo" required  placeholder="Cargo"><br><br>
			<input type="text" maxlength="50" name="operador" required placeholder="login"><br>
			<input type="password" maxlength="30" name="senha" required placeholder="Senha"><br><br>
			<input type="submit" id="botao" value="Salvar" name="Salvar"><br><br>
		</form>	
	</table><br>
	
	<div id= "footer">
        <%@ include file="includes_pages/footer.jsp" %>
    </div>
	
	
</body></html>