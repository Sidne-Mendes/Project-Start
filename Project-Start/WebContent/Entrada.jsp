<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
		<title>STOCK PRODUTS</title>
		<meta charset="UTF-8">
		<meta name="Viewsport" content="width=device-width">

				<style>
		        header{
            margin-left: 20px;
            margin-right: 20px;
            background-color: #ADD8E6;
            padding: 0;
            border: none;
            margin: 0;
        }
         body{
            background-color: black;
            text-color: white;
            padding: 0;
        }
        h1{
        color: white;
        }
       
        #menu{
           background-color:#42daf5 ;
            border-bottom: 5px solid #C0C0C0;
            margin: 20;
            height: 124px;
            padding: 0;
           
        }
        #menu ul{
            
            background-color: #ADD8E6;
            width:980px;
            margin: auto;
            padding: 0;
        	fonte-size: 20px;
        }
        #menu ul li{
            float: left;
            display: inline-block; 
            color: #808080;
            margin-left: 35px;
            height: 29px;
            width: 200px; 
            align-content: center;
            line-height: 30px;
            text-align: center;
            padding: 0;
            margin: 30;
        }
        #menu ul ul{
            display: none;
            padding: 0;
            margin: 0;
            width: 1px;
           
        }
        #menu ul li:hover > ul{
            display: block;
        	padding: 0;
        }
        #menu ul li:hover {
            background-color :#a0c5f2; 
            border-bottom: 3px solid #1E90FF; 
        }
        #menu ul li a:hover {
            color: #1c79eb;
        }
        #menu ul li a{
            height: ;
            color: #000000;
            text-decoration: none;
            font-size: 20px;
            text-transform: uppercase;
            padding: 0;
        }
        #menu ul ul li{
            margin: auto;
         
        }
        #slide{
        background: black;
        margin-left: auto ;
        }
			table {
				width: auto;
				background-color: white;
				color: black;"WebContent/WEB-INF/web.xml"
				
			}
			
			input {
			text-transform: uppercase;
			width: 100%;
		}
		input#botao {
			width: 10%;
			background-color: white;
			color: #259;
			border: none;
		input #botao:hover {
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
            width:100%;
            height: 50px;
            line-height: 35px;
            text-align: left;
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
                        <a href="ListaProdutos.jsp">Estoque</a>
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
		<h1>Devolução</h1><br>
		
		<form action="ControleEntradaServlet" method="post">
			<input type="number" maxlength="9" name="codigoM" required placeholder="Codigo da Movimentação"><br>
			<input type="number" maxlength="9" name="quantidade" required placeholder="Quantidade"><br>
			<input type="text" maxlength="150" name="operador" required placeholder="Operador"><br>
			<input type="text" maxlength="30" name="senha" required placeholder="Senha"><br><br>
			<input type="submit" id="botao" value="Salvar" name="Salvar"><br>
		</form>
			
	</table>
	
	<div id= "footer">
        FOOTER
    </div>
	
	
</body></html>