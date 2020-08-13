package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Controle;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ControleIntOutDao {

	private Connection connection;

	public ControleIntOutDao() {
		ConnectionFactory conexao = new ConnectionFactory();
		this.connection = conexao.getConnection();
	}

	public void ControlaIntOut(Controle controle) {
		String query = "insert into controle (codProduto, quantidade,  dataMovimentacao, statu, matricula, operador) values(?,?,?,?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(query);
			Date data = new Date();
			java.sql.Timestamp dataMovimentacao = new java.sql.Timestamp(data.getTime());

			statement.setString(1, controle.getCodProduto());
			statement.setInt(2, controle.getQuantidade());
			statement.setTimestamp(3, dataMovimentacao);
			statement.setString(4, controle.getStatus());
			statement.setString(5, controle.getMatricula());
			statement.setString(6, controle.getNomeOperador());
			
			
			statement.execute();
			statement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void updateDecremento(Controle controle) {

		String query = "update produto set quantidade = quantidade - (?) where codigo = (?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, controle.getQuantidade());
			statement.setString(2, controle.getCodProduto());
			
			System.out.println(controle.getQuantidade());
			System.out.println(controle.getCodProduto());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateIncremento(Controle controle) {

		String query = "update produto set quantidade = quantidade + (?) where codigo = (?)";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, controle.getQuantidade());
			statement.setString(2, controle.getCodProduto());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
