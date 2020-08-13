package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Funcionario;

public class ListaFuncionarioDao {

	private Connection connection;

	public ListaFuncionarioDao() {
		// TODO Auto-generated constructor stub

		this.connection = new ConnectionFactory().getConnection();

	}

	public List<Funcionario> getLista() {

		String query = "select*from funcionario";

		try {
			List<Funcionario> funcionario = new ArrayList<Funcionario>();

			PreparedStatement statement = this.connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Funcionario func = new Funcionario();

				func.setNome(result.getString("nome"));
				func.setMatricula(result.getString("matricula"));
				func.setFuncao(result.getString("funcao"));

				funcionario.add(func);
			}

			result.close();
			statement.close();
			return funcionario;

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return null;
	}

}
