package br.com.stockProduts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.stockProduts.DAO.ListaFuncionarioDao;
import br.com.stockProduts.modelo.Funcionario;

@WebServlet("/ListaFuncionarioServlet")
public class ListaFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaFuncionarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			ListaFuncionarioDao lista = new ListaFuncionarioDao();
			List<Funcionario> funcionario = lista.getLista();

			HttpSession sessao = request.getSession();
			sessao.setAttribute("Funcionario", funcionario);
			response.sendRedirect("ListaFuncionario.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
