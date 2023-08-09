package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversaoTemperatura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtF;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversaoTemperatura dialog = new ConversaoTemperatura();
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
	public ConversaoTemperatura() {
		setTitle("Convers\u00E3o de temperatura");
		setModal(true);
		setBounds(100, 100, 401, 205);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fahrenheit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 37, 88, 14);
		getContentPane().add(lblNewLabel);
		
		txtF = new JTextField();
		txtF.setBounds(124, 36, 86, 20);
		getContentPane().add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 102, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setBounds(124, 101, 221, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter();
			}
		});
		btnNewButton.setBounds(241, 35, 104, 23);
		getContentPane().add(btnNewButton);

	} //fim do construtor
	
	void converter() {
		//variáveis
		double c,f;
		//entrada
		f = Double.parseDouble(txtF.getText());
		//processamento
		c = (5 * (f - 32)) / 9;
		//saída
		// a linha abaixo exibe o conteúdo da variável c na caixa de texto (é necessário converter para String)
		txtC.setText(String.valueOf(c));
	}
}
