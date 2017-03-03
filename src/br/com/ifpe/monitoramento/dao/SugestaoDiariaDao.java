package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifpe.monitoramento.entidades.SugestaoDiaria;
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

	public void cadastrarSD(SugestaoDiaria sd) {
		try {
			String sql = "INSERT INTO sugestao () VALUES ()";
			PreparedStatement stmt = connection.prepareStatement(sql);
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
