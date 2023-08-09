package portfolio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
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
	public IMC() {
		setModal(true);
		setTitle("IMC");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(46, 42, 46, 14);
		getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(97, 39, 272, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(46, 178, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(46, 83, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtIdade = new JTextField();
		txtIdade.setBounds(97, 77, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(46, 126, 46, 14);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(97, 123, 86, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(283, 123, 86, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Altura");
		lblNewLabel_2.setBounds(227, 126, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		

	}// fim do construtor

	// Método responsável pelo cálculo do IMC
	void calcular() {
		// Validação
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome");
			txtNome.requestFocus();
		} else if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a idade");
			txtIdade.requestFocus();
		} else if (txtPeso.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o peso");
			txtPeso.requestFocus();
		} else if (txtAltura.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a altura");
			txtAltura.requestFocus();
		} else {
			// Variáveis
			String nome;
			int idade;
			double peso, altura, imc;

			// Entrada
			// Armazenando o conteúdo da caixa de texto na variável
			nome = txtNome.getText();
			// Integer.parseInt (converter o conteúdo da caixa de texto para número inteiro)
			idade = Integer.parseInt(txtIdade.getText());
			// Double.parseDouble (converter o conteúdo da caixa de texto para números
			// inteiros e não inteiro)
			peso = Double.parseDouble(txtPeso.getText());
			altura = Double.parseDouble(txtAltura.getText());

			// Processamento
			imc = peso / (altura * altura);

			// Saída
			// A linha abaixo exibe o nome armazenado na variável em uma caixa de mensagem.
			// Para personalizar a caixa de mensagem devemos adicionar um texto para o
			// título e um ícone personalizado

			JOptionPane.showMessageDialog(null,
					"Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura + "\nIMC: " + imc,
					"Ficha do aluno", JOptionPane.DEFAULT_OPTION);
		}
	}
}
