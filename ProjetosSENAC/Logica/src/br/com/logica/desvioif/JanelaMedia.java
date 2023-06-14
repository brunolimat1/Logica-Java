package br.com.logica.desvioif;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaMedia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
	private JTextField txtResultado;
	private String saida = "";
	private double media = 0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMedia frame = new JanelaMedia();
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
	public JanelaMedia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(148, 11, 86, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(148, 42, 86, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);
		
		txtNota3 = new JTextField();
		txtNota3.setBounds(148, 73, 86, 20);
		contentPane.add(txtNota3);
		txtNota3.setColumns(10);
		
		txtNota4 = new JTextField();
		txtNota4.setBounds(148, 104, 86, 20);
		contentPane.add(txtNota4);
		txtNota4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Primeira nota:");
		lblNewLabel.setBounds(10, 14, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Segunda nota:");
		lblNewLabel_1.setBounds(10, 45, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Terceira nota:");
		lblNewLabel_2.setBounds(10, 76, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quarta nota:");
		lblNewLabel_3.setBounds(10, 107, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCalcular = new JButton("Calcular Resultado");
		
		btnCalcular.setBounds(10, 142, 224, 23);
		contentPane.add(btnCalcular);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(10, 176, 224, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				media = (
						Double.parseDouble(txtNota1.getText())+
						Double.parseDouble(txtNota2.getText())+
						Double.parseDouble(txtNota3.getText())+
						Double.parseDouble(txtNota4.getText())
						)/4;
				
				if(media >= 5) {
					saida = "A média do aluno é "+media+" Aprovado";
				}
				else {
					saida = "A média do aluno é "+media+" Reprovado";
				}
				
				
				txtResultado.setText(saida);
				
			}
		});
		
	}
}
