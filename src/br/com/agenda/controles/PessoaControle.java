package br.com.agenda.controles;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.dao.PessoaDAO;
import br.com.agenda.entidades.Pessoa;

public class PessoaControle {

	public static DefaultTableModel todosContatos() {
		DefaultTableModel model = null;
		try {
			String[] colunas = {"id", "Nome", "Fone", "E-mail","Endere�o"};
			model = new DefaultTableModel(null, colunas) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			PessoaDAO dao = new PessoaDAO();
			List<Pessoa> lista = dao.listarTodos();
			for (Pessoa pessoa : lista) {
				model.addRow(
						new Object[] {
							pessoa.getId(),
							pessoa.getNome(),
							pessoa.getFone(),
							pessoa.getEmail(),
							pessoa.getEndereco()
						}
					);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar preencher tabela: " + e);
		}
		return model;
	}
	
}