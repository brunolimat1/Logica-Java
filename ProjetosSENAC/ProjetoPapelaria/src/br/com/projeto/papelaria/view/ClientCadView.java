package br.com.projeto.papelaria.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ClientCadView extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txt;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;
	private JTextField txtBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientCadView frame = new ClientCadView();
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
	public ClientCadView() {
		setTitle("Cadastrar Cliente");
		setBounds(100, 100, 663, 524);
		getContentPane().setLayout(null);
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBackground(new Color(255, 255, 255));
		pnlCliente.setBounds(10, 11, 627, 81);
		getContentPane().add(pnlCliente);
		pnlCliente.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Cliente:");
		lblNewLabel.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 15, 99, 14);
		pnlCliente.add(lblNewLabel);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblCPF.setBounds(317, 15, 28, 15);
		pnlCliente.add(lblCPF);
		
		MaskFormatter cpf = null;
		try {	cpf = new MaskFormatter("###.###.###-##"); }
		catch(Exception e) { e.printStackTrace();}
		
		JFormattedTextField txtCPF = new JFormattedTextField(cpf);
		txtCPF.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 11));
		txtCPF.setBounds(317, 35, 300, 30);
		
		pnlCliente.add(txtCPF);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(7, 35, 300, 30);
		pnlCliente.add(txtCliente);
		txtCliente.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 100, 627, 165);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Logradouro");
		lblNewLabel_1_1_1.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(143, 11, 99, 24);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Número");
		lblNewLabel_1_1_1_1.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(473, 16, 99, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Complemento");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(10, 81, 99, 24);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("CEP");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(143, 86, 99, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Bairro");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(473, 86, 47, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 99, 30);
		panel_1.add(comboBox);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(143, 36, 300, 30);
		panel_1.add(txtLogradouro);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(473, 36, 144, 30);
		panel_1.add(txtNumero);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Tipo:");
		lblNewLabel_1_1_1_2.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 13));
		lblNewLabel_1_1_1_2.setBounds(10, 16, 99, 14);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(10, 111, 99, 30);
		panel_1.add(txtComplemento);
		
		txtCEP = new JTextField();
		txtCEP.setColumns(10);
		txtCEP.setBounds(143, 111, 300, 30);
		panel_1.add(txtCEP);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(473, 111, 144, 30);
		panel_1.add(txtBairro);
		
		JPanel pnlTelefone = new JPanel();
		pnlTelefone.setLayout(null);
		pnlTelefone.setBackground(Color.WHITE);
		pnlTelefone.setBounds(10, 276, 627, 81);
		getContentPane().add(pnlTelefone);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 15, 99, 14);
		pnlTelefone.add(lblNewLabel_1);
		
		JLabel lblCPF_1 = new JLabel("CPF:");
		lblCPF_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCPF_1.setBounds(317, 15, 27, 14);
		pnlTelefone.add(lblCPF_1);
		
		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(317, 36, 300, 30);
		pnlTelefone.add(txt);
		
		
		MaskFormatter tel = null;
		try {	tel = new MaskFormatter("(##) #####.####"); }
		catch(Exception e) { e.printStackTrace();}
		
		JFormattedTextField txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 11));
		txtTelefone.setBounds(9, 36, 300, 30);
		
		pnlTelefone.add(txtTelefone);

	}
}
