package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

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

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
	private JTextField txtID;
	private JTextField txtComplemento;
	private JLabel lblNmero;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblUF;
	private JComboBox<?> cboUf;
	private JTextField txtNumero;

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
		setBounds(100, 100, 760, 670);

		JPanel contentPanel = new JPanel();
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setBounds(289, 11, 151, 19);
		lblNewLabel.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblNome.setBounds(10, 102, 50, 19);
		contentPanel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(60, 103, 674, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 139, 64, 19);
		contentPanel.add(lblTelefone);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblCep.setBounds(298, 138, 38, 19);
		contentPanel.add(lblCep);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 180, 74, 19);
		contentPanel.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(84, 181, 428, 20);
		contentPanel.add(txtEndereco);

		JLabel lblEquipamentoDefeituoso = new JLabel("Equipamento Defeituoso:");
		lblEquipamentoDefeituoso.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblEquipamentoDefeituoso.setBounds(10, 304, 170, 19);
		contentPanel.add(lblEquipamentoDefeituoso);

		txtEquipamento = new JComboBox();
		txtEquipamento.setModel(new DefaultComboBoxModel(new String[] { "", "Impressora Sti" }));
		txtEquipamento.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		txtEquipamento.setBounds(10, 328, 724, 25);
		contentPanel.add(txtEquipamento);

		JLabel lblDescrevaOsProblemas = new JLabel("Descreva os problemas encontrados no equipamento:");
		lblDescrevaOsProblemas.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblDescrevaOsProblemas.setBounds(10, 372, 358, 19);
		contentPanel.add(lblDescrevaOsProblemas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 402, 724, 130);
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
		btnLimpar.setBounds(10, 589, 102, 23);
		contentPanel.add(btnLimpar);
		btnCadastrar.setBounds(10, 543, 102, 23);
		contentPanel.add(btnCadastrar);

		MaskFormatter tel = null;
		try {
			tel = new MaskFormatter("(##) #####.####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setBounds(84, 140, 204, 19);
		contentPanel.add(txtTelefone);

		MaskFormatter cep = null;
		try {
			cep = new MaskFormatter("#####-###");
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtCep = new JFormattedTextField(cep);
		txtCep.setBounds(337, 139, 204, 19);
		contentPanel.add(txtCep);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(632, 543, 102, 23);
		contentPanel.add(btnEditar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 567, 102, 23);
		contentPanel.add(btnBuscar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(632, 589, 102, 23);
		contentPanel.add(btnExcluir);

		JLabel lblidCliente = new JLabel("ID:");
		lblidCliente.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblidCliente.setBounds(10, 63, 50, 19);
		contentPanel.add(lblidCliente);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(35, 64, 64, 20);
		contentPanel.add(txtID);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblComplemento.setBounds(10, 221, 102, 19);
		contentPanel.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(111, 222, 270, 20);
		contentPanel.add(txtComplemento);

		lblNmero = new JLabel("Número:");
		lblNmero.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblNmero.setBounds(535, 180, 74, 19);
		contentPanel.add(lblNmero);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblBairro.setBounds(391, 221, 74, 19);
		contentPanel.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(445, 220, 289, 20);
		contentPanel.add(txtBairro);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblCidade.setBounds(10, 260, 102, 19);
		contentPanel.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(67, 261, 314, 20);
		contentPanel.add(txtCidade);

		lblUF = new JLabel("UF:");
		lblUF.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 15));
		lblUF.setBounds(402, 262, 38, 19);
		contentPanel.add(lblUF);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
		cboUf.setBounds(444, 257, 290, 25);
		contentPanel.add(cboUf);

		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscarCep.setBounds(551, 134, 102, 28);
		contentPanel.add(btnBuscarCep);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(599, 181, 135, 20);
		contentPanel.add(txtNumero);

	}// FIM DO CONSTRUTOR

	private void limpar() {
		txtID.setText(null);
		txtNome.setText(null);
		txtTelefone.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtEquipamento.setSelectedItem(null);
		txtProblema.setText(null);
		btnCadastrar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnBuscar.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnLimpar.setEnabled(false);
	}

	private void cadastrar() {
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
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
			String create = "insert into clientes (nome, telefone, cep, endereco, numero, complemento, bairro, cidade, uf, equipamento, problema) values (?,?,?,?,?,?,?,?,?,?,?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtTelefone.getText());
				pst.setString(3, txtCep.getText());
				pst.setString(4, txtEndereco.getText());
				pst.setString(5, txtNumero.getText());
				pst.setString(6, txtComplemento.getText());
				pst.setString(7, txtBairro.getText());
				pst.setString(8, txtCidade.getText());
				pst.setString(9, cboUf.getSelectedItem().toString());
				pst.setString(10, txtEquipamento.getSelectedItem().toString());
				pst.setString(11, txtProblema.getText());
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
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
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
			String update = "update clientes set nome=?,telefone=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,uf=?,equipamento=?,problema=? where id=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(12, txtID.getText());
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtTelefone.getText());
				pst.setString(3, txtCep.getText());
				pst.setString(4, txtEndereco.getText());
				pst.setString(5, txtNumero.getText());
				pst.setString(6, txtComplemento.getText());
				pst.setString(7, txtBairro.getText());
				pst.setString(8, txtCidade.getText());
				pst.setString(9, cboUf.getSelectedItem().toString());
				pst.setString(10, txtEquipamento.getSelectedItem().toString());
				pst.setString(11, txtProblema.getText());
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
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente!");
			txtNome.requestFocus();
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
				String delete = "delete from clientes where id=?";
				// tratamento de exceções
				try {
					// abrir a conexão
					con = dao.conectar();
					// preparar a query (instrução sql)
					pst = con.prepareStatement(delete);
					// substituir a ? pelo id do contato
					pst.setString(1, txtID.getText());
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
		if (txtNome.getText().isEmpty()) {
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
					txtID.setText(rs.getString(1));
					txtNome.setText(rs.getString(2));
					txtTelefone.setText(rs.getString(3));
					txtCep.setText(rs.getString(4));
					txtEndereco.setText(rs.getString(5));
					txtNumero.setText(rs.getString(6));
					txtComplemento.setText(rs.getString(7));
					txtBairro.setText(rs.getString(8));
					txtCidade.setText(rs.getString(9));
					cboUf.setSelectedItem(rs.getString(10));
					txtEquipamento.setSelectedItem(rs.getString(11));
					txtProblema.setText(rs.getString(12));
					

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

	/**
	 * buscarCep
	 */
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
				System.out.println(e);
		}
	}
}// FIM DO CÓDIGO
