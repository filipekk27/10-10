package br.com.ifpe.monitoramento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.ifpe.monitoramento.entidades.Cargo;
import br.com.ifpe.monitoramento.util.ConnectionFactory;

public class CargoDao {

	private Connection connection;

	public CargoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void CadastrarCargo(Cargo cargo) throws KeyDuplicateException {
		try {
			String sql = "INSERT INTO cargo (nome_cargo) VALUES (?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cargo.getNome());
			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			if (e instanceof MySQLIntegrityConstraintViolationException) {
				throw new KeyDuplicateException(e);
			}
			throw new RuntimeException(e);
		}
	}

	public List<Cargo> listarCargo(String nome, String id) {
		try {
			String sql;
			PreparedStatement stmt = null;
			List<Cargo> listarCargo = new ArrayList<Cargo>();

			if (nome != null && !nome.equals("") && (id == null || id.equals(""))) {
				sql = "SELECT * FROM cargo WHERE nome_cargo = ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, nome);

			} else if (id != null && !id.equals("") && (nome == null || nome.equals(""))) {
				sql = "SELECT * FROM cargo WHERE id_cargo = ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, id);

			} else if (nome != null && !nome.equals("") && (id != null && !id.equals(""))) {
				sql = "SELECT * FROM cargo WHERE nome_cargo = ? AND id_cargo = ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setString(2, id);
				
			} else {
				sql = "SELECT * FROM cargo ORDER BY id_cargo desc";
				stmt = this.connection.prepareStatement(sql);
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("id_cargo"));
				cargo.setNome(rs.getString("nome_cargo"));
				cargo.setData_cadastro(rs.getDate("data_cadastro"));
				listarCargo.add(cargo);
			}

			rs.close();
			stmt.close();
			connection.close();
			return listarCargo;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removerCargo(int id) {
		try {
			String sql = "DELETE FROM cargo WHERE id_cargo = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Cargo exibirCargo(Integer id) {
		try {
			Cargo cargo = null;
			String sql = "SELECT * FROM cargo WHERE id_cargo = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cargo = new Cargo();
				cargo.setId(rs.getInt("id_cargo"));
				cargo.setNome(rs.getString("nome_cargo"));
			}
			rs.close();
			connection.close();
			stmt.close();
			return cargo;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarCargo(Cargo cargo) {
		try {
			String sql = "UPDATE cargo SET nome_cargo = ? WHERE id_cargo = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cargo.getNome());
			stmt.setInt(2, cargo.getId());
			stmt.execute();
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}