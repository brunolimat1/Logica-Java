package portfolio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Combustivel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEtanol;
	private JTextField txtGasolina;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combustivel dialog = new Combustivel();
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
	public Combustivel() {
		setTitle("Etanol x Gasolina");
		setModal(true);
		setBounds(100, 100, 336, 347);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Etanol");
		lblNewLabel.setBounds(10, 28, 46, 14);
		getContentPane().add(lblNewLabel);

		txtEtanol = new JTextField();
		txtEtanol.setBounds(54, 25, 71, 20);
		getContentPane().add(txtEtanol);
		txtEtanol.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Gasolina");
		lblNewLabel_1.setBounds(163, 28, 61, 14);
		getContentPane().add(lblNewLabel_1);

		txtGasolina = new JTextField();
		txtGasolina.setBounds(223, 25, 71, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(81, 85, 153, 23);
		getContentPane().add(btnNewButton);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
		lblStatus.setBounds(0, 142, 320, 160);
		getContentPane().add(lblStatus);

	}// fim do construtor

	void calcular() {
		if (txtEtanol.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor do Etanol");
			txtEtanol.requestFocus();
		} else if (txtGasolina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor da gasolina");
			txtGasolina.requestFocus();
		} else {
			// variaveis
			double etanol, gasolina;
			// entrada
			etanol = Double.parseDouble(txtEtanol.getText());
			gasolina = Double.parseDouble(txtGasolina.getText());
			// processamento + saída
			if (etanol < 0.7 * gasolina) {
				// JOptionPane.showMessageDialog(null, "Abastecer com Etanol");
				lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/etanol.png")));

			} else {
				// JOptionPane.showMessageDialog(null, "Abastecer com Gasolina");
				lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/gasolina.png")));
			}
		}

	}
}
// fim do código
