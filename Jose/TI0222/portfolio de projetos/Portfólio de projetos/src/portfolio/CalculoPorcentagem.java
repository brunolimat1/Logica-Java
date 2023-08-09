package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class CalculoPorcentagem extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtValor;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTextField txtVenda;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtSub;
	private JLabel lblNewLabel_8;
	private JTextField txtDesconto;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton_2;
	private JTextField txtTotal;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoPorcentagem dialog = new CalculoPorcentagem();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CalculoPorcentagem() {
		setModal(true);
		setTitle("C\u00E1lculo da Porcentagem");
		setBounds(100, 100, 543, 357);
		getContentPane().setLayout(null);

		txtX = new JTextField();
		txtX.setBounds(23, 48, 51, 20);
		getContentPane().add(txtX);
		txtX.setColumns(10);

		JLabel lblNewLabel = new JLabel("% de");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(84, 48, 54, 17);
		getContentPane().add(lblNewLabel);

		txtY = new JTextField();
		txtY.setBounds(134, 48, 77, 20);
		getContentPane().add(txtY);
		txtY.setColumns(10);

		JButton btnNewButton = new JButton(" = ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(232, 47, 57, 23);
		getContentPane().add(btnNewButton);

		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(309, 48, 135, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Regra de 3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(23, 16, 109, 20);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Custo x Venda");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(23, 109, 109, 14);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Custo");
		lblNewLabel_3.setBounds(10, 145, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtCusto = new JTextField();
		txtCusto.setBounds(59, 142, 77, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Lucro");
		lblNewLabel_4.setBounds(159, 145, 37, 14);
		getContentPane().add(lblNewLabel_4);

		txtLucro = new JTextField();
		txtLucro.setBounds(206, 142, 51, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(267, 139, 26, 23);
		getContentPane().add(lblNewLabel_5);

		JButton btnNewButton_1 = new JButton("Venda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularVenda();
			}
		});
		btnNewButton_1.setBounds(303, 141, 77, 23);
		getContentPane().add(btnNewButton_1);

		txtVenda = new JTextField();
		txtVenda.setEditable(false);
		txtVenda.setBounds(399, 142, 103, 20);
		getContentPane().add(txtVenda);
		txtVenda.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Calcular desconto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(23, 209, 113, 14);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Sub total");
		lblNewLabel_7.setBounds(38, 246, 77, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtSub = new JTextField();
		txtSub.setColumns(10);
		txtSub.setBounds(23, 271, 92, 20);
		getContentPane().add(txtSub);
		
		lblNewLabel_8 = new JLabel("Desconto");
		lblNewLabel_8.setBounds(162, 246, 77, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(159, 271, 62, 20);
		getContentPane().add(txtDesconto);
		
		lblNewLabel_9 = new JLabel("%");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(231, 268, 26, 23);
		getContentPane().add(lblNewLabel_9);
		
		btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularDesconto();
			}
		});
		btnNewButton_2.setBounds(278, 256, 77, 23);
		getContentPane().add(btnNewButton_2);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(372, 257, 119, 20);
		getContentPane().add(txtTotal);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 93, 507, 4);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 190, 507, 4);
		getContentPane().add(panel_1);

	}// fim do construtor

	// Método Regra de 3
	void calcular() {
		// variáveis
		double x, y, valor;
		// entrada
		x = Double.parseDouble(txtX.getText());
		y = Double.parseDouble(txtY.getText());
		// processamento
		valor = (x * y) / 100;
		// saída
		txtValor.setText(String.valueOf(valor));
	}

	// Método Venda
	void calcularVenda() {
		// variáveis
		double custo, lucro, venda;
		// entrada
		custo = Double.parseDouble(txtCusto.getText());
		lucro = Double.parseDouble(txtLucro.getText());
		// processamento
		venda = custo + ((lucro * custo) / 100);
		// saída
		txtVenda.setText(String.valueOf(venda));	
	}
	
	// Método Desconto
	void calcularDesconto() {
		// variáveis
		double total, desconto, totaldesc;
		// entrada
		total = Double.parseDouble(txtSub.getText());
		desconto = Double.parseDouble(txtDesconto.getText());
		// processamento
		totaldesc = total - (total * desconto) / 100;
		// saída
		txtTotal.setText(String.valueOf(totaldesc));
	}
	
}// fim
