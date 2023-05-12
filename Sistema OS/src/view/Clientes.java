package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DAO;
import javax.swing.DefaultComboBoxModel;

public class Clientes extends JDialog {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtnome;
	private JTextField txtemail;
	private JTextField txtendereco;
	private JTextField txtcell;
	private JTextField txtcep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setTitle("Cadastro");
		setBounds(100, 100, 456, 576);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel.setBounds(123, 11, 185, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 96, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtnome.setBounds(10, 65, 420, 20);
		getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtemail.setColumns(10);
		txtemail.setBounds(10, 112, 420, 20);
		getContentPane().add(txtemail);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Endereço:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 191, 72, 20);
		getContentPane().add(lblNewLabel_1_1_2);
		
		txtendereco = new JTextField();
		txtendereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtendereco.setColumns(10);
		txtendereco.setBounds(10, 212, 420, 20);
		getContentPane().add(txtendereco);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(10, 145, 62, 14);
		getContentPane().add(lblNewLabel_1_1_1_2);
		
		txtcell = new JTextField();
		txtcell.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtcell.setColumns(10);
		txtcell.setBounds(10, 160, 200, 20);
		getContentPane().add(txtcell);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Equipamento Defeituoso:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2.setBounds(10, 243, 163, 20);
		getContentPane().add(lblNewLabel_1_1_2_2);
		
		JComboBox txtEquipamento = new JComboBox();
		txtEquipamento.setModel(new DefaultComboBoxModel(new String[] {"Impressora nimbus 2000"}));
		txtEquipamento.setBounds(10, 267, 420, 24);
		getContentPane().add(txtEquipamento);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Descreva os problemas encontrados no equipamento:");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_1.setBounds(10, 302, 353, 20);
		getContentPane().add(lblNewLabel_1_1_2_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 324, 420, 130);
		getContentPane().add(scrollPane);
		
		JTextArea txtAreaProblema = new JTextArea();
		scrollPane.setViewportView(txtAreaProblema);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(84, 465, 104, 23);
		getContentPane().add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(259, 465, 104, 23);
		getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("CEP:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2_1.setBounds(221, 143, 62, 14);
		getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		txtcep = new JTextField();
		txtcep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtcep.setColumns(10);
		txtcep.setBounds(220, 160, 210, 20);
		getContentPane().add(txtcep);

	}//Fim do Construtor
	
	private void limparCampos() {
		txtnome.setText(null);
		txtemail.setText(null);
		txtcell.setText(null);
		txtendereco.setText(null);
		txtcep.setText(null);
		
	}
	
	private void cadastrar() {
		// validação de campos obrigatórios
		if (txtnome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o Nome do cliente!");
			txtnome.requestFocus();
		} else if (txtemail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o E-mail do cliente!");
			txtemail.requestFocus();
		} else if (txtcell.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o Telefone do cliente!");
			txtcell.requestFocus();
		} else if (txtcep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o CEP do cliente!");
			txtcep.requestFocus();
		} else if (txtendereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o Endereço do cliente!");
			txtendereco.requestFocus();
		} else {
			// lógica principal
			// CRUD Create
			String create = "insert into clientes (nome, email, telefone, cep, endereco) values ('?','?','?','?','?')";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtnome.getText());
				pst.setString(2, txtemail.getText());
				pst.setString(3, txtcell.getText());
				pst.setString(4, txtcep.getText());
				pst.setString(5, txtendereco.getText());
				// executa a query(instrução sql (CRUD - Create))
				pst.executeUpdate();
				// confirmar
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
				// limpar os campos
				limparCampos();
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}//Fim do Código
