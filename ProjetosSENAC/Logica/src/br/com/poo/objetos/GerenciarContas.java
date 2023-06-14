package br.com.poo.objetos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GerenciarContas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarContas frame = new GerenciarContas();
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
	public GerenciarContas() {
		setTitle("Gerenciar Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 344, 22);
		contentPane.add(menuBar);

		JMenu mnuAbrirConta = new JMenu("Abrir Conta");
		mnuAbrirConta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnuAbrirConta);

		JMenuItem mniPoupanca = new JMenuItem("Poupança");
		mniPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaPoupanca().setVisible(true);

			}
		});
		mnuAbrirConta.add(mniPoupanca);

		JMenuItem mniCorrente = new JMenuItem("Corrente");
		mnuAbrirConta.add(mniCorrente);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 22, 344, 419);
		contentPane.add(lblNewLabel);
	}
}
