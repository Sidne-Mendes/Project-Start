package br.com.stockProduts.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.stockProduts.DAO.CadastroFuncionarioDao;
import br.com.stockProduts.modelo.Controle;
import br.com.stockProduts.modelo.Funcionario;

@WebServlet("/CadastroFuncionarioServlet")
public class CadastroFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CadastroFuncionarioDao cadastra = new CadastroFuncionarioDao();

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
			String nomeO = request.getParameter("operador");
			String senha = request.getParameter("senha");

			matricula = matricula.replaceAll("\"", "");
			nomeO = nomeO.replaceAll("\"", "");
			senha = senha.replaceAll("\"", "");
			nome = nome.replaceAll("\"","");
			cargo = cargo.replaceAll("\"","");
			

			Funcionario muda = new Funcionario();
			Controle control = new Controle();

			muda.setNome(nome);
			muda.setMatricula(matricula);
			muda.setFuncao(cargo);
			control.setNomeOperador(nomeO);
			control.setSenha(senha);

			if (control.getSenha() != null && control.getNomeOperador() != null) {

				cadastra.insereFuncionario(muda);
			
			} else {
				response.sendRedirect("CadastroFuncionario.jsp");
			}
			response.sendRedirect("ListaFuncionarios.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
