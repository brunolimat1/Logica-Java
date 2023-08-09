package view;

import java.awt.EventQueue;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JDialog {
	private JTextField txtNome;
	private JTextField txtID;
	private JTextField txtFone;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JComboBox cboUf;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnPesquisar;

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
		setTitle("Clientes");
		setBounds(100, 100, 717, 572);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(61, 83, 46, 14);
		getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(117, 80, 331, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fone");
		lblNewLabel_1.setBounds(61, 136, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(61, 36, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtID = new JTextField();
		txtID.setBounds(117, 33, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		txtFone = new JTextField();
		txtFone.setBounds(117, 133, 192, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);

		txtCep = new JTextField();
		txtCep.setBounds(117, 192, 115, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CEP");
		lblNewLabel_3.setBounds(74, 195, 33, 14);
		getContentPane().add(lblNewLabel_3);

		JButton btnBuscarCep = new JButton("buscar CEP");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscarCep.setBounds(259, 191, 115, 23);
		getContentPane().add(btnBuscarCep);

		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setBounds(49, 255, 68, 14);
		getContentPane().add(lblNewLabel_4);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(117, 249, 369, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(352, 310, 46, 14);
		getContentPane().add(lblNewLabel_5);

		txtBairro = new JTextField();
		txtBairro.setBounds(408, 307, 244, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setBounds(510, 255, 46, 14);
		getContentPane().add(lblNewLabel_6);

		txtNumero = new JTextField();
		txtNumero.setBounds(566, 252, 86, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Complemento");
		lblNewLabel_7.setBounds(26, 310, 91, 14);
		getContentPane().add(lblNewLabel_7);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(117, 307, 151, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Cidade");
		lblNewLabel_8.setBounds(49, 374, 58, 14);
		getContentPane().add(lblNewLabel_8);

		txtCidade = new JTextField();
		txtCidade.setBounds(117, 371, 338, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("UF");
		lblNewLabel_9.setBounds(484, 374, 46, 14);
		getContentPane().add(lblNewLabel_9);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(61, 455, 89, 23);
		getContentPane().add(btnAdicionar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(185, 455, 89, 23);
		getContentPane().add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(310, 455, 89, 23);
		getContentPane().add(btnExcluir);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(479, 79, 97, 23);
		getContentPane().add(btnPesquisar);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(523, 370, 53, 22);
		getContentPane().add(cboUf);

	}// fim do construtor

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
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						System.out.println("OK");
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

}// fim do código
