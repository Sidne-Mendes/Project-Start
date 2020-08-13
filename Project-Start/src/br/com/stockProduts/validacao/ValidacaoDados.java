package br.com.stockProduts.validacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.stockProduts.DAO.ControleIntOutDao;
import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Controle;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class ValidacaoDados {

	private Connection connection;

	public ValidacaoDados() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void validaCodigoP(Controle controle) {

		String query = "select codigo.*, matricula.*, senha.* from produto codigo, funcionario matricula, operador senha"
				+ " where codigo = (?) and matricula = (?) and senha = (?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, controle.getCodProduto());
			statement.setString(2, controle.getMatricula());
			statement.setString(3, controle.getSenha());

			ResultSet rs = statement.executeQuery();

			ControleIntOutDao IntOut = new ControleIntOutDao();

			rs.first();

			if (rs.first() != false) {
				IntOut.ControlaIntOut(controle);
				IntOut.updateDecremento(controle);
				System.out.println("Feito");
			} else {
				System.out.println("Erro");
			}

		} catch (SQLException e) {
			System.out.println(query);
			System.out.println(e.getMessage());
		}
	}

	public void validaQuantidade(Controle controle) {

		String sql = "select*from controle where codMovimentação = (?)";

		try {
			PreparedStatement stm = this.connection.prepareStatement(sql);
			stm.setInt(1, controle.getCodigoM());

			ResultSet result = stm.executeQuery();

			while (result.next()) {

				String codigoP = result.getString("codProduto");
				int quantidade = result.getInt("quantidade");
				String matricula = result.getString("matricula");

				if (controle.getQuantidade() > quantidade) {
					controle.setQuantidade(quantidade);
				}
				controle.setMatricula(matricula);
				controle.setCodProduto(codigoP);
				controle.setCodProduto(codigoP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
