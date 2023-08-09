package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DAO;

public class Agenda extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// ativação da janela
				status();
			}
		});
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_0 = new JLabel("ID:");
		lblNewLabel_0.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_0.setBounds(45, 70, 48, 20);
		contentPane.add(lblNewLabel_0);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setBounds(93, 70, 40, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 120, 60, 20);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(93, 120, 267, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fone:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(41, 170, 60, 20);
		contentPane.add(lblNewLabel_2);

		txtFone = new JTextField();
		txtFone.setBounds(93, 170, 150, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(41, 220, 60, 20);
		contentPane.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setBounds(93, 220, 267, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Agenda.class.getResource("/img/edit3.png")));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setToolTipText("Editar Contato");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setBorder(null);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBounds(140, 300, 48, 48);
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete3.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setToolTipText("Excluir Contato");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorder(null);
		btnExcluir.setBounds(240, 300, 48, 48);
		contentPane.add(btnExcluir);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(Agenda.class.getResource("/img/add3.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar Contato");
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorder(null);
		btnAdicionar.setBounds(45, 300, 48, 48);
		contentPane.add(btnAdicionar);

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Agenda.class.getResource("/img/trash3.png")));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorder(null);
		btnLimpar.setToolTipText("Limpar Tudo");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(340, 300, 48, 48);
		contentPane.add(btnLimpar);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(Agenda.class.getResource("/img/search3.png")));
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorder(null);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento clicar no botão
				buscar();
			}

		});
		btnPesquisar.setBounds(380, 99, 41, 41);
		contentPane.add(btnPesquisar);
		getRootPane().setDefaultButton(btnPesquisar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff3.png")));
		lblStatus.setBounds(10, 11, 24, 24);
		contentPane.add(lblStatus);

		JButton btnSobre = new JButton("");
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about3.png")));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clicar no botão sobre
				// mostrar a janela sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setBounds(406, 11, 24, 24);
		contentPane.add(btnSobre);
	}// FIM DO CONSTRUTOR

	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
	}// fim do método limpar campos

	/**
	 * Método responsável por exibir o status da conexão
	 */
	private void status() {
		try {
			// abrir a conexão
			con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff3.png")));
			} else {
				// System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon3.png")));
			}
			// NUNCA esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método status()

	/**
	 * Método para buscar um contato pelo nome
	 */
	private void buscar() {
		// dica - testar o evento primeiro
		// System.out.println("teste do botão buscar");
		// Criar uma variavel com a query (instrução do banco)
		String read = "select * from contatos where nome = ?";
		// tratamento de exceções
		try {
			// abrir a conexão
			con = dao.conectar();
			// preparar a execução da query (instrução sql - CRUD Read)
			// O parâmetro 1 substitui ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
			pst.setString(1, txtNome.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrutura if else para verificar se existe
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				// preencher as caixas de texto com as informações de contato
				txtID.setText(rs.getString(1)); // 1 campo da tabela (ID)
				txtFone.setText(rs.getString(3)); // 3 campo da tabela (Fone)
				txtEmail.setText(rs.getString(4)); // 4 campo da tabela (Email)

			} else {
				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Contato não cadastrado!");
			}
			// fechar a conexão (IMPORTANTE)
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método buscar

	/**
	 * Método para adicionar um novo contato
	 */
	private void adicionar() {
		// System.out.println("teste");
		// validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o fone do contato");
			txtFone.requestFocus();
		} else {
			// lógica principal
			// CRUD Create
			String create = "insert into contatos(nome,fone,email) values (?,?,?)";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// executa a query(instrução sql (CRUD - Create))
				pst.executeUpdate();
				// confirmar
				JOptionPane.showMessageDialog(null, "Contato adicionado");
				// limpar os campos
				limparCampos();
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// fim do método adicionar

	/**
	 * Método para editar um contato (ATENÇÃO! usar o id)
	 */
	private void editarContato() {
		// System.out.println("teste do botão editar");
		// validação dos campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o fone do contato");
			txtFone.requestFocus();
		} else {
			// lógica principal
			// CRUD - Update
			String update = "update contatos set nome=?,fone=?,email=? where id=?";
			// tratamente de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtID.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do contato editados com sucesso.");
				// limpar os campos
				limparCampos();
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// fim do método editar contato

	/**
	 * Método usado para excluir um contato
	 */
	private void excluirContato() {
		//System.out.println("teste do botão excluir");
		//validação de exclusão - a variável confirma captura a opção escolhida
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato?","Atenção!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			//CRUD - Delete
			String delete = "delete from contatos where id=?";
			//tratamento de exceções
			try {
				//abrir a conexão
				con = dao.conectar();
				//preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				//substituir a ? pelo id do contato
				pst.setString(1, txtID.getText());
				//executar a query
				pst.executeUpdate();
				//limpar campos
				limparCampos();
				//exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Contato excluído");
				//fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
	} //fim do método excluirContato

}// FIM DO CÓDIGO