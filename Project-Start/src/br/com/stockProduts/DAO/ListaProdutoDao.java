package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Produto;

public class ListaProdutoDao {

	private Connection connection;

	public ListaProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public List<Produto> getLista() {
		String query = "select*from produto";
		try {
			List<Produto> produto = new ArrayList<Produto>();
			PreparedStatement statement = this.connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Produto prod = new Produto();

				prod.setProduto(result.getString("nome"));
				prod.setQuantidade(result.getInt("quantidade"));
				prod.setCodigo(result.getString("codigo"));

				produto.add(prod);

			}

			result.close();
			statement.close();
			return produto;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
}
