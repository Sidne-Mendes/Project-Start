package br.com.stockProduts.servlet;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.stockProduts.DAO.ControleIntOutDao;
import br.com.stockProduts.modelo.Controle;
import br.com.stockProduts.validacao.ValidaDadosSaida;
import br.com.stockProduts.validacao.ValidaSenha;
import br.com.stockProduts.validacao.ValidacaoDados;

@WebServlet("/ControleOutServlet")
public class ControleOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			ControleIntOutDao IntOut = new ControleIntOutDao();

			String prod = request.getParameter("produto");
			String quant = request.getParameter("quantidade");
			String matric = request.getParameter("matricula");
			String operador = request.getParameter("operador");
			String senha = request.getParameter("senha");
			String status = "Saida";
			
			prod = prod.replaceAll("'", "");
			quant = quant.replaceAll("\"", "");
			matric = matric.replaceAll("\"", "");
			senha = senha.replaceAll("\"", "");
			operador = operador.replaceAll("\"", "");
			
			
			Controle controle = new Controle();

			controle.setCodProduto(prod);
			controle.setMatricula(matric);
			controle.setQuantidade(Integer.parseInt(quant));
			controle.setNomeOperador(operador);
			controle.setSenha(senha);
			controle.setStatus(status);

			ValidaSenha valida = new ValidaSenha();
			ValidaDadosSaida saida = new ValidaDadosSaida();
			
			valida.validaSenha(controle);
			saida.validaQuantidadeSaida(controle);
			
			if(controle.getSenha() != null ) {
				IntOut.ControlaIntOut(controle);
				IntOut.updateDecremento(controle);
				System.out.println("Sucesso");
			} else {
				System.out.println("Erro");
				response.sendRedirect("Saida.jsp");
			}
			
			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
