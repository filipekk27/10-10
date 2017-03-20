package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.monitoramento.entidades.Historico;
import br.com.ifpe.monitoramento.entidades.Usuario;
import br.com.ifpe.monitoramento.util.ConnectionFactory;

public class HistoricoDao {

	private Connection connection;

	public HistoricoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Historico> listarHistorico(String idUsuarioAutor, String DataCadastro) {
		try {
			String sql;
			PreparedStatement stmt = null;
			List<Historico> listarHistorico = new ArrayList<Historico>();

			if (idUsuarioAutor != null && !idUsuarioAutor.equals("")
					&& (DataCadastro == null || DataCadastro.equals(""))) {
				sql = "SELECT * FROM historico WHERE idUsuarioAutor LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + idUsuarioAutor + "%");

			} else if (idUsuarioAutor != null && !DataCadastro.equals("")
					&& (idUsuarioAutor == null || idUsuarioAutor.equals(""))) {
				sql = "SELECT * FROM historico WHERE DataAlteracao LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + DataCadastro + "%");

			} else if (idUsuarioAutor != null && !idUsuarioAutor.equals("")
					&& (DataCadastro != null && !DataCadastro.equals(""))) {
				sql = "SELECT * FROM historico WHERE idUsuarioAutor LIKE ? AND DataAlteracao LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + idUsuarioAutor + "%");
				stmt.setString(2, "%" + DataCadastro + "%");

			} else {
				sql = "SELECT * FROM historico ORDER BY Id";
				stmt = this.connection.prepareStatement(sql);
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Historico ht = new Historico();
				ht.setIdAuto(rs.getInt("Id"));
				UsuarioDao dao = new UsuarioDao();
				Usuario us = dao.exibir(rs.getInt("IdUsuarioAutor"));
				ht.setIdUsuarioAutor(us);
				ht.setCampo(rs.getString("Campo"));
				ht.setDataAlteracao(rs.getDate("DataAlteracao"));
				listarHistorico.add(ht);
			}

			rs.close();
			stmt.close();
			connection.close();
			return listarHistorico;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}