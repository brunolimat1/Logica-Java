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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CalculadoraServico extends JFrame {
	Locale localeBR = new Locale("pt", "BR");
	double remuneracao, custo, valor, total;
	int estimativa, cargaHoraria;
	NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtEstimativa;
	private JLabel lblValor;
	private JLabel lblTotal;

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

	public CalculadoraServico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraServico.class.getResource("/img/3045419_accounting_budget_calc_calculator_math_icon.png")));
		setTitle("Calculadora de Serviços de TI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 520);
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
		JButton btnCalcular = new JButton("");
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setBorder(null);
		btnCalcular.setBorderPainted(false);
		btnCalcular.setIcon(new ImageIcon(
				CalculadoraServico.class.getResource("/img/3045419_accounting_budget_calc_calculator_math_icon.png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(48, 196, 64, 64);
		contentPane.add(btnCalcular);
		getRootPane().setDefaultButton(btnCalcular);
		JButton btnLimpar = new JButton("");
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBorder(null);
		btnLimpar.setIcon(
				new ImageIcon(CalculadoraServico.class.getResource("/img/8675036_ic_fluent_eraser_regular_icon.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(145, 196, 64, 64);
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
		JButton btnCalcular2 = new JButton("");
		btnCalcular2.setContentAreaFilled(false);
		btnCalcular2.setBorder(null);
		btnCalcular2.setBorderPainted(false);
		btnCalcular2.setIcon(new ImageIcon(
				CalculadoraServico.class.getResource("/img/3045419_accounting_budget_calc_calculator_math_icon.png")));
		btnCalcular2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularTotal();
			}
		});
		btnCalcular2.setBounds(345, 305, 64, 64);
		contentPane.add(btnCalcular2);
	}

	private void limparCampos() {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtEstimativa.setText(null);
		lblValor.setText(null);
		lblTotal.setText(null);
	}

	private void calcular() {
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Remuneração Mensal Pretendida!");
			txtRemuneracao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Custo Operacional Mensal!");
			txtCusto.requestFocus();
		} else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Carga Horaria Mensal!");
			txtCargaHoraria.requestFocus();
		} else {
			remuneracao = Double.parseDouble(txtRemuneracao.getText());
			custo = Double.parseDouble(txtCusto.getText());
			cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
			valor = (remuneracao + (0.3 * remuneracao) + (0.2 * remuneracao) + custo) / cargaHoraria;
			lblValor.setText(dinheiro.format(valor));
		}
	}

	private void calcularTotal() {
		if (txtEstimativa.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Estimativa de Horas do Serviço!");
			txtEstimativa.requestFocus();
		} else {
			estimativa = Integer.parseInt(txtEstimativa.getText());
			total = (valor * estimativa);
			lblTotal.setText(dinheiro.format(total));
		}
	}
}