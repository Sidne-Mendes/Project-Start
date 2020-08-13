package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Produto;
public class InsereProdutoDao {

	private Connection connection;
	
	public InsereProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	
	}
	
	public void Insere(Produto objetoProduto ) {
		String query = "INSERT INTO produto (nome, quantidade, codigo) VALUES (?,?,?)";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, objetoProduto.getProduto());
			statement.setInt(2, objetoProduto.getQuantidade());
			statement.setString(3, objetoProduto.getCodigo());

			
			statement.execute();
			statement.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
