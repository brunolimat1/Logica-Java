package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
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

public class Usuarios extends JDialog {
	/**
	 * 
	 */
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
			txtID.setBounds(86, 57, 46, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(86, 93, 150, 20);
			contentPanel.add(txtNome);
		}
		{
			txtLogin = new JTextField();
			txtLogin.setColumns(10);
			txtLogin.setBounds(86, 130, 226, 20);
			contentPanel.add(txtLogin);
		}
		{
			JButton btnBuscar = new JButton("");
			btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBuscar.setContentAreaFilled(false);
			btnBuscar.setBorder(null);
			btnBuscar.setBorderPainted(false);
			btnBuscar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search.png")));
			btnBuscar.setToolTipText("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscar();
				}
			});
			btnBuscar.setBounds(360, 65, 64, 64);
			contentPanel.add(btnBuscar);
			getRootPane().setDefaultButton(btnBuscar);
		}
		{
			JButton btnLimpar = new JButton("");
			btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLimpar.setContentAreaFilled(false);
			btnLimpar.setBorder(null);
			btnLimpar.setBorderPainted(false);
			btnLimpar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/trash.png")));
			btnLimpar.setToolTipText("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			btnLimpar.setBounds(360, 200, 64, 64);
			contentPanel.add(btnLimpar);
		}

		txtSenha = new JPasswordField();
		txtSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtSenha.setBounds(86, 169, 226, 20);
		contentPanel.add(txtSenha);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add3.png")));
		btnAdicionar.setBounds(30, 200, 64, 64);
		contentPanel.add(btnAdicionar);

		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setToolTipText("Editar");
		btnEditar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/edit3.png")));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setBounds(135, 200, 64, 64);
		contentPanel.add(btnEditar);

		JButton btnDeletar = new JButton("");
		btnDeletar.setToolTipText("Deletar");
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete3.png")));
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBorderPainted(false);
		btnDeletar.setBounds(247, 200, 64, 64);
		contentPanel.add(btnDeletar);
	}// fim do construtor

	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
	}// fim do método limpar campos

	/**
	 * Método para buscar um contato pelo nome
	 */
	private void buscar() {
		// dica - testar o evento primeiro
		// dica - testar o evento primeiro
		// System.out.println("teste do botão buscar");
		// Criar uma variavel com a query (instrução do banco)
		String read = "select * from usuarios where nome = ?";
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
				txtLogin.setText(rs.getString(3)); // 3 campo da tabela (Fone)
				txtSenha.setText(rs.getString(4)); // 4 campo da tabela (Email)

			} else {
				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Úsuario não Cadastrado!");
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
	@SuppressWarnings("deprecation")
	private void adicionar() {
		// System.out.println("teste");
		// validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o login do contato");
			txtLogin.requestFocus();
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
				pst.setString(3, txtSenha.getText());
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
	@SuppressWarnings("deprecation")
	private void editarContato() {
		// System.out.println("teste do botão editar");
		// validação dos campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do contato");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o fone do contato");
			txtLogin.requestFocus();
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
				pst.setString(3, txtSenha.getText());
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
}
