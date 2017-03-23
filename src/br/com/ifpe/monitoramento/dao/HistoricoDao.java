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

	public List<Historico> listarHistorico(String cpf, String nomeU, String data1, String data2, String objetoAlterado,
			Integer uGestora) {
		try {
			String sql;
			PreparedStatement stmt = null;
			List<Historico> listarHistorico = new ArrayList<Historico>();

			// COMEÇO CPF

			// Filtro apenas por cpf
			if (cpf != null && !cpf.equals("") && (nomeU == null || nomeU.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado == null || objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
			}
			// filtro por cpf e nome
			else if (cpf != null && !cpf.equals("") && nomeU != null && !nomeU.equals("")
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado == null || objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ? AND u.nome_usuario LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
				stmt.setString(2, "%" + nomeU + "%");
			}
			// filtro por cpf data
			else if (cpf != null && !cpf.equals("") && (nomeU == null || nomeU.equals("")) && data1 != null
					&& !data1.equals("") && data2 != null && !data2.equals("")
					&& (objetoAlterado == null || objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ? AND h.DataAlteracao >= ? AND h.DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
				stmt.setString(2, data1);
				stmt.setString(3, data2);
			}
			// filtro por cpf objeto
			else if (cpf != null && !cpf.equals("") && (nomeU == null || nomeU.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& objetoAlterado != null && !objetoAlterado.equals("")
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ? AND h.Campo LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
				stmt.setString(2, "%" + objetoAlterado + "%");
			}
			// filtro por cpf e ug
			else if (cpf != null && !cpf.equals("") && (nomeU == null || nomeU.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado == null || objetoAlterado.equals("")) && uGestora != null
					&& !uGestora.equals("")) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ? AND u.ug_pertence LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
				stmt.setString(2, "%" + uGestora + "%");
			}
			// filtro por tudo
			else if (cpf != null && !cpf.equals("") && (nomeU != null && !nomeU.equals(""))
					&& (data1 != null && !data1.equals("")) && (data2 != null && !data2.equals(""))
					&& (objetoAlterado != null && !objetoAlterado.equals(""))
					&& (uGestora != null && !uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.cpf_usuario LIKE ? AND u.nome_usuario LIKE ? AND h.Campo LIKE ? AND u.ug_pertence LIKE ? AND h.DataAlteracao >= ? AND h.DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + cpf + "%");
				stmt.setString(2, "%" + nomeU + "%");
				stmt.setString(3, "%" + objetoAlterado + "%");
				stmt.setString(4, "%" + uGestora + "%");
				stmt.setString(5, "%" + data1 + "%");
				stmt.setString(6, "%" + data2 + "%");
			}

			// FIM CPF

			// COMEÇO NOME

			// Filtro apenas por nome usuario
			else if (nomeU != null && !nomeU.equals("") && (cpf == null || cpf.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado == null || objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.nome_usuario LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + nomeU + "%");
			}
			// filtro por nome data
			else if (cpf == null || cpf.equals("") && (nomeU != null && !nomeU.equals("")) && data1 != null
					&& !data1.equals("") && data2 != null && !data2.equals("")
					&& (objetoAlterado == null || objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.nome_usuario LIKE ? AND h.DataAlteracao >= ? AND h.DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + nomeU + "%");
				stmt.setString(2, data1);
				stmt.setString(3, data2);
			}
			// filtro por nome e objeto
			else if (cpf == null
					|| cpf.equals("") && (nomeU != null && !nomeU.equals("")) && (data1 == null || data1.equals(""))
							&& (data2 == null || data2.equals("")) && objetoAlterado != null
							&& !objetoAlterado.equals("") && (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.nome_usuario LIKE ? AND h.Campo LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + nomeU + "%");
				stmt.setString(2, "%" + objetoAlterado + "%");
			}
			// filtro por nome e ug
			else if (cpf == null || cpf.equals("") && (nomeU != null && !nomeU.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado == null || objetoAlterado.equals("")) && uGestora != null
					&& !uGestora.equals("")) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.nome_usuario LIKE ? AND u.ug_pertence LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + nomeU + "%");
				stmt.setString(2, "%" + uGestora + "%");
			}

			// FIM NOME

			// COMEÇO OBJETO ALTERADO

			// Filtro por Objeto alterado ex : usuario , cargo ,
			// etc..
			else if (objetoAlterado != null && !objetoAlterado.equals("") && (cpf == null || cpf.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (nomeU == null || nomeU.equals("")) && (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico where Campo LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + objetoAlterado + "%");

			} // filtro por Objeto e data
			else if (cpf == null || cpf.equals("") && (nomeU == null || nomeU.equals("")) && data1 != null
					&& !data1.equals("") && data2 != null && !data2.equals("")
					&& (objetoAlterado != null && !objetoAlterado.equals(""))
					&& (uGestora == null || uGestora.equals(""))) {
				sql = "select * from historico WHERE Campo LIKE ? AND h.DataAlteracao >= ? AND h.DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + objetoAlterado + "%");
				stmt.setString(2, data1);
				stmt.setString(3, data2);
			}

			// filtro por Objeto e ug
			else if (cpf == null || cpf.equals("") && (nomeU == null || nomeU.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (objetoAlterado != null && !objetoAlterado.equals("")) && uGestora != null
					&& !uGestora.equals("")) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario WHERE h.Campo LIKE ? AND u.ug_pertence LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + objetoAlterado + "%");
				stmt.setString(2, "%" + uGestora + "%");
			}

			// FIM OBJETO

			// COMEÇO UNIDADE GESTORA

			// filtro por unidade gestora
			else if (uGestora != null && !uGestora.equals("") && (cpf == null || cpf.equals(""))
					&& (data1 == null || data1.equals("")) && (data2 == null || data2.equals(""))
					&& (nomeU == null || nomeU.equals("")) && (objetoAlterado == null || objetoAlterado.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.ug_pertence LIKE ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + uGestora + "%");

			} // filtro por ug e data

			else if (data1 != null && !data1.equals("") && data2 != null && !data2.equals("")
					&& (uGestora != null && !uGestora.equals("")) && (cpf == null || cpf.equals(""))
					&& (nomeU == null || nomeU.equals("")) && (objetoAlterado == null || objetoAlterado.equals(""))) {
				sql = "select * from historico h inner join usuario u on h.IdUsuarioAutor = u.id_usuario where u.ug_pertence LIKE ? AND h.DataAlteracao >= ? AND h.DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%" + uGestora + "%");
				stmt.setString(2, data1);
				stmt.setString(3, data2);

			}
             // FIM OBJETO
			
			//COMEÇO DATA
			
			// filtro apenas por perido data alteração
			else if (data1 != null && !data1.equals("") && data2 != null && !data2.equals("")
					&& (uGestora == null || uGestora.equals("")) && (cpf == null || cpf.equals(""))
					&& (nomeU == null || nomeU.equals("")) && (objetoAlterado == null || objetoAlterado.equals(""))) {
				sql = "select * from historico WHERE DataAlteracao >= ? AND DataAlteracao <= ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, data1);
				stmt.setString(2, data2);

			}

			else {
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