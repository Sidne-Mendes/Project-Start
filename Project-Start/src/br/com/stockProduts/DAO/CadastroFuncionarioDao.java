package br.com.stockProduts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.stockProduts.modelo.Funcionario;
import br.com.stockProduts.jdbc.ConnectionFactory;

public class CadastroFuncionarioDao {

	private Connection connection;
	
	public CadastroFuncionarioDao() {
	
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insereFuncionario(Funcionario funcionario) {
		
		String query = "insert into funcionario (nome, matricula, funcao) values (?,?,?)"; 
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getMatricula());
			statement.setString(3, funcionario.getFuncao());
			
			statement.execute();
			statement.close();
		} 
		catch(Exception e) {
			e.getMessage();
		}
	}
	
}
