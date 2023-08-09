package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	//objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	//objeto tela principal
	Principal principal = new Principal();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnAcessar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("InfoX - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(44, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(100, 40, 227, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(40, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(100, 88, 227, 20);
		contentPane.add(txtSenha);
		
		btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(238, 143, 89, 23);
		contentPane.add(btnAcessar);
	}//fim do construtor
	
	/**
	 * Método para autenticar um usuário
	 */
	private void logar() {
		//Criar uma variável/objeto para capturar a senha
		String capturaSenha = new String(txtSenha.getPassword());
		
		//validação
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtSenha.requestFocus();
		} else {
			//lógica principal
			String read = "select * from usuarios where login=? and senha=md5(?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read);
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				rs = pst.executeQuery();
				if (rs.next()) {
					//logar -> acessar a tela principal
					principal.setVisible(true);
					//fechar a tela de login(esta tela)
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}//fim do código
