package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class CalculadoraServico extends JFrame {
	Locale localeBR = new Locale("pt","BR");

	// variáveis
	double remuneracao, custo, valor, total;
	int Estimativa, cargaHoraria;
	
	NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

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
	 * 
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

		setTitle("Calculadora de Serviços de TI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Remuneração Mensal Pretendida:");
		lblNewLabel.setBounds(10, 47, 203, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCustoOperacionalMensal = new JLabel("Custo Operacional Mensal:");
		lblCustoOperacionalMensal.setBounds(10, 94, 176, 14);
		contentPane.add(lblCustoOperacionalMensal);

		JLabel lblCargaHorriaMensal = new JLabel("Carga Horária Mensal de Trabalho:");
		lblCargaHorriaMensal.setBounds(10, 144, 218, 14);
		contentPane.add(lblCargaHorriaMensal);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(10, 207, 89, 23);
		contentPane.add(btnCalcular);
		getRootPane().setDefaultButton(btnCalcular);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		btnLimpar.setBounds(139, 207, 89, 23);
		contentPane.add(btnLimpar);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(208, 44, 140, 20);
		contentPane.add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(208, 91, 140, 20);
		contentPane.add(txtCusto);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(208, 141, 140, 20);
		contentPane.add(txtCargaHoraria);

		JLabel lblNewLabel_1 = new JLabel("Valor da Hora:");
		lblNewLabel_1.setBounds(10, 282, 102, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Estimativa de Horas do Serviço:");
		lblNewLabel_1_1.setBounds(10, 331, 203, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Total a ser Cobrado pelo Cliente:");
		lblNewLabel_1_1_1.setBounds(10, 378, 203, 14);
		contentPane.add(lblNewLabel_1_1_1);

		txtEstimativa = new JTextField();
		txtEstimativa.setBounds(195, 328, 140, 20);
		contentPane.add(txtEstimativa);
		txtEstimativa.setColumns(10);

		lblValor = new JLabel("R$ 0");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(94, 282, 88, 14);
		contentPane.add(lblValor);

		lblTotal = new JLabel("R$ 0");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(197, 378, 86, 14);
		contentPane.add(lblTotal);
	}// FIM DO CONSTRUTOR
	
	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtEstimativa.setText(null);
		lblValor.setText(null);
		lblTotal.setText(null);
		
	}// fim do método limpar campos

	private void calcular() {
		// teste do botão calcular
		// System.out.println("teste");
		// validação de campos obrigatórios
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Remuneração Mensal Pretendida!");
			txtRemuneracao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Custo Operacional Mensal!");
			txtCusto.requestFocus();
		} else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Carga Horaria Mensal!");
			txtCargaHoraria.requestFocus();
		} else if (txtEstimativa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Estimativa de Horas do Serviço!");
			txtEstimativa.requestFocus();
		} else {
			//lógica principal
			// entrada
			remuneracao = Double.parseDouble(txtRemuneracao.getText());
			custo = Double.parseDouble(txtCusto.getText());
			cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
			Estimativa = Integer.parseInt(txtEstimativa.getText());
			// processamento
			valor = (remuneracao + (0.3 * remuneracao) + (0.2 * remuneracao) + custo) / cargaHoraria;
			total = (valor * Estimativa);
			// saída
			lblValor.setText(dinheiro.format(valor));
			lblTotal.setText(dinheiro.format(total));
		}
	}
}// FIM DO CÓDIGO
