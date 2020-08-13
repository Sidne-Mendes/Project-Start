<!DOCTYPE html>
<html>
<head>

  <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>

<title>Home Stock Produts</title>
    <style>
        header{
            margin-left: 20px;
            margin-right: 20px;
            background-color: #ADD8E6;
            padding: 0;
            border: none;
            margin: 0;
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
			body {
			 background-color: black;
            text-color: white;
            padding: 0;			}
			h1{
			color: white;
			
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
    
    		
		<h1>Produto em Estoque</h1><br>
		
		<%@ page import = "java.util.*,br.com.stockProduts.DAO.ListaProdutoDao,
				br.com.stockProduts.modelo.Produto" %>
		
		<table border="1">
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
		</tbody></table>
 
</body>
</html>