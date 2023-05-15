package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import utils.Validador;

public class Usuarios extends JDialog {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnBuscar;
	private JButton btnAdicionar2;
	private JButton btnEditar2;
	private JButton btnDeletar2;
	private JButton btnLimpar2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Usuarios dialog = new Usuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		setTitle("Contatos");
		setBounds(100, 100, 450, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Buscar Usuarios");
			lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
			lblNewLabel.setBounds(150, 11, 142, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ID:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 60, 25, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nome:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 95, 57, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Login:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 125, 46, 26);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Senha:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 170, 57, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setEnabled(false);
			txtID.setBounds(86, 57, 50, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(86, 93, 250, 20);
			contentPanel.add(txtNome);
			txtNome.setDocument(new Validador(30));
		}
		{
			txtLogin = new JTextField();
			txtLogin.setColumns(10);
			txtLogin.setBounds(86, 130, 250, 20);
			contentPanel.add(txtLogin);
			txtLogin.setDocument(new Validador(10));

		}
		{
			btnBuscar = new JButton("");
			btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBuscar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
			btnBuscar.setToolTipText("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscar();
				}
			});
			btnBuscar.setBounds(346, 108, 64, 64);
			contentPanel.add(btnBuscar);
			getRootPane().setDefaultButton(btnBuscar);
		}
		{
			btnLimpar2 = new JButton("");
			btnLimpar2.setEnabled(false);
			btnLimpar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLimpar2.setIcon(new ImageIcon(Usuarios.class.getResource("/img/eraser.png")));
			btnLimpar2.setToolTipText("Limpar");
			btnLimpar2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			btnLimpar2.setBounds(348, 200, 64, 64);
			contentPanel.add(btnLimpar2);
		}

		txtSenha = new JPasswordField();
		txtSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtSenha.setBounds(86, 169, 250, 20);
		contentPanel.add(txtSenha);
		txtSenha.setDocument(new Validador(15));

		btnAdicionar2 = new JButton("");
		btnAdicionar2.setEnabled(false);
		btnAdicionar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar2.setToolTipText("Adicionar");
		btnAdicionar2.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add.png")));
		btnAdicionar2.setBounds(30, 200, 64, 64);
		contentPanel.add(btnAdicionar2);

		btnEditar2 = new JButton("");
		btnEditar2.setEnabled(false);
		btnEditar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar2.setToolTipText("Editar");
		btnEditar2.setIcon(new ImageIcon(Usuarios.class.getResource("/img/edit.png")));
		btnEditar2.setBounds(135, 200, 64, 64);
		contentPanel.add(btnEditar2);

		btnDeletar2 = new JButton("");
		btnDeletar2.setEnabled(false);
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDeletar2.setToolTipText("Deletar");
		btnDeletar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar2.setIcon(new ImageIcon(Usuarios.class.getResource("/img/trash.png")));
		btnDeletar2.setBounds(247, 200, 64, 64);
		contentPanel.add(btnDeletar2);
		setLocationRelativeTo(null);
	}// fim do construtor

	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
		btnAdicionar2.setEnabled(false);
		btnEditar2.setEnabled(false);
		btnDeletar2.setEnabled(false);
		btnLimpar2.setEnabled(false);
		btnBuscar.setEnabled(true);
	}// fim do método limpar campos

	/**
	 * Método para buscar um contato pelo nome
	 */
	private void buscar() {
		// dica - testar o evento primeiro
		// System.out.println("teste do botão buscar");
		// Criar uma variavel com a query (instrução do banco)
		String read = "select * from usuarios where login = ?";
		// tratamento de exceções
		try {
			// abrir a conexão
			con = dao.conectar();
			// preparar a execução da query (instrução sql - CRUD Read)
			// O parâmetro 1 substitui ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
			pst.setString(1, txtLogin.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrutura if else para verificar se existe
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				// preencher as caixas de texto com as informações de contato
				txtID.setText(rs.getString(1)); // 1 campo da tabela (ID)
				txtNome.setText(rs.getString(2)); // 2 campo da tabela (Nome)
				txtLogin.setText(rs.getString(3)); // 3 campo da tabela (Login)
				txtSenha.setText(rs.getString(4)); // 4 campo da tabela (Senha)
				// habilitar botões
				btnEditar2.setEnabled(true);
				btnDeletar2.setEnabled(true);
				btnLimpar2.setEnabled(true);

			} else {
				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Usuário não Cadastrado!");
				btnAdicionar2.setEnabled(true);
				btnLimpar2.setEnabled(true);
			}
			// fechar a conexão (IMPORTANTE)
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método para adicionar um novo contato
	 */
	private void adicionar() {
		String senha = new String(txtSenha.getPassword());
		// validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o Nome do Usuário!");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o Login do Usuário!");
			txtLogin.requestFocus();
		} else if (senha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a Senha do Usuário!");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			// CRUD Create
			String create = "insert into usuarios(nome,login,senha) values (?,?,?)";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, senha);
				// executa a query(instrução sql (CRUD - Create))
				pst.executeUpdate();
				// confirmar
				JOptionPane.showMessageDialog(null, "Usuário adicionado!");
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
		String senha = new String(txtSenha.getPassword());
		// System.out.println("teste do botão editar");
		// validação dos campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuário!");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Login do Usuário!");
			txtLogin.requestFocus();
		} else if (senha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a Senha do Usuário!");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			// CRUD - Update
			String update = "update usuarios set nome=?,login=?,senha=? where id=?";
			// tratamente de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, senha);
				pst.setString(4, txtID.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do Usuário Editados com Sucesso.");
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
		String senha = new String(txtSenha.getPassword());
		// validação de exclusão - a variável confirma captura a opção escolhida
		// validação dos campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuário!");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Login do Usuário!");
			txtLogin.requestFocus();
		} else if (senha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a Senha do Usuário!");
			txtSenha.requestFocus();
		} else {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "Atenção!",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				// CRUD - Delete
				String delete = "delete from usuarios where id=?";
				// tratamento de exceções
				try {
					// abrir a conexão
					con = dao.conectar();
					// preparar a query (instrução sql)
					pst = con.prepareStatement(delete);
					// substituir a ? pelo id do contato
					pst.setString(1, txtID.getText());
					// executar a query
					pst.executeUpdate();
					// limpar campos
					limparCampos();
					// exibir uma mensagem ao usuário
					JOptionPane.showMessageDialog(null, "Usuário excluído!");
					// fechar a conexão
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} 

	}// fim do método excluirContato
}// FIM DO CÓDIGO
