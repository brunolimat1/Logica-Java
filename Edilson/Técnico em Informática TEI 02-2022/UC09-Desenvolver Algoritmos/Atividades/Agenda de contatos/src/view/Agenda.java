package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btnLimpar;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		setTitle("Agenda de Contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/note.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 364);
		btnLimpar = new JPanel();
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnLimpar.setToolTipText("Adicionar Contato");
		btnLimpar.setBorder(null);
		btnLimpar.setForeground(new Color(0, 128, 64));
		btnLimpar.setBackground(SystemColor.menu);

		setContentPane(btnLimpar);
		btnLimpar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(25, 70, 49, 23);
		btnLimpar.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(63, 71, 86, 20);
		btnLimpar.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(25, 105, 46, 14);
		btnLimpar.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(63, 102, 271, 20);
		btnLimpar.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setBounds(25, 133, 46, 14);
		btnLimpar.add(lblNewLabel_2);
		
		txtFone = new JTextField();
		txtFone.setBounds(63, 130, 183, 20);
		btnLimpar.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(25, 158, 46, 14);
		btnLimpar.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(63, 155, 361, 20);
		btnLimpar.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar Contato");
		btnAdicionar.setBorder(null);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setForeground(SystemColor.activeCaption);
		btnAdicionar.setBackground(SystemColor.activeCaption);
		btnAdicionar.setIcon(new ImageIcon(Agenda.class.getResource("/img/adicionar.png")));
		btnAdicionar.setBounds(25, 225, 62, 67);
		btnLimpar.add(btnAdicionar);
		
		JButton btnEditar = new JButton("");
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBorder(null);
		btnEditar.setToolTipText("Editar Contato");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setIcon(new ImageIcon(Agenda.class.getResource("/img/edit.png")));
		btnEditar.setBounds(97, 225, 62, 67);
		btnLimpar.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setBorder(null);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setToolTipText("Excluir Contato");
		btnExcluir.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBounds(169, 228, 64, 64);
		btnLimpar.add(btnExcluir);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton_2.setToolTipText("Limpar Campos");
		btnNewButton_2.setIcon(new ImageIcon(Agenda.class.getResource("/img/Borracha.png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(243, 228, 64, 64);
		btnLimpar.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setToolTipText("Pesquisar");
		btnNewButton.setIcon(new ImageIcon(Agenda.class.getResource("/img/Pesquisar.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(336, 91, 38, 41);
		btnLimpar.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblNewLabel_4.setBounds(417, 266, 48, 48);
		btnLimpar.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Saiba Mais");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Agenda.class.getResource("/img/sobre.png")));
		btnNewButton_1.setBounds(417, 11, 48, 48);
		btnLimpar.add(btnNewButton_1);
	} // FIM DO CONSTRUTOR
	
	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
	}
	
} //FIM DO CÓDIGO
