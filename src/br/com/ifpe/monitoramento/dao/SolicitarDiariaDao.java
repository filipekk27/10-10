package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.monitoramento.entidades.SolicitarDiaria;
import br.com.ifpe.monitoramento.entidades.TipoDiaria;
import br.com.ifpe.monitoramento.util.ConnectionFactory;

public class SolicitarDiariaDao {

	private Connection connection;

	public SolicitarDiariaDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void cadastrarSolicitarDiaria(SolicitarDiaria s) {
		try {
			String sql = "INSERT INTO solicitardiaria (Justificativa,CidOrigem,CidDestino,DataIda,DataVolta,TipoDiaria,ValorDiaria)"
					+ " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getJustificativa());
			stmt.setInt(2, s.getCidOrigem());
			stmt.setInt(3, s.getCidDestino());
			stmt.setDate(4, new java.sql.Date(s.getDataIda().getTime()));
			stmt.setDate(5, new java.sql.Date(s.getDataVolta().getTime()));
			stmt.setString(6, s.getTipoDiaria().name());
			stmt.setDouble(7, s.getValorDiaria());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<SolicitarDiaria> listarSolicitacao() {
		try {

			List<SolicitarDiaria> listar = new ArrayList<SolicitarDiaria>();
			String sql = "SELECT * FROM solicitardiaria";
			PreparedStatement stmt = connection.prepareStatement(sql);
			SolicitarDiaria sd;
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sd = new SolicitarDiaria();
				sd.setCodSD(rs.getInt("CodSD"));
				sd.setJustificativa(rs.getString("Justificativa"));
				sd.setCidOrigem(rs.getInt("CidOrigem"));
				sd.setCidDestino(rs.getInt("CidDestino"));
				sd.setDataIda(rs.getDate("DataIda"));
				sd.setDataVolta(rs.getDate("DataVolta"));

				TipoDiaria tp = TipoDiaria.valueOf(rs.getString("TipoDiaria"));
				sd.setTipoDiaria(tp);

				sd.setValorDiaria(rs.getDouble("ValorDiaria"));

				listar.add(sd);

			}

			return listar;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	public List<SolicitarDiaria> listarAcompanhamento() {
		try {

			List<SolicitarDiaria> listar = new ArrayList<SolicitarDiaria>();
			String sql = "SELECT * FROM solicitardiaria";
			PreparedStatement stmt = connection.prepareStatement(sql);
			SolicitarDiaria sd;
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sd = new SolicitarDiaria();
				sd.setCodSD(rs.getInt("CodSD"));
				sd.setJustificativa(rs.getString("Justificativa"));
				sd.setCidOrigem(rs.getInt("CidOrigem"));
				sd.setCidDestino(rs.getInt("CidDestino"));
				sd.setDataIda(rs.getDate("DataIda"));
				sd.setDataVolta(rs.getDate("DataVolta"));

				TipoDiaria tp = TipoDiaria.valueOf(rs.getString("TipoDiaria"));
				sd.setTipoDiaria(tp);

				sd.setValorDiaria(rs.getDouble("ValorDiaria"));

				listar.add(sd);

			}

			return listar;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
}
