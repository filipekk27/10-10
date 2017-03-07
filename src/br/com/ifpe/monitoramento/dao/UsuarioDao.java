package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.ifpe.monitoramento.entidades.Cargo;
import br.com.ifpe.monitoramento.entidades.Situacao;
import br.com.ifpe.monitoramento.entidades.UnidadeGestora;
import br.com.ifpe.monitoramento.entidades.Usuario;
import br.com.ifpe.monitoramento.util.ConnectionFactory;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void CadastrarCargo(Usuario user) throws KeyDuplicateException {
		try {
			String sql = "INSERT INTO usuario (cpf_usuario,nome_usuario,email_usuario,endereco_usuario,data_nascimento,senha_usuario,cargo_ocupado,ug_pertence,Status)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getCpf());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getEndereco());
			stmt.setDate(5, new java.sql.Date(user.getDataNascimento().getTime()));
			stmt.setString(6, user.getSenha());
			stmt.setInt(7, user.getCargo().getId());
			stmt.setInt(8, user.getuGestora().getCodigo());
			stmt.setString(9, user.getSituacao().name());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			if (e instanceof MySQLIntegrityConstraintViolationException) {
				throw new KeyDuplicateException(e);
			}
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listarUsuario() {
		try {
			List<Usuario> listar = new ArrayList<Usuario>();
			Usuario user = null;
			String sql;
			PreparedStatement stmt = null;

			sql = "SELECT * FROM usuario";
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setIdUser(rs.getInt("id_usuario"));
				user.setNome(rs.getString("nome_usuario"));

				CargoDao dao = new CargoDao();
				Cargo cargo = dao.exibirCargo(rs.getInt("cargo_ocupado"));
				user.setCargo(cargo);

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("ug_pertence"));
				user.setuGestora(ug);

				user.setCpf(rs.getString("cpf_usuario"));
				user.setEmail(rs.getString("email_usuario"));
				user.setEndereco(rs.getString("endereco_usuario"));
				user.setDataCadastro(rs.getDate("data_cadastro"));
				user.setDataNascimento(rs.getDate("data_nascimento"));
				user.setSenha(rs.getString("senha_usuario"));

				Situacao st = Situacao.valueOf(rs.getString("Status"));
				user.setSituacao(st);

				listar.add(user);
			}
			rs.close();
			stmt.close();
			connection.close();
			return listar;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario exibir(int idUser) {
		try {
			String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			Usuario user = null;
			stmt.setInt(1, idUser);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setIdUser(rs.getInt("id_usuario"));
				user.setNome(rs.getString("nome_usuario"));

				CargoDao dao = new CargoDao();
				Cargo cargo = dao.exibirCargo(rs.getInt("cargo_ocupado"));
				user.setCargo(cargo);

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("ug_pertence"));
				user.setuGestora(ug);

				user.setEndereco(rs.getString("endereco_usuario"));
				user.setDataNascimento(rs.getDate("data_nascimento"));
				user.setSenha(rs.getString("senha_usuario"));

				Situacao st = Situacao.valueOf(rs.getString("Status"));
				user.setSituacao(st);

			}

			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void AlterarUsuario(Usuario user) {
		try {
			String sql = "UPDATE usuario SET nome_usuario = ? , cargo_ocupado = ? , ug_pertence = ? , endereco_usuario = ? ,data_nascimento = ? ,Status = ? WHERE id_usuario = ? ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setInt(2, user.getCargo().getId());
			stmt.setInt(3, user.getuGestora().getCodigo());
			stmt.setString(4, user.getEndereco());
			stmt.setDate(5, new java.sql.Date(user.getDataNascimento().getTime()));
			stmt.setString(6, user.getSituacao().name());
			stmt.setInt(7, user.getIdUser());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario login(Usuario user) {
		try {
			String sql = "SELECT * FROM usuario WHERE cpf_usuario = ? AND senha_usuario = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			Usuario login = null;
			stmt.setString(1, user.getCpf());
			stmt.setString(2, user.getSenha());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				login = new Usuario();
				login.setIdUser(rs.getInt("id_usuario"));
				login.setNome(rs.getString("nome_usuario"));

				CargoDao dao = new CargoDao();
				Cargo cargo = dao.exibirCargo(rs.getInt("cargo_ocupado"));
				login.setCargo(cargo);

				UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
				UnidadeGestora ug = dao2.exibirUG(rs.getInt("ug_pertence"));
				login.setuGestora(ug);

				login.setEndereco(rs.getString("endereco_usuario"));
				login.setDataNascimento(rs.getDate("data_nascimento"));
				login.setSenha(rs.getString("senha_usuario"));

				Situacao st = Situacao.valueOf(rs.getString("Status"));
				user.setSituacao(st);

			}
			rs.close();
			stmt.close();
			return login;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
