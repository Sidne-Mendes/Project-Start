package br.com.stockProduts.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.stockProduts.DAO.CadastroFuncionarioDao;
import br.com.stockProduts.modelo.Funcionario;

@WebServlet("/CadastroFuncionarioServlet")
public class CadastroFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CadastroFuncionarioDao cadastra = new CadastroFuncionarioDao();

	public CadastroFuncionarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String nome = request.getParameter("nome");
			String matricula = request.getParameter("matricula");
			String cargo = request.getParameter("cargo");

			Funcionario muda = new Funcionario();

			muda.setNome(nome);
			muda.setMatricula(matricula);
			muda.setFuncao(cargo);

			cadastra.insereFuncionario(muda);
			response.sendRedirect("ListaFuncionarios.jsp");
		} catch (Exception e) {
		throw new RuntimeException(e);
		}

	}

}
