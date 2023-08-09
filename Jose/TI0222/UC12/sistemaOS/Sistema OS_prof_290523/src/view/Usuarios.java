package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.DAO;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios extends JDialog {

	// Instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JList listUsers;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// clicar no painel do JDialog
				scrollPane.setVisible(false);
				txtNome.setText(null);
			}
		});
		setTitle("Usuários");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 511, 325);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(82, 136, 263, 94);
		getContentPane().add(scrollPane);

		listUsers = new JList();
		listUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarUsuarioLista();
			}
		});
		listUsers.setBorder(null);
		scrollPane.setViewportView(listUsers);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(26, 26, 46, 14);
		getContentPane().add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(64, 23, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(26, 116, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// preesionar uma tecla

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// soltar uma tecla
				listarUsuarios();
			}
		});
		txtNome.setBounds(82, 116, 263, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuario();
			}
		});
		btnBuscar.setBounds(306, 73, 89, 23);
		getContentPane().add(btnBuscar);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(26, 77, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtLogin = new JTextField();
		txtLogin.setBounds(82, 74, 201, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(26, 162, 46, 14);
		getContentPane().add(lblNewLabel_3);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(370, 246, 89, 23);
		getContentPane().add(btnLimpar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(82, 159, 263, 20);
		getContentPane().add(txtSenha);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setBounds(49, 246, 89, 23);
		getContentPane().add(btnAdicionar);

	}// fim do construtor

	/**
	 * Método usado para listar o nome dos usuários na lista
	 */
	private void listarUsuarios() {
		// System.out.println("teste");
		// a linha abaixo cria um objeto usando como referência um vetor dinâmico, este
		// objeto irá temporariamente armazenar os nomes
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// setar o modelo (vetor na lista)
		listUsers.setModel(modelo);
		// Query (instrução sql)
		String readLista = "select * from usuarios where nome like '" + txtNome.getText() + "%'" + "order by nome";
		try {
			// abrir a conexão
			con = dao.conectar();
			// preparar a query (instrução sql)
			pst = con.prepareStatement(readLista);
			// executar a query e trazer o resultado para lista
			rs = pst.executeQuery();
			// uso do while para trazer os usuários enquanto existir
			while (rs.next()) {
				// mostrar a barra de rolagem (scrollpane)
				scrollPane.setVisible(true);
				// adicionar os usuarios no vetor -> lista
				modelo.addElement(rs.getString(2));
				// esconder o scrollpane se nenhuma letra for digitada
				if (txtNome.getText().isEmpty()) {
					scrollPane.setVisible(false);
				}
			}
			// fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método que busca o usuário selecionado da lista
	 */
	private void buscarUsuarioLista() {
		// System.out.println("teste");
		// variável que captura o índice da linha da lista
		int linha = listUsers.getSelectedIndex();
		if (linha >= 0) {
			// Query (instrução sql)
			// limit (0,1) -> seleciona o índice 0 e 1 usuário da lista
			String readListaUsuario = "select * from usuarios where nome like '" + txtNome.getText() + "%'"	+ "order by nome limit " + (linha) + " , 1";
			try {
				//abrir a conexão
				con = dao.conectar();
				//preparar a query para execução
				pst = con.prepareStatement(readListaUsuario);
				//executar e obter o resultado
				rs = pst.executeQuery();
				if (rs.next()) {
					//esconder a lista
					scrollPane.setVisible(false);
					//setar os campos
					txtID.setText(rs.getString(1));
					txtNome.setText(rs.getString(2));
					txtLogin.setText(rs.getString(3));
					txtSenha.setText(rs.getString(4));
				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
				}
				//fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// se não existir no banco um usuário da lista
			scrollPane.setVisible(false);
		}
	}

	/**
	 * Método usado para buscar um usuário no banco pelo login
	 */
	private void buscarUsuario() {
		// System.out.println("teste do botão buscar");
		String read = "select * from usuarios where login = ?";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtLogin.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtNome.setText(rs.getString(2));
				txtLogin.setText(rs.getString(3));
				txtSenha.setText(rs.getString(4));
			} else {
				JOptionPane.showMessageDialog(null, "Usuário inexistente");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método para adicionar um novo usuário
	 */
	private void adicionarUsuario() {
		// Criar uma variável/objeto para capturar a senha
		String capturaSenha = new String(txtSenha.getPassword());
		// System.out.println("teste");
		// validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do usuário");
			txtNome.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login do usuário");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha do usuário");
			txtLogin.requestFocus();
		} else {
			// lógica principal
			// CRUD Create
			String create = "insert into usuarios(nome,login,senha) values (?,?,md5(?))";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				// executa a query(instrução sql (CRUD - Create))
				pst.executeUpdate();
				// confirmar
				JOptionPane.showMessageDialog(null, "Usuário adicionado");
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
	 * Limpar campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
		scrollPane.setVisible(false);
	}
}// fim do código
