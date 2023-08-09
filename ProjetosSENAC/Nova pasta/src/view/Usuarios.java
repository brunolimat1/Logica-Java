package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Usuarios extends JDialog {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/users.png")));
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
			lblNewLabel_1.setBounds(30, 65, 25, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nome:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 100, 57, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Login:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 130, 46, 26);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Senha:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(30, 175, 57, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setBounds(86, 62, 46, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(86, 98, 150, 20);
			contentPanel.add(txtNome);
		}
		{
			txtLogin = new JTextField();
			txtLogin.setColumns(10);
			txtLogin.setBounds(86, 135, 226, 20);
			contentPanel.add(txtLogin);
		}
		{
			JButton btnBuscar = new JButton("");
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
			btnBuscar.setBounds(107, 205, 64, 64);
			contentPanel.add(btnBuscar);
			getRootPane().setDefaultButton(btnBuscar);		
			}
		{
			JButton btnLimpar = new JButton("");
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
			btnLimpar.setBounds(235, 205, 64, 64);
			contentPanel.add(btnLimpar);
		}

		txtSenha = new JPasswordField();
		txtSenha.setBounds(86, 174, 226, 20);
		contentPanel.add(txtSenha);
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
}
