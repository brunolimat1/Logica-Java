package portfolio;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Portfolio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portfolio frame = new Portfolio();
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
	public Portfolio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//evento "ativar janela"
				Date data = new Date();
		        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		        lblStatus.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portfolio.class.getResource("/img/pc.png")));
		setResizable(false);
		setTitle("Portf\u00F3lio de projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("IMC");
		btnNewButton.setToolTipText("C\u00E1lculo do IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnNewButton.setBounds(133, 28, 64, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sobre");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setToolTipText("Sobre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(321, 280, 64, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setToolTipText("Calculadora da m\u00E9dia");
		btnNewButton_2.setIcon(new ImageIcon(Portfolio.class.getResource("/img/media.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Media media = new Media();
				media.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(37, 28, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Temp");
		btnNewButton_3.setToolTipText("Conversor de temperatura");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversaoTemperatura conversao = new ConversaoTemperatura();
				conversao.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(225, 28, 64, 64);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Hello");
		btnNewButton_4.setToolTipText("Hello World");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				Hello hello = new Hello();
				hello.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(37, 282, 64, 64);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("%");
		btnNewButton_5.setToolTipText("C\u00E1lculo de porcentagem");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculoPorcentagem porcentagem = new CalculoPorcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(321, 28, 64, 64);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Serv");
		btnNewButton_6.setToolTipText("C\u00E1lculo do valor da hora de servi\u00E7o");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppServico servico = new AppServico();
				servico.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(37, 111, 64, 64);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("E x G");
		btnNewButton_7.setToolTipText("Etanol ou Gasolina");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combustivel combustivel = new Combustivel();
				combustivel.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(133, 111, 64, 64);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Eleitor");
		btnNewButton_8.setToolTipText("Sistema elei\u00E7\u00E3o");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleitor eleitor = new Eleitor();
				eleitor.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(225, 111, 64, 64);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Dado");
		btnNewButton_9.setToolTipText("Jogo do dado");
		btnNewButton_9.setBounds(321, 111, 64, 64);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Tab");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_10.setToolTipText("Tabuada");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				tabuada.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(37, 194, 64, 64);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_9_1 = new JButton("J K P");
		btnNewButton_9_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_9_1.setToolTipText("Jokenpo");
		btnNewButton_9_1.setBounds(133, 194, 64, 64);
		contentPane.add(btnNewButton_9_1);
		
		JButton btnNewButton_9_1_1 = new JButton("CEP");
		btnNewButton_9_1_1.setToolTipText("Buscar CEP");
		btnNewButton_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_9_1_1.setBounds(225, 192, 64, 64);
		contentPane.add(btnNewButton_9_1_1);
		
		JButton btnNewButton_9_1_2 = new JButton("Calc");
		btnNewButton_9_1_2.setToolTipText("Calculadora (livre escolha)");
		btnNewButton_9_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_9_1_2.setBounds(321, 192, 64, 64);
		contentPane.add(btnNewButton_9_1_2);
		
		JButton btnNewButton_9_1_3 = new JButton("?");
		btnNewButton_9_1_3.setToolTipText("APP Desafio");
		btnNewButton_9_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_9_1_3.setBounds(225, 280, 64, 64);
		contentPane.add(btnNewButton_9_1_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 392, 563, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStatus = new JLabel("New label");
		lblStatus.setForeground(SystemColor.text);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBounds(22, 11, 383, 35);
		panel.add(lblStatus);
		
		JButton btnNewButton_9_1_3_1 = new JButton("Carta");
		btnNewButton_9_1_3_1.setToolTipText("Sorteio de uma carta");
		btnNewButton_9_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_9_1_3_1.setBounds(133, 282, 64, 64);
		contentPane.add(btnNewButton_9_1_3_1);
	}// fim do construtor
}
