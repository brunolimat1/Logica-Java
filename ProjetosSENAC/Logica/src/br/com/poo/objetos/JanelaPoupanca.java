package br.com.poo.objetos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setTitle("Poupança");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTitular = new JLabel("Titular da Conta:");
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitular.setBounds(10, 0, 122, 22);
		contentPane.add(lblTitular);
		
		txtTitularConta = new JTextField();
		txtTitularConta.setColumns(10);
		txtTitularConta.setBounds(10, 22, 324, 22);
		contentPane.add(txtTitularConta);
		
		
		JLabel lblNumeroBanco = new JLabel("Número do Banco:");
		lblNumeroBanco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroBanco.setBounds(189, 55, 132, 22);
		contentPane.add(lblNumeroBanco);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setBounds(189, 77, 145, 22);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		JLabel lblNumeroAgencia = new JLabel("Número da Agência:");
		lblNumeroAgencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroAgencia.setBounds(189, 110, 122, 22);
		contentPane.add(lblNumeroAgencia);
		
		txtNumeroAgencia = new JTextField();
		txtNumeroAgencia.setColumns(10);
		txtNumeroAgencia.setBounds(189, 136, 145, 20);
		contentPane.add(txtNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroConta.setBounds(10, 110, 122, 22);
		contentPane.add(lblNumeroConta);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(10, 136, 145, 22);
		contentPane.add(txtNumeroConta);
		
		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaldo.setBounds(10, 55, 122, 22);
		contentPane.add(lblSaldo);
		
		txtSaldoConta = new JTextField();
		txtSaldoConta.setColumns(10);
		txtSaldoConta.setBounds(10, 77, 145, 22);
		contentPane.add(txtSaldoConta);
		
		JLabel lblAniversario = new JLabel("Aniversário:");
		lblAniversario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAniversario.setBounds(10, 172, 122, 22);
		contentPane.add(lblAniversario);
		
		txtAniversario = new JTextField();
		txtAniversario.setColumns(10);
		txtAniversario.setBounds(10, 195, 145, 22);
		contentPane.add(txtAniversario);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		
		btnAbrirConta.setBounds(10, 224, 150, 23);
		contentPane.add(btnAbrirConta);
		
		JButton btnVerificarSaldo = new JButton("Verificar Saldo");
		btnVerificarSaldo.setBounds(184, 224, 150, 22);
		contentPane.add(btnVerificarSaldo);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(10, 258, 150, 22);
		contentPane.add(btnDepositar);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setBounds(184, 258, 150, 22);
		contentPane.add(btnSacar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 291, 324, 150);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 344, 461);
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



