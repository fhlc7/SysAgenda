package br.com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.agenda.conexoes.MySQL;

public class ConexaoDAO {
	
	public static void iniciarDataBase(){
		String msg = "Iniciando ajustes em DataBase";
		JOptionPane.showMessageDialog(null, msg);
		try {
			MySQL mySQL = new MySQL();
			String sql = "DROP DATABASE IF EXISTS dbagenda;";
			PreparedStatement ps = mySQL.getConexaoSuper().prepareStatement(sql);
			ps.execute();
			sql = "CREATE DATABASE dbagenda;";
			ps = mySQL.getConexaoSuper().prepareStatement(sql);
			ps.execute();
			sql = "USE dbagenda;";
			ps = mySQL.getConexaoSuper().prepareStatement(sql);
			ps.execute();
			sql = "CREATE TABLE `contato` (`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, `nome` varchar(255) NOT NULL, `fone` varchar(20) DEFAULT NULL, `email` varchar(255) DEFAULT NULL, `endereco` blob );";
			ps = mySQL.getConexao().prepareStatement(sql);
			ps.execute();
			sql = "INSERT INTO `contato` (`id`, `nome`, `fone`, `email`, `endereco`) VALUES (1, 'Maria', '(99) 99999-9999', 'maria@gmail.com', NULL), (2, 'João', '(88) 88888-8888', 'joao@hotmai.com', NULL), (3, 'Pedro', '(77) 77777-7777', 'pedro@outlook.com', NULL), (4, 'Davi', '(99) 91234-5678', 'davi@gmail.com', 0x5275616c2064652043696d61);";
			ps = mySQL.getConexao().prepareStatement(sql);
			ps.execute();
			ps.close();
			msg = "Ajustes no banco de dados realizados com sucesso";
			System.out.println(msg);
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException e) {
			msg = "Erro ao tentar iniciar DataBase: " + e;
			System.out.println(msg);
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	
	public static void main(String[] args) {
		iniciarDataBase();
	}
	
}
