package br.com.stockProduts.validacao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Controle;

public class ValidaSenha {

	private Connection connection;

	public ValidaSenha() {

		connection = new ConnectionFactory().getConnection();

	}

	public void validaSenha(Controle controle) {

		String query = "Select * from operador where nomeOperador = (?) and senha = (?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, controle.getNomeOperador());
			statement.setString(2, controle.getSenha());

			ResultSet result = statement.executeQuery();
			
			
			result.first();

			if (result.first() == true) {
				
				controle.setNomeOperador(result.getString("nomeOperador"));
				System.out.println("Feito");
			} else {
				controle.setNomeOperador(null);
				controle.setSenha(null);
			}

		} catch (Exception e) {
			System.out.println("Erro ao verificar: " + e.getMessage());
		}

	}
}
