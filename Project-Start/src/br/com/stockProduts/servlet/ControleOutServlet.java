package br.com.stockProduts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.stockProduts.DAO.ControleIntOutDao;
import br.com.stockProduts.modelo.Controle;
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

			String prod = request.getParameter("produto");
			String quant = request.getParameter("quantidade");
			String matric = request.getParameter("matricula");
			String senha = request.getParameter("senha");
			String status = "Saida";

			Controle controle = new Controle();

			controle.setCodProduto(prod);
			controle.setMatricula(matric);
			controle.setQuantidade(Integer.parseInt(quant));
			controle.setSenha(senha);
			controle.setStatus(status);

			ValidacaoDados valida = new ValidacaoDados();

			valida.validaCodigoP(controle);
			
			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
