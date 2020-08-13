<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
<meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>

<title>Home Stock Produts</title>
    <style>
        header{
            margin-left: 20px;
            margin-right: 20px;
        }
        body{
            background-color: black;
            
        }
       
        #menu{
           background-color: #42daf5 ;
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
            color: #000000	;
            text-decoration: none;
            font-size: 20px;
            text-transform: uppercase;
            padding: 0;
        }
        #menu ul ul li{
            margin: auto;
         
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
        #footer:hover{
            border-bottom: #808080;
            height: 50px;
        }
        #slide{
        background-color: black;
        }
        			table {
				width: 100%;
				background-color: white;
				color: black;
				border: none;
			}
			body {background-color:powderblue;
			font-variant:small-caps; padding: 10px;
			}
			input {
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
                        <a href="Entrada.jsp">Entrada </a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="Saida.jsp"> Saida</a>
                    </li>    
                    <li>
                        <a href="RelatorioControle.jsp">Relatorio</a>
                    </li>    
                </ul> 
            </li>
        </ul>
    </nav>
    </header>
    <div id="slide">
        <center><img src="logo1.jpeg"></center>
    </div>
    
    		<br><br>
		<h1>Movimentações do Estoque</h1><br>
		
		<%@ page import = "java.util.*,br.com.stockProduts.DAO.RelatorioControleDao,
				br.com.stockProduts.modelo.Controle" %>
		
		<table border="1">
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
		</tbody></table>
    
</body>
</html>