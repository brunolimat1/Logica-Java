package br.com.estruturas.arquivos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GerenciarArquivos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeArquivo;
	private JTextField txtConteudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarArquivos frame = new GerenciarArquivos();
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
	public GerenciarArquivos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeArquivo = new JLabel("Nome do Arquivo");
		lblNomeArquivo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeArquivo.setBounds(10, 7, 126, 37);
		contentPane.add(lblNomeArquivo);

		JLabel lblConteudo = new JLabel("Conteúdo");
		lblConteudo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConteudo.setBounds(10, 50, 126, 37);
		contentPane.add(lblConteudo);

		txtNomeArquivo = new JTextField();
		txtNomeArquivo.setBounds(110, 11, 545, 28);
		contentPane.add(txtNomeArquivo);
		txtNomeArquivo.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNomeArquivo.getText().trim().equals("") || txtConteudo.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Você deve preencher os campos");
				}

				String s = GerarArquivo.gravar(txtNomeArquivo.getText(), txtConteudo.getText());
				JOptionPane.showMessageDialog(null, s);

			}
		});
		btnGravar.setBounds(269, 316, 89, 23);
		contentPane.add(btnGravar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 645, 218);
		contentPane.add(scrollPane);
		
		JTextArea txtConteudo = new JTextArea();
		scrollPane.setViewportView(txtConteudo);
		setLocationRelativeTo(null);
	}
}
