package br.com.stockProduts.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.stockProduts.modelo.Controle;
import br.com.stockProduts.modelo.Produto;
import br.com.stockProduts.validacao.ValidaSenha;
import br.com.stockProduts.DAO.InsereProdutoDao;

@WebServlet("/CadastroProdutoServlet")
public class CadastroProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InsereProdutoDao insere = new InsereProdutoDao();

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
			String nomeO = request.getParameter("operador");
			String senha = request.getParameter("senha");
			
			produto = produto.replaceAll("\"", "");
			codigo = codigo.replaceAll("\"", "");
			nomeO = nomeO.replaceAll("\"", "");
			senha = senha.replaceAll("\"", "");
			quantidade = quantidade.replaceAll("\"", "");;
			

			Produto muda = new Produto();
			Controle controle = new Controle();
			ValidaSenha valida = new ValidaSenha();

			muda.setProduto(produto);
			muda.setCodigo(codigo);
			muda.setQuantidade(Integer.parseInt(quantidade));

			controle.setNomeOperador(nomeO);
			controle.setSenha(senha);

			valida.validaSenha(controle);

			if (controle.getSenha() != null && controle.getNomeOperador() != null) {
				insere.Insere(muda);

			} else {
				response.sendRedirect("CadastroProduto.jsp");
			}
			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
