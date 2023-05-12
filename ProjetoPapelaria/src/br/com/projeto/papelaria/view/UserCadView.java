package br.com.projeto.papelaria.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class UserCadView extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JLabel lblNivelAcesso;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCadView frame = new UserCadView();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserCadView() {
		setTitle("Cadastro de Usuários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserCadView.class.getResource("/br/com/projeto/papelaria/img/background.jpg")));
		lblNewLabel.setBounds(-3, -4, 132, 307);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(128, -1, 311, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setBounds(15, 15, 93, 14);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(14, 40, 287, 36);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(15, 96, 93, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNivelAcesso = new JLabel("Nível Acesso:");
		lblNivelAcesso.setBounds(16, 172, 93, 14);
		panel.add(lblNivelAcesso);
		lblNivelAcesso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(15, 197, 287, 36);
		panel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuário"}));
		
		JButton btnNewButton = new JButton("Gravar Usuário");
		btnNewButton.setBounds(178, 246, 119, 44);
		panel.add(btnNewButton);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(15, 119, 286, 36);
		panel.add(txtSenha);
	}
}
