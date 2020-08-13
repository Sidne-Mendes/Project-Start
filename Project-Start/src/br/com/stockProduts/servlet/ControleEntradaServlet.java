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
			
			String codigoMov = request.getParameter("codigoM");
			String quantidade = request.getParameter("quantidade");
			String senha = request.getParameter("senha");
			String operador = request.getParameter("operador");
			String status = "Entrada";
			
			
			Controle controle = new Controle();
			ControleIntOutDao IntOut = new ControleIntOutDao();
			
			controle.setStatus(status);
			controle.setCodigoM(Integer.parseInt(codigoMov));
			controle.setQuantidade(Integer.parseInt(quantidade));
			
			controle.setStatus(status);
			
			//IntOut.resultIncremento(controle);
			IntOut.ControlaIntOut(controle);
			IntOut.updateIncremento(controle);
			
			response.sendRedirect("ListaProdutos.jsp");
		} catch (Exception e) {
			System.out.println(e.getCause());
		}

	}
}
