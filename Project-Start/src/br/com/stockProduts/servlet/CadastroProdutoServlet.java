package br.com.stockProduts.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.stockProduts.modelo.Produto;
import br.com.stockProduts.DAO.InsereProdutoDao;

@WebServlet("/CadastroProdutoServlet")
public class CadastroProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InsereProdutoDao insere = new InsereProdutoDao();

	public CadastroProdutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String produto = request.getParameter("produto");
			String quantidade = request.getParameter("quantidade");
			String codigo = request.getParameter("codigo");

			Produto muda = new Produto();

			muda.setProduto(produto);
			muda.setCodigo(codigo);
			muda.setQuantidade(Integer.parseInt(quantidade));

			insere.Insere(muda);
			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
