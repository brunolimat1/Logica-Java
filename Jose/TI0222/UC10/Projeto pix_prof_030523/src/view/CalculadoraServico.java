package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculadoraServico extends JFrame {

	// variáveis
	double remuneracao, custo, valor, total;
	int cargaHoraria, estimativa;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtEstimativa;
	private JLabel lblValor;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraServico frame = new CalculadoraServico();
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
	public CalculadoraServico() {
		setTitle("Calculadora de serviços de TI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Remuneração mensal pretendida");
		lblNewLabel.setBounds(23, 43, 202, 24);
		contentPane.add(lblNewLabel);

		txtRemuneracao = new JTextField();
		txtRemuneracao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// digitação...
				// definir caracteres permitidos
				String caracteres = "0123456789.";
				// se for digitado algum caractere não permitido
				if (!caracteres.contains(e.getKeyChar() + "")) {
					// ignorar
					e.consume();
				}
			}
		});
		txtRemuneracao.setBounds(220, 45, 120, 20);
		contentPane.add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Custo operacional mensal");
		lblNewLabel_1.setBounds(23, 100, 159, 14);
		contentPane.add(lblNewLabel_1);

		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// digitação...
				// definir caracteres permitidos
				String caracteres = "0123456789.";
				// se for digitado algum caractere não permitido
				if (!caracteres.contains(e.getKeyChar() + "")) {
					// ignorar
					e.consume();
				}
			}
		});
		txtCusto.setBounds(220, 97, 120, 20);
		contentPane.add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Carga horária mensal de trabalho");
		lblNewLabel_2.setBounds(23, 159, 202, 14);
		contentPane.add(lblNewLabel_2);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// digitação...
				// definir caracteres permitidos
				String caracteres = "0123456789";
				// se for digitado algum caractere não permitido
				if (!caracteres.contains(e.getKeyChar() + "")) {
					// ignorar
					e.consume();
				}
			}
		});
		txtCargaHoraria.setBounds(254, 156, 86, 20);
		contentPane.add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(23, 227, 89, 23);
		contentPane.add(btnCalcular);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(148, 227, 89, 23);
		contentPane.add(btnLimpar);

		JLabel lblNewLabel_3 = new JLabel("Valor da hora:");
		lblNewLabel_3.setBounds(23, 297, 120, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("Estimativa de horas do serviço:");
		lblNewLabel_2_1.setBounds(23, 354, 182, 14);
		contentPane.add(lblNewLabel_2_1);

		txtEstimativa = new JTextField();
		txtEstimativa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// digitação...
				// definir caracteres permitidos
				String caracteres = "0123456789";
				// se for digitado algum caractere não permitido
				if (!caracteres.contains(e.getKeyChar() + "")) {
					// ignorar
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txtEstimativa.setBounds(203, 351, 86, 20);
		contentPane.add(txtEstimativa);
		txtEstimativa.setColumns(10);

		JLabel lblNewLabel_2_2 = new JLabel("Total a ser cobrado do cliente:");
		lblNewLabel_2_2.setBounds(23, 413, 182, 14);
		contentPane.add(lblNewLabel_2_2);

		lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(120, 290, 89, 24);
		contentPane.add(lblValor);

		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(203, 406, 86, 24);
		contentPane.add(lblTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		btnTotal.setBounds(299, 350, 89, 23);
		contentPane.add(btnTotal);
	}// fim do construtor

	private void calcular() {
		// teste do botão calcular
		// System.out.println("teste");
		// validação de campos obrigatórios
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a remuneração mensal pretendida");
			txtRemuneracao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o custo operacional mensal");
			txtCusto.requestFocus();
		} else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a carga horária mensal de trabalho");
			txtCargaHoraria.requestFocus();
		} else {
			// lógica principal
			// entrada
			remuneracao = Double.parseDouble(txtRemuneracao.getText());
			custo = Double.parseDouble(txtCusto.getText());
			cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
			// processamento
			valor = (remuneracao + (0.3 * remuneracao) + (0.2 * remuneracao) + custo) / cargaHoraria;
			// saída
			// formatação do resultado (número de casas decimais)
			// ("#0.00") 2 casas decimais
			DecimalFormat formatador = new DecimalFormat("#0.00");
			lblValor.setText("R$ " + formatador.format(valor));
		}
	}
	
	/**
	 * Método responsável pelo cálculo do valor total do serviço
	 */
	private void calcularTotal() {
		//validação de campos obrigatórios
		if (txtEstimativa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a estimativa de horas");
			txtEstimativa.requestFocus();
		} else {
		//entrada
		estimativa = Integer.parseInt(txtEstimativa.getText());
		//processamento
		total = estimativa * valor;
		//saída
		DecimalFormat formatador = new DecimalFormat("#0.00");
		lblTotal.setText("R$ " + formatador.format(total));
		}
	}
}// fim do código
