package br.com.agenda.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.controles.PessoaControle;
import br.com.agenda.entidades.Pessoa;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmAgenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtProcurar;
	private JTable table;
	private JFormattedTextField frmtdtxtfldFone;
	private JTextArea txtrEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgenda frame = new FrmAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAgenda() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				limpar();
				atualizarTabela();
				txtProcurar.requestFocus();
			}
		});
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 488);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 550, 198);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("id:");
		lblId.setBounds(23, 29, 55, 16);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText("id");
		txtId.setBounds(96, 27, 55, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 61, 55, 16);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(96, 59, 426, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(228, 93, 38, 16);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setBounds(284, 91, 238, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblFone = new JLabel("Fone:");
		lblFone.setBounds(23, 93, 55, 16);
		panel.add(lblFone);

		frmtdtxtfldFone = new JFormattedTextField();
		frmtdtxtfldFone.setText("Fone");
		frmtdtxtfldFone.setBounds(96, 91, 114, 20);
		panel.add(frmtdtxtfldFone);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(21, 122, 57, 16);
		panel.add(lblEndereo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 121, 426, 62);
		panel.add(scrollPane);

		txtrEndereco = new JTextArea();
		scrollPane.setViewportView(txtrEndereco);
		txtrEndereco.setText("Endere\u00E7o");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Todos os Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 222, 550, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblProcurar = new JLabel("Procurar:");
		lblProcurar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblProcurar.setBounds(12, 27, 55, 16);
		panel_1.add(lblProcurar);

		txtProcurar = new JTextField();
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				atualizarTabela();
			}
		});
		txtProcurar.setText("Procurar");
		txtProcurar.setBounds(85, 25, 440, 20);
		panel_1.add(txtProcurar);
		txtProcurar.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 55, 513, 111);
		panel_1.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editar();
			}
		});
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Endere\u00E7o", "E-mail", "Fone", "Nome", "id" }));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setMnemonic('s');
		btnSalvar.setBounds(244, 412, 98, 26);
		contentPane.add(btnSalvar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		btnDeletar.setMnemonic('d');
		btnDeletar.setBounds(354, 412, 98, 26);
		contentPane.add(btnDeletar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				txtNome.requestFocus();
			}
		});
		btnNovo.setMnemonic('n');
		btnNovo.setBounds(134, 412, 98, 26);
		contentPane.add(btnNovo);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				atualizarTabela();
				txtProcurar.requestFocus();
			}
		});
		btnAtualizar.setMnemonic('a');
		btnAtualizar.setBounds(24, 412, 98, 26);
		contentPane.add(btnAtualizar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setMnemonic('f');
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fechar();
			}
		});
		btnFechar.setBounds(464, 412, 98, 26);
		contentPane.add(btnFechar);
	}

	private void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Integer.valueOf(txtId.getText()));
		String nome = txtNome.getText();
		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome");
			txtNome.requestFocus();
			return;
		} else {
			pessoa.setNome(nome);
		}
		pessoa.setFone(frmtdtxtfldFone.getText());
		pessoa.setEmail(txtEmail.getText());
		pessoa.setEndereco(txtrEndereco.getText());
		PessoaControle.salvar(pessoa);
		limpar();
		atualizarTabela();
		txtProcurar.requestFocus();
	}

	private void atualizarTabela() {
		table.setModel(PessoaControle.todosContatos(txtProcurar.getText()));
	}

	private void fechar() {
		int resp = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja fechar?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			// System.exit(0);
			dispose();
		}
	}

	private void limpar() {
		txtProcurar.setText(null);
		txtId.setText("0");
		txtNome.setText(null);
		frmtdtxtfldFone.setText(null);
		txtEmail.setText(null);
		txtrEndereco.setText(null);
	}
	
	public void editar() {
		int linha = table.getSelectedRow();
		txtId.setText(table.getValueAt(linha, 0).toString());
		txtNome.setText(table.getValueAt(linha, 1).toString());
		frmtdtxtfldFone.setText(table.getValueAt(linha, 2).toString());
		txtEmail.setText(table.getValueAt(linha, 3).toString());
		txtrEndereco.setText("" + table.getValueAt(linha, 4));
	}
	
	public void deletar() {
		int id = Integer.valueOf(txtId.getText());
		if (id == 0) {
			JOptionPane.showMessageDialog
				(null, "Selecione um contato");
			return;
		}
		int resp = JOptionPane.showConfirmDialog
				(null, "Deseja apagar este contato?",
						"Agenda", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			PessoaControle.deletar(id);
		}
	}
	
}
