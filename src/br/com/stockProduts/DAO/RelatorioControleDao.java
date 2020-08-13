package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.stockProduts.jdbc.ConnectionFactory;
import br.com.stockProduts.modelo.Controle;

public class RelatorioControleDao {

	private Connection connection;

	public RelatorioControleDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public List<Controle> getLista() {
		String query = "select*from controle";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		try {
			List<Controle> controle = new ArrayList<Controle>();
			PreparedStatement statement = this.connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Controle control = new Controle();

		//     		   	Date data= null;
				//data = sdf(result.getDate("DataMovimentação"));*/
				
				control.setCodigoM(result.getInt("codMovimentação"));
				control.setCodProduto(result.getString("codProduto"));
				control.setMatricula(result.getString("matricula"));
				control.setQuantidade(result.getInt("quantidade"));
				control.setStatus(result.getString("statu"));
				control.setData (result.getDate("DataMovimentacao"));
				control.setNomeOperador(result.getString("operador"));
				controle.add(control);
			}
			result.close();
			statement.close();
			return controle;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
