package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eleitor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor dialog = new Eleitor();
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
	public Eleitor() {
		setTitle("Eleitor");
		setModal(true);
		setBounds(100, 100, 250, 211);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Idade");
		lblNewLabel.setBounds(26, 35, 46, 14);
		getContentPane().add(lblNewLabel);

		txtIdade = new JTextField();
		txtIdade.setBounds(70, 32, 55, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificar();
			}
		});
		btnNewButton.setBounds(70, 107, 89, 23);
		getContentPane().add(btnNewButton);

	}// fim do construtor

	void verificar() {
		// variáveis
		int idade;
		// entrada
		idade = Integer.parseInt(txtIdade.getText());
		// processamento + saída
		if (idade < 16) {
			JOptionPane.showMessageDialog(null, "Proibido votar");
		} else if (idade > 17 && idade < 71) {
			JOptionPane.showMessageDialog(null, "Obrigatório votar");
		} else {
			JOptionPane.showMessageDialog(null, "Voto facultativo");
		}
	}

}// fim do código
