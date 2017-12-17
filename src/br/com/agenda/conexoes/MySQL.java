package br.com.agenda.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import br.com.agenda.dao.ConexaoDAO;

public class MySQL {
	
	public Connection getConexao() {
		Connection con = null;
		try {
			String caminho = "jdbc:mysql://localhost/dbagenda";
			String usuario = "root";
			String senha = "root";
			con = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar com banco: " + e);
		}
		return con;
	}
	
	public Connection getConexaoSuper() {
		Connection con = null;
		try {
			String caminho = "jdbc:mysql://localhost/";
			String usuario = "root";
			String senha = "root";
			con = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar com banco: " + e);
		}
		return con;
	}
	
	
}
