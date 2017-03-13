package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.monitoramento.entidades.Deferimento;
import br.com.ifpe.monitoramento.entidades.SolicitarDiaria;
import br.com.ifpe.monitoramento.entidades.TipoDiaria;
import br.com.ifpe.monitoramento.entidades.UnidadeGestora;
import br.com.ifpe.monitoramento.entidades.Usuario;
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
			String sql = "INSERT INTO solicitardiaria (Justificativa,CidOrigem,CidDestino,DataIda,DataVolta,TipoDiaria,ValorDiaria,IdUsuario,uGestora)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getJustificativa());
			stmt.setInt(2, s.getCidOrigem());
			stmt.setInt(3, s.getCidDestino());
			stmt.setDate(4, new java.sql.Date(s.getDataIda().getTime()));
			stmt.setDate(5, new java.sql.Date(s.getDataVolta().getTime()));
			stmt.setString(6, s.getTipoDiaria().name());
			stmt.setDouble(7, s.getValorDiaria());
			stmt.setInt(8, s.getIdUsuario());
			stmt.setInt(9, s.getUnidadeGestora().getCodigo());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<SolicitarDiaria> listarSolicitacaoADM(String TDiaria) {
		try {

			List<SolicitarDiaria> listar = new ArrayList<SolicitarDiaria>();
			String sql;
			PreparedStatement stmt = null;
			SolicitarDiaria sd;

			if (TDiaria != null && !TDiaria.equals("")) {
				sql = "SELECT * FROM solicitardiaria WHERE TDiaria LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + TDiaria + "%");

			} else {
				sql = "SELECT * FROM solicitardiaria";
				stmt = this.connection.prepareStatement(sql);
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sd = new SolicitarDiaria();
				sd.setCodSD(rs.getInt("CodSD"));
				sd.setJustificativa(rs.getString("Justificativa"));
				sd.setCidOrigem(rs.getInt("CidOrigem"));
				sd.setCidDestino(rs.getInt("CidDestino"));
				sd.setDataIda(rs.getDate("DataIda"));
				sd.setDataVolta(rs.getDate("DataVolta"));
				sd.setIdUsuario(rs.getInt("IdUsuario"));
				TipoDiaria tp = TipoDiaria.valueOf(rs.getString("TipoDiaria"));
				sd.setTipoDiaria(tp);

				sd.setValorDiaria(rs.getDouble("ValorDiaria"));

				Deferimento df = Deferimento.valueOf(rs.getString("Deferimento"));
				sd.setDef(df);

				UsuarioDao dao = new UsuarioDao();
				Usuario us = dao.exibir(rs.getInt("IdUsuarioGestor"));
				sd.setIdGestor(us);
				sd.setJustificativaGestor(rs.getString("JustificativaADM"));

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("uGestora"));
				sd.setUnidadeGestora(ug);

				listar.add(sd);

			}

			return listar;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public List<SolicitarDiaria> listarSolicitacaoUsuario(int IdUsuario) {
		try {

			List<SolicitarDiaria> listar = new ArrayList<SolicitarDiaria>();
			String sql = "SELECT * FROM solicitardiaria WHERE IdUsuario = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			SolicitarDiaria sd;
			stmt.setInt(1, IdUsuario);
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

				Deferimento df = Deferimento.valueOf(rs.getString("Deferimento"));
				sd.setDef(df);
                 
				UsuarioDao dao = new UsuarioDao();
				Usuario us = dao.exibir(rs.getInt("IdUsuarioGestor"));
				sd.setIdGestor(us);
				
				sd.setJustificativaGestor(rs.getString("JustificativaADM"));

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("uGestora"));
				sd.setUnidadeGestora(ug);

				listar.add(sd);

			}

			return listar;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public List<SolicitarDiaria> listarSolicitacaoUsuarioUG(int UnidadeGestora) {
		try {

			List<SolicitarDiaria> listar = new ArrayList<SolicitarDiaria>();
			String sql = "SELECT * FROM solicitardiaria WHERE uGestora = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			SolicitarDiaria sd;
			stmt.setInt(1, UnidadeGestora);
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

				Deferimento df = Deferimento.valueOf(rs.getString("Deferimento"));
				sd.setDef(df);

				UsuarioDao dao = new UsuarioDao();
				Usuario us = dao.exibir(rs.getInt("IdUsuarioGestor"));
				sd.setIdGestor(us);
				
				sd.setJustificativaGestor(rs.getString("JustificativaADM"));

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("uGestora"));
				sd.setUnidadeGestora(ug);

				listar.add(sd);

			}

			return listar;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public SolicitarDiaria exibirSolicitacao(int idSolicitacao) { // exibir
																	// solicitacao
		try {
			String sql = "SELECT * FROM solicitardiaria WHERE CodSD = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			SolicitarDiaria SolicitarDiaria = null;
			stmt.setInt(1, idSolicitacao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SolicitarDiaria = new SolicitarDiaria();

				SolicitarDiaria.setCodSD(rs.getInt("CodSD"));

			}

			return SolicitarDiaria;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarSolicitacao(SolicitarDiaria solicitarDiaria) {
		try {

			String sql = "UPDATE solicitardiaria SET Deferimento = ? , IdUsuarioGestor = ? , JustificativaADM = ? WHERE CodSD = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, solicitarDiaria.getDef().name());
			stmt.setInt(2, solicitarDiaria.getIdGestor().getIdUser());
			stmt.setString(3, solicitarDiaria.getJustificativaGestor());
			stmt.setInt(4, solicitarDiaria.getCodSD());

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
