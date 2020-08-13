package br.com.stockProduts.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		
		String servido = "jdbc:mysql://localhost:3306/estoque";
		String usuario = "root";
		String senha = "";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(servido,usuario,senha);
	
		} 
		catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			return null;
		}
	}
}
