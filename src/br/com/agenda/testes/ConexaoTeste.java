package br.com.agenda.testes;

import br.com.agenda.conexoes.MySQL;

public class ConexaoTeste {
	
	public static void main(String[] args) {
		MySQL sql = new MySQL();
		sql.getConexao();
	}
	
}
