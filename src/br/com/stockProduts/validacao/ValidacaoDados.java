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

		String query = "select * from controle where codMovimentação = (?) and matricula = (?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, controle.getCodigoM());
			statement.setString(2, controle.getMatricula());

			int quantidade = 0;
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
			 quantidade = rs.getInt("quantidade");
			}
			rs.first();
		
			if(controle.getQuantidade() > quantidade || controle.getQuantidade() < 0) {
				controle.setSenha(null);
			}
			if (rs.first() != false) {
				
				controle.setMatricula(rs.getString("matricula"));
				controle.setCodProduto(rs.getString("codigo"));
				
			} else {
				
				controle.setSenha(null);
				System.out.println("Erro");

			}
			System.out.println(controle.getSenha());
			System.out.println(controle.getNomeOperador());
			System.out.println(controle.getQuantidade());
			System.out.println(controle.getMatricula());
			System.out.println(controle.getCodProduto());
			
		} catch (SQLException e) {
			System.out.println(query);
			System.out.println(e.getMessage());
		}
	}



}
