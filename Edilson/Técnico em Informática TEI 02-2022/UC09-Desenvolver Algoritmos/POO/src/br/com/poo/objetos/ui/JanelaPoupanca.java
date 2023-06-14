package br.com.poo.objetos.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.classes.ContaPoupanca;

public class JanelaPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtNumeroAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitularConta;
	private JTextField txtSaldoConta;
	private JTextField txtAniversario;
	private ContaPoupanca cp;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JanelaPoupanca() {
		setTitle("Conta Poupança");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblNumeroBanco = new JLabel("Número do Banco:");
		lblNumeroBanco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroBanco.setBounds(10, 11, 122, 22);
		contentPane.add(lblNumeroBanco);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setBounds(10, 35, 145, 22);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		JLabel lblNumeroAgencia = new JLabel("Número da Agência:");
		lblNumeroAgencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroAgencia.setBounds(165, 11, 122, 22);
		contentPane.add(lblNumeroAgencia);
		
		txtNumeroAgencia = new JTextField();
		txtNumeroAgencia.setColumns(10);
		txtNumeroAgencia.setBounds(165, 35, 145, 22);
		contentPane.add(txtNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroConta.setBounds(320, 11, 122, 22);
		contentPane.add(lblNumeroConta);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(320, 35, 145, 22);
		contentPane.add(txtNumeroConta);
		
		JLabel lblTitular = new JLabel("Titular da Conta:");
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitular.setBounds(10, 68, 122, 22);
		contentPane.add(lblTitular);
		
		txtTitularConta = new JTextField();
		txtTitularConta.setColumns(10);
		txtTitularConta.setBounds(10, 92, 455, 22);
		contentPane.add(txtTitularConta);
		
		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaldo.setBounds(10, 126, 122, 22);
		contentPane.add(lblSaldo);
		
		txtSaldoConta = new JTextField();
		txtSaldoConta.setColumns(10);
		txtSaldoConta.setBounds(10, 150, 218, 22);
		contentPane.add(txtSaldoConta);
		
		txtAniversario = new JTextField();
		txtAniversario.setColumns(10);
		txtAniversario.setBounds(238, 150, 227, 22);
		contentPane.add(txtAniversario);
		
		JLabel lblAniversario = new JLabel("Aniversário:");
		lblAniversario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAniversario.setBounds(247, 126, 122, 22);
		contentPane.add(lblAniversario);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		
		btnAbrirConta.setBounds(10, 183, 218, 43);
		contentPane.add(btnAbrirConta);
		
		JButton btnVerificarSaldo = new JButton("Verificar Saldo");
		btnVerificarSaldo.setBounds(238, 183, 227, 43);
		contentPane.add(btnVerificarSaldo);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(10, 237, 218, 43);
		contentPane.add(btnDepositar);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setBounds(238, 237, 227, 43);
		contentPane.add(btnSacar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 291, 454, 188);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaPoupanca.class.getResource("/br/com/poo/images/teg-itau-itubers-21.jpg")));
		lblNewLabel.setBounds(10, 0, 734, 490);
		contentPane.add(lblNewLabel);
		
		
		
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp = new ContaPoupanca();
				String rs = cp.abrirConta(
						Long.parseLong(txtNumeroBanco.getText()),
						Long.parseLong(txtNumeroAgencia.getText()),
						Long.parseLong(txtNumeroConta.getText()),
						txtTitularConta.getText(),
						Double.parseDouble(txtSaldoConta.getText()));
				txtResultado.setText(rs);
				txtNumeroBanco.setEnabled(false);
				txtNumeroAgencia.setEnabled(false);
				txtNumeroConta.setEnabled(false);
				txtTitularConta.setEnabled(false);
				txtSaldoConta.setEnabled(false);
				btnAbrirConta.setEnabled(false);
				
				
			}
		});
		
		
	}
}



