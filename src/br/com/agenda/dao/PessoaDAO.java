package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.conexoes.MySQL;
import br.com.agenda.entidades.Pessoa;

public class PessoaDAO {
	
	public List<Pessoa> listarTodos(String procurar) throws SQLException {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "SELECT * FROM contato WHERE nome LIKE ? ORDER BY id DESC;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + procurar + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			int i = 0;
			pessoa.setId(rs.getInt(++i));
			pessoa.setNome(rs.getString(++i));
			pessoa.setFone(rs.getString(++i));
			pessoa.setEmail(rs.getString(++i));
			pessoa.setEndereco(rs.getString(++i));
			lista.add(pessoa);
		}
		return lista;
	}
	
	public void inserir(Pessoa pessoa) throws SQLException {
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "INSERT INTO contato "
				+ "(nome, fone, email, endereco) "
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getFone());
		ps.setString(3, pessoa.getEmail());
		ps.setString(4, pessoa.getEndereco());
		ps.execute();
		ps.close();
		con.close();
	}
	
	public void alterar(Pessoa pessoa) throws SQLException {
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "UPDATE contato "
						+ "SET nome = ?, fone = ?, "
						+ "email = ?, endereco = ? "
						+ "WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getFone());
		ps.setString(3, pessoa.getEmail());
		ps.setString(4, pessoa.getEndereco());
		ps.setLong(5, pessoa.getId());
		ps.execute();
		ps.close();
		con.close();
	}

	public void deletar(int id) throws SQLException {
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "DELETE FROM contato WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		con.close();
	}
	
}
