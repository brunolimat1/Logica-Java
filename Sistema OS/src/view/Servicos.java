package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Servicos extends JDialog {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtOS;
	private JTextField txtEquipamentos;
	private JTextField txtDefeito;
	private JTextField txtValor;
	private JTextField txtID;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JFormattedTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Servicos dialog = new Servicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Servicos() {
		setTitle("Serviços");
		setBounds(100, 100, 612, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("OS:");
			lblNewLabel.setBounds(27, 39, 24, 14);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(27, 94, 35, 14);
		contentPanel.add(lblData);

		JLabel lblEquipamentos = new JLabel("Equipamentos:");
		lblEquipamentos.setBounds(27, 154, 89, 14);
		contentPanel.add(lblEquipamentos);

		JLabel lblDefeito = new JLabel("Defeito:");
		lblDefeito.setBounds(27, 208, 46, 14);
		contentPanel.add(lblDefeito);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(27, 272, 35, 14);
		contentPanel.add(lblValor);

		txtOS = new JTextField();
		txtOS.addKeyListener(new KeyAdapter() {

		});
		txtOS.addMouseListener(new MouseAdapter() {

		});
		txtOS.setBounds(55, 36, 131, 20);
		contentPanel.add(txtOS);
		txtOS.setColumns(10);

		txtEquipamentos = new JTextField();
		txtEquipamentos.setColumns(10);
		txtEquipamentos.setBounds(118, 151, 468, 20);
		contentPanel.add(txtEquipamentos);

		txtDefeito = new JTextField();
		txtDefeito.setColumns(10);
		txtDefeito.setBounds(75, 205, 513, 20);
		contentPanel.add(txtDefeito);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(65, 269, 138, 20);
		contentPanel.add(txtValor);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Servicos.class.getResource("/img/search.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(199, 11, 64, 64);
		contentPanel.add(btnBuscar);

		btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(Servicos.class.getResource("/img/add.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBounds(27, 333, 64, 64);
		contentPanel.add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Servicos.class.getResource("/img/edit.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(177, 333, 64, 64);
		contentPanel.add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Servicos.class.getResource("/img/trash.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(337, 333, 64, 64);
		contentPanel.add(btnExcluir);

		JLabel lblIdDoCliente = new JLabel("ID do Cliente:");
		lblIdDoCliente.setBounds(369, 41, 80, 14);
		contentPanel.add(lblIdDoCliente);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(448, 38, 138, 20);
		contentPanel.add(txtID);

		btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Servicos.class.getResource("/img/eraser.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(484, 333, 64, 64);
		contentPanel.add(btnLimpar);

		txtData = new JFormattedTextField();
		txtData.setBounds(65, 91, 138, 20);
		contentPanel.add(txtData);
	}

	private void limparCampos() {
		txtOS.setText(null);
		txtData.setText(null);
		txtEquipamentos.setText(null);
		txtDefeito.setText(null);
		txtValor.setText(null);
		txtID.setText(null);
	}

	private void adicionar() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o ID!");
			txtID.requestFocus();
		} else if (txtEquipamentos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os Equipamentos!");
			txtEquipamentos.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito");
			txtDefeito.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Valor");
			txtValor.requestFocus();
		} else {
			String create = "insert into servicos(equipamentos,defeito,valor, id) values (?,?,?,?)";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, txtEquipamentos.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtValor.getText());
				pst.setString(4, txtID.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "OS cadastrado!");
				limparCampos();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// fim do método adicionar

	private void buscar() {
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a OS!");
			txtOS.requestFocus();
		} else {
			String read = "select * from servicos where OS = ?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read);
				pst.setString(1, txtOS.getText());
				rs = pst.executeQuery();
				if (rs.next()) {
					txtOS.setText(rs.getString(1));
					txtData.setText(rs.getString(2));
					txtEquipamentos.setText(rs.getString(3));
					txtDefeito.setText(rs.getString(4));
					txtValor.setText(rs.getString(5));
					txtID.setText(rs.getString(6));
				} else {
					JOptionPane.showMessageDialog(null, "OS não cadastrada!");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// fim do método buscar

	private void editar() {
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a OS!");
			txtOS.requestFocus();
		} else if (txtData.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(null, "Preencha a Data!");
			txtData.requestFocus();
		} else if (txtEquipamentos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os Equipamentos!");
			txtEquipamentos.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito");
			txtDefeito.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Valor");
			txtValor.requestFocus();
		} else {
			String update = "update servicos set os=?,data_os=?,equipamentos=?,defeito=?,valor=? where id=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(6, txtID.getText());
				pst.setString(1, txtOS.getText());
				pst.setString(2, txtData.getText());
				pst.setString(3, txtEquipamentos.getText());
				pst.setString(4, txtDefeito.getText());
				pst.setString(5, txtValor.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados da OS editados com sucesso!");
				limparCampos();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void excluir() {
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a OS!");
			txtOS.requestFocus();
		} else if (txtData.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(null, "Preencha a Data!");
			txtData.requestFocus();
		} else if (txtEquipamentos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os Equipamentos!");
			txtEquipamentos.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito");
			txtDefeito.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Valor");
			txtValor.requestFocus();
		} else {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desta OS?", "Atenção!",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				// CRUD - Delete
				String delete = "delete from servicos where id=?";
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
					limparCampos();
					// exibir uma mensagem ao usuário
					JOptionPane.showMessageDialog(null, "OS Excluída!");
					// fechar a conexão
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}
}
