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

import br.com.stockProduts.DAO.RelatorioControleDao;
import br.com.stockProduts.modelo.Controle;

@WebServlet("/RelatorioServlet")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RelatorioServlet() {
        super();
    
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
		   RelatorioControleDao lista = new RelatorioControleDao();
		   List<Controle> controle = lista.getLista();
		   
		   HttpSession sessao = request.getSession();
		   sessao.setAttribute("Controle", controle);
		   response.sendRedirect("RelatorioControle.jsp");
		   
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			out.close();
		}
		
	}

}
