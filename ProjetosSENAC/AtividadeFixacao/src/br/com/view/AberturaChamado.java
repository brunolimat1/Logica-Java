package br.com.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class AberturaChamado extends JDialog {
	CRUDChamado cc = new CRUDChamado();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDepartamento;
	private JTextArea txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AberturaChamado dialog = new AberturaChamado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AberturaChamado() {
		setTitle("Sistema de Suporte");
		setBounds(100, 100, 675, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha todos os campos para efetuar um chamado");
		lblNewLabel.setFont(new Font("Swis721 Lt BT", Font.BOLD, 17));
		lblNewLabel.setBounds(208, 11, 436, 19);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insira seu nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(208, 64, 111, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(208, 89, 293, 25);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Informe com qual departamento deseja falar:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(208, 147, 300, 19);
		contentPanel.add(lblNewLabel_1_1);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(208, 177, 293, 25);
		contentPanel.add(txtDepartamento);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Conte-nos mais sobre seu problema:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(208, 230, 300, 19);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 260, 436, 211);
		contentPanel.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		JLabel lblRegistrarChamado = new JLabel("Registrar Chamado");
		lblRegistrarChamado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrarChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado();
			}
		});
		lblRegistrarChamado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistrarChamado.setBounds(23, 215, 151, 19);
		contentPanel.add(lblRegistrarChamado);
	}

	public void Chamado() {
		Chamado soliChamado = new Chamado();

		if (txtNome.getText().trim().equals("") || txtDepartamento.getText().trim().equals("")
				|| txtDescricao.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x",
					JOptionPane.ERROR_MESSAGE);
		} else {

			soliChamado.setSolicitacao(txtNome.getText());

			soliChamado.setDepSolicitado(txtDepartamento.getText());

			soliChamado.setDescChamado(txtDescricao.getText());

			JOptionPane.showMessageDialog(null, cc.registrar(soliChamado));

		}

	}
}
