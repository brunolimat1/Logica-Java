package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	Principal principal = new Principal();
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel lblStatus;
	private JLabel lblData;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

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

	public Login() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/tela de login.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				Data();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setBounds(76, 111, 244, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(20, 114, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 156, 46, 14);
		contentPane.add(lblSenha);

		JButton btnAcessar = new JButton("");
		btnAcessar.setFocusPainted(false);
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/img/Login.png")));
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.setContentAreaFilled(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(142, 205, 48, 48);
		contentPane.add(btnAcessar);
		getRootPane().setDefaultButton(btnAcessar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(76, 153, 244, 20);
		contentPane.add(txtSenha);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 278, 344, 25);
		contentPane.add(panel);
		panel.setLayout(null);

		lblStatus = new JLabel("");
		lblStatus.setBounds(320, 0, 24, 24);
		panel.add(lblStatus);
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/databaseoff.png")));

		lblData = new JLabel("");
		lblData.setBounds(102, 7, 211, 14);
		panel.add(lblData);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/3d-printer.png")));
		lblNewLabel.setBounds(39, 22, 64, 64);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("3DPrintTechGenius");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblNewLabel_1.setBounds(125, 22, 168, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Assistência técnica de Impressoras 3D");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(125, 41, 195, 14);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
	}

	/**
	 * Método para autenticar um usuário
	 */
	private void logar() {
		// Criar uma variável/objeto para capturar a senha
		String capturaSenha = new String(txtSenha.getPassword());

		// validação
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login do Usuário!");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha do Usuário!");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			String read = "select * from usuarios where login = ? and senha = md5(?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read);

				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				rs = pst.executeQuery();
				if (rs.next()) {
					// logar -> acessar a tela principal
					principal.setVisible(true);
					JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso!");
					// fechar tela de login
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário Inexistente!");
					txtLogin.setText(null);
					txtSenha.setText(null);
					txtLogin.requestFocus();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void status() {
		try {
			con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/databaseoff.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/databaseon.png")));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Data() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}
