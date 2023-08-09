package br.com.poo.objetos.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarContas extends JFrame {

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarContas.class.getResource("/br/com/poo/images/itau.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 672, 22);
		contentPane.add(menuBar);
		
		JMenu mnuAberturaConta = new JMenu("Abertura de Conta");
		menuBar.add(mnuAberturaConta);
		
		JMenuItem mniPoupanca = new JMenuItem("Conta Poupança");
		mniPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaPoupanca().setVisible(true);
				
			}
		});
		mniPoupanca.setIcon(new ImageIcon(GerenciarContas.class.getResource("/br/com/poo/images/poupanca_final.png")));
		mnuAberturaConta.add(mniPoupanca);
		
		JMenuItem mniContaCorrente = new JMenuItem("Conta Corrente");
		mniContaCorrente.setIcon(new ImageIcon(GerenciarContas.class.getResource("/br/com/poo/images/corrente_final.png")));
		mnuAberturaConta.add(mniContaCorrente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GerenciarContas.class.getResource("/br/com/poo/images/itau.png")));
		lblNewLabel.setBounds(0, 22, 672, 306);
		contentPane.add(lblNewLabel);
	}
}
