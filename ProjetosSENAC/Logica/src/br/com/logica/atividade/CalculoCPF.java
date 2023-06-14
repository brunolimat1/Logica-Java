package br.com.logica.atividade;

import javax.swing.JOptionPane;

public class CalculoCPF {
	public static void main(String[] args) {
		String cpfUsuario = "";
		String cpfCalc = "";
		int resto = 0;
		int resultado = 0;
		int peso = 0;
		cpfUsuario = JOptionPane.showInputDialog("Digite o seu CPF");

		/*
		 * Vamos pegar os 9 primeiros digitos do cpf do usuário. Para isso utilizaremos
		 * o comando chamado substring, que pede 2 parametros. Sendo: posição de início
		 * para pegar os valores e quantidade de elementos a que devem ser obtidos
		 **/

		cpfCalc = cpfUsuario.substring(0, 9);
		System.out.println(cpfCalc);
		for (int i = 0; i < cpfCalc.length(); i++) {

			resultado += peso * Integer.parseInt(cpfCalc.substring(i, i + 1));
			peso--;

		}
		resto = resultado % 11;
		if (resto < 2) {
			cpfCalc += "0";
		} else {
			cpfCalc += "" + (11 - resto);
		}

		if (cpfUsuario.equals(cpfCalc)) {
			JOptionPane.showMessageDialog(null, "Válido");
		} else {
			JOptionPane.showMessageDialog(null, "Inválido");
		}

	}

}
