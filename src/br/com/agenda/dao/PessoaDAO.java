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
	
	public List<Pessoa> listarTodos() throws SQLException {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "SELECT * FROM contato;";
		PreparedStatement ps = con.prepareStatement(sql);
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
	
	public void inserir(Pessoa pessoa) {
		MySQL mySQL = new MySQL();
		Connection con = mySQL.getConexao();
		String sql = "INSERT INTO contato "
				+ "(nome, fone, email, endereco) "
				+ "VALUES (?, ?, ?, ?)";
		
	}
	
}
