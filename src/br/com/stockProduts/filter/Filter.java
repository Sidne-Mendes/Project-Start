package br.com.stockProduts.filter;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.stockProduts.jdbc.ConnectionFactory;

@WebFilter(urlPatterns = { "/*" })
public class Filter implements javax.servlet.Filter {

	private static Connection connection;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
			connection.setAutoCommit(false);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		connection = ConnectionFactory.getConnection();

	}

}
