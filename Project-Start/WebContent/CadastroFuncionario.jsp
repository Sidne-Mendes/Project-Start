<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
				<title>STOCK PRODUTS</title>
		<meta charset="UTF-8">
		<meta name="Viewsport" content="width=device-width">

				<style>
		        
        
			
			input {
			text-transform: uppercase;
			width: 100%;
		}
		input#botao {
			width: 10%;
			background-color: white;
			color: #259;
			border: none;
		input#botao:hover {
			background-color: #259;
			color: white;
			border: none;
		}
	
		form{
		color: black;
		border: 10px;
		}
		#footer{
            position:absolute;
            bottom:0;
            width:99%;
            background: #42daf5;
           
        }

			
		</style>
	</head>
	<body>
		
		    <header>
    <nav id = "menu">
    
        <ul>
            <li>
                <a href="index.jsp">Home</a>
            </li>
            
            <li>
            	<a>Produto</a>
                <ul>
                    <li>
                        <a href="CadastroProduto.jsp">Cadastrar</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="ListaProdutos.jsp">Relatorio</a>
                    </li>    
                </ul>
            </li>
            
            <li>	
            	<a>Funcionario</a>
                <ul>
                    <li>
                        <a href="CadastroFuncionario.jsp">Cadastrar </a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="ListaFuncionarios.jsp">Listar</a>
                    </li>    
                </ul>
            </li>
                
            <li>
            	<a>Controle</a>
                <ul>
                    <li>
                        <a href="Entrada.jsp">devolução </a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="Saida.jsp"> requisição</a>
                    </li>    
                    <li>
                        <a href="RelatorioControle.jsp">Relatorio</a>
                    </li>    
                </ul> 
            </li>
        </ul>
    </nav>
    </header>
    
    <div id="sairOu longin">
        
    </div>
    <div id="slide">
        <center><img src="logo1.jpeg"></center>
    </div>
	
	<table>
	<br><br>
		<h1>Funcionario</h1><br>
		
		<form action="CadastroFuncionarioServlet" method="post">
			<input type="text" maxlength="150" name="nome" required  placeholder="Nome"><br>
			<input type="number" maxlength="9" name="matricula" required  placeholder="Matricula"><br>	
			<input type="text" maxlength="50" name="cargo" required  placeholder="Cargo"><br><br>
			<input type="submit" id="botao" value="Salvar" name="Salvar"><br>
		</form>		
	</table>
	
	<div id= "footer">
        FOOTER
    </div>
	
	
</body></html>