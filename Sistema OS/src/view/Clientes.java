package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.DAO;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JComboBox<?> txtEquipamento;
	private JTextArea txtProblema;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCep;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnEditar;
	private JButton btnBuscar;
	

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Clientes() {
		setBounds(100, 100, 452, 648);
		
		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setBounds(145, 5, 151, 19);
		lblNewLabel.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblNome.setBounds(10, 35, 50, 19);
		contentPanel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 58, 414, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblEmail.setBounds(10, 89, 50, 19);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 112, 414, 20);
		contentPanel.add(txtEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 143, 64, 19);
		contentPanel.add(lblTelefone);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblCep.setBounds(220, 143, 38, 19);
		contentPanel.add(lblCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 197, 74, 19);
		contentPanel.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 220, 414, 20);
		contentPanel.add(txtEndereco);
		
		JLabel lblEquipamentoDefeituoso = new JLabel("Equipamento Defeituoso:");
		lblEquipamentoDefeituoso.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblEquipamentoDefeituoso.setBounds(10, 251, 170, 19);
		contentPanel.add(lblEquipamentoDefeituoso);
		
		txtEquipamento = new JComboBox();
		txtEquipamento.setModel(new DefaultComboBoxModel(new String[] {"", "Impressora Sti"}));
		txtEquipamento.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		txtEquipamento.setBounds(10, 275, 414, 25);
		contentPanel.add(txtEquipamento);
		
		JLabel lblDescrevaOsProblemas = new JLabel("Descreva os problemas encontrados no equipamento:");
		lblDescrevaOsProblemas.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblDescrevaOsProblemas.setBounds(10, 311, 358, 19);
		contentPanel.add(lblDescrevaOsProblemas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 341, 414, 177);
		contentPanel.add(scrollPane);
		
		txtProblema = new JTextArea();
		scrollPane.setViewportView(txtProblema);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 575, 102, 23);
		contentPanel.add(btnLimpar);
		btnCadastrar.setBounds(10, 529, 102, 23);
		contentPanel.add(btnCadastrar);
		
		MaskFormatter tel = null;
		try {	tel = new MaskFormatter("(##) #####.####"); }
		catch(Exception e) { e.printStackTrace();}
		
		txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setBounds(10, 166, 204, 19);
		contentPanel.add(txtTelefone);
		
		MaskFormatter cep = null;
		try {	cep = new MaskFormatter("#####-###"); }
		catch(Exception e) { e.printStackTrace();}
		
		txtCep = new JFormattedTextField(cep);
		txtCep.setBounds(220, 166, 204, 19);
		contentPanel.add(txtCep);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(324, 529, 102, 23);
		contentPanel.add(btnEditar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(164, 553, 102, 23);
		contentPanel.add(btnBuscar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(322, 575, 102, 23);
		contentPanel.add(btnExcluir);

	}//FIM DO CONSTRUTOR
	
	private void limpar() {
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtEquipamento.setSelectedItem(null);
		txtProblema.setText(null);
		btnCadastrar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnBuscar.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnLimpar.setEnabled(false);
	}
	
	private void cadastrar() {
		if(txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o E-mail do Cliente!");
			txtEmail.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone do Cliente!");
			txtTelefone.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do Cliente!");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço do Cliente!");
			txtEndereco.requestFocus();
		} else if (txtEquipamento.getSelectedItem() == null || txtEquipamento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Coloque o Equipamento Defeituoso!");
			txtEquipamento.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Descreva os Problemas que o Equipamento apresenta!");
			txtProblema.requestFocus();
		} else {
			String create = "insert into clientes (nome, email, telefone, cep, endereco, equipamento, problema) values (?,?,?,?,?,?,?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtEmail.getText());
				pst.setString(3, txtTelefone.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtEndereco.getText());
				pst.setString(6, (String) txtEquipamento.getSelectedItem());
				pst.setString(7, txtProblema.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
				limpar();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void editar() {
		if(txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o E-mail do Cliente!");
			txtEmail.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone do Cliente!");
			txtTelefone.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do Cliente!");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço do Cliente!");
			txtEndereco.requestFocus();
		} else if (txtEquipamento.getSelectedItem() == null || txtEquipamento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Coloque o Equipamento Defeituoso!");
			txtEquipamento.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Descreva os Problemas que o Equipamento apresenta!");
			txtProblema.requestFocus();
		} else {
						String update = "update clientes set nome=?,email=?,telefone=?,cep=?,endereco=?,equipamento=?,problema=? where id=?";
						try {
							con = dao.conectar();
							pst = con.prepareStatement(update);
							pst.setString(1, null);
							pst.setString(2, txtNome.getText());
							pst.setString(3, txtEmail.getText());
							pst.setString(4, txtTelefone.getText());
							pst.setString(5, txtCep.getText());
							pst.setString(6, txtEndereco.getText());
							pst.setString(7, (String) txtEquipamento.getSelectedItem());
							pst.setString(8, txtProblema.getText());
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Dados do Cliente Editados com Sucesso.");
							limpar();
							con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void excluir() {
		if(txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o E-mail do Cliente!");
			txtEmail.requestFocus();
		} else if (txtTelefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Telefone do Cliente!");
			txtTelefone.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do Cliente!");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço do Cliente!");
			txtEndereco.requestFocus();
		} else if (txtEquipamento.getSelectedItem() == null || txtEquipamento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Coloque o Equipamento Defeituoso!");
			txtEquipamento.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Descreva os Problemas que o Equipamento apresenta!");
			txtProblema.requestFocus();
		} else {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "Atenção!",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				// CRUD - Delete
				String delete = "delete from clientes where id='?'";
				// tratamento de exceções
				try {
					// abrir a conexão
					con = dao.conectar();
					// preparar a query (instrução sql)
					pst = con.prepareStatement(delete);
					// substituir a ? pelo id do contato
					pst.setString(1, txtNome.getText());
					// executar a query
					pst.executeUpdate();
					// limpar campos
					limpar();
					// exibir uma mensagem ao usuário
					JOptionPane.showMessageDialog(null, "Cliente Excluído!");
					// fechar a conexão
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} 

	}
	
	private void buscar() {
		if(txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente para buscar!");
			txtNome.requestFocus();
		} else {
			String read = "select * from clientes where nome = ?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read);
				pst.setString(1, txtNome.getText());
				rs = pst.executeQuery();
				if (rs.next()) {
					txtNome.setText(rs.getString(2)); 
					txtEmail.setText(rs.getString(3)); 
					txtTelefone.setText(rs.getString(4)); 
					txtCep.setText(rs.getString(5));
					txtEndereco.setText(rs.getString(6));
					txtEquipamento.setSelectedItem(rs.getString(7));
					txtProblema.setText(rs.getString(8));
					
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnLimpar.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente não Cadastrado!");
					btnCadastrar.setEnabled(true);
					btnLimpar.setEnabled(true);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}//FIM DO CÓDIGO
