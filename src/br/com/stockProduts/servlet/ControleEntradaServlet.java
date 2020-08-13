package br.com.stockProduts.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.stockProduts.DAO.ControleIntOutDao;
import br.com.stockProduts.modelo.Controle;
import br.com.stockProduts.validacao.ValidaSenha;
import br.com.stockProduts.validacao.ValidacaoDados;

@WebServlet("/ControleEntradaServlet")
public class ControleEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleEntradaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String codigoM = request.getParameter("codigoM");
			String quantidade = request.getParameter("quantidade");
			String funcionario = request.getParameter("funcionario");
			String senha = request.getParameter("senha");
			String operador = request.getParameter("operador");
			String status = "Entrada";

			codigoM = codigoM.replaceAll("\"", "");
			quantidade = quantidade.replaceAll("\"", "");
			funcionario = funcionario.replaceAll("\"","");
			senha = senha.replaceAll("\"", "");
			operador = operador.replaceAll("\"", "");
			
			
			Controle controle = new Controle();

			controle.setMatricula(funcionario);
			controle.setCodigoM(Integer.parseInt(codigoM));
			controle.setQuantidade(Integer.parseInt(quantidade));
			controle.setNomeOperador(operador);
			controle.setSenha(senha);
			controle.setStatus(status);

			ValidaSenha valida = new ValidaSenha();
			ControleIntOutDao control = new ControleIntOutDao();
			ValidacaoDados quant = new ValidacaoDados();

			valida.validaSenha(controle);
			quant.validaCodigoP(controle); 

			if (controle.getSenha() != null ) {
			control.ControlaIntOut(controle);
			control.updateIncremento(controle);
			} else {
				System.out.println("Erro: ");
				response.sendRedirect("Entrada.jsp");
			}
			// IntOut.resultIncremento(controle);

			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			System.out.println(e.getCause());
			response.sendRedirect("index.jsp");
		}

	}
}
