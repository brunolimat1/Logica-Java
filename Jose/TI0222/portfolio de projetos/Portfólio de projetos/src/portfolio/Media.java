package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Media extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtDisciplina;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Media dialog = new Media();
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
	public Media() {
		setTitle("C\u00E1lculo da M\u00E9dia");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(310, 214, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Aluno");
		lblNewLabel.setBounds(22, 23, 46, 14);
		getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(88, 20, 293, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(22, 54, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtIdade = new JTextField();
		txtIdade.setBounds(88, 51, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Disciplina");
		lblNewLabel_2.setBounds(22, 86, 56, 14);
		getContentPane().add(lblNewLabel_2);

		txtDisciplina = new JTextField();
		txtDisciplina.setBounds(88, 82, 173, 20);
		getContentPane().add(txtDisciplina);
		txtDisciplina.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("1\u00BA Bim");
		lblNewLabel_3.setBounds(22, 135, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtNota1 = new JTextField();
		txtNota1.setBounds(88, 132, 86, 20);
		getContentPane().add(txtNota1);
		txtNota1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("2\u00BA Bim");
		lblNewLabel_4.setBounds(22, 161, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtNota2 = new JTextField();
		txtNota2.setBounds(88, 158, 86, 20);
		getContentPane().add(txtNota2);
		txtNota2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("3\u00BA Bim");
		lblNewLabel_5.setBounds(22, 192, 46, 14);
		getContentPane().add(lblNewLabel_5);

		txtNota3 = new JTextField();
		txtNota3.setBounds(88, 189, 86, 20);
		getContentPane().add(txtNota3);
		txtNota3.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("4\u00BA Bim");
		lblNewLabel_6.setBounds(22, 218, 46, 14);
		getContentPane().add(lblNewLabel_6);

		txtNota4 = new JTextField();
		txtNota4.setBounds(88, 215, 86, 20);
		getContentPane().add(txtNota4);
		txtNota4.setColumns(10);

	}// fim do construtor

	void calcular() {
		// variáveis
		String nome, disciplina;
		int idade;
		double nota1, nota2, nota3, nota4, media;
		// entrada
		nome = txtNome.getText();
		disciplina = txtDisciplina.getText();
		idade = Integer.parseInt(txtIdade.getText());
		nota1 = Double.parseDouble(txtNota1.getText());
		nota2 = Double.parseDouble(txtNota2.getText());
		nota3 = Double.parseDouble(txtNota3.getText());
		nota4 = Double.parseDouble(txtNota4.getText());
		// processamento
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		// saída
		if (media < 5) {
			JOptionPane.showMessageDialog(null,"Aluno: " + nome + "\nIdade: " + idade + "\nDisciplina: " + disciplina + "\nMédia final: " + media + "\nStatus: REPROVADO","Boletim escolar", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,"Aluno: " + nome + "\nIdade: " + idade + "\nDisciplina: " + disciplina + "\nMédia final: " + media + "\nStatus: APROVADO","Boletim escolar", JOptionPane.DEFAULT_OPTION);
		}

	}
}
