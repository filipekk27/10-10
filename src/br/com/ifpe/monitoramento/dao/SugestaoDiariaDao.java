package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.ifpe.monitoramento.util.ConnectionFactory;

public class SugestaoDiariaDao {
	private Connection connection;

	public SugestaoDiariaDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}
