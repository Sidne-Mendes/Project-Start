package br.com.stockProduts.validacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Controle;

public class ValidaDadosSaida {

	private Connection connection;

	public ValidaDadosSaida() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void validaQuantidadeSaida(Controle controle) {

		String sql = "select*from produto, funcionario where codigo = (?) and matricula = (?)";

		try {
			PreparedStatement stm = this.connection.prepareStatement(sql);

			stm.setString(1, controle.getCodProduto());
			stm.setString(2, controle.getMatricula());

			int quantidade = 0;

			ResultSet result = stm.executeQuery();

			while (result.next()) {

				quantidade = result.getInt("quantidade");

			}
			result.first();
			if (controle.getQuantidade() > quantidade || controle.getQuantidade() < 0) {
				controle.setSenha(null);
			}
			if (result.first()) {
				controle.setMatricula(result.getString("matricula"));
				controle.setCodProduto(result.getString("codigo"));
			} else {
				controle.setSenha(null);
				System.out.println("quantidade insuficiente.");
			}
			System.out.println(quantidade);
			System.out.println(controle.getQuantidade());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
