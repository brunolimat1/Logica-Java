package br.com.logica.repeticao;

import javax.swing.JOptionPane;

public class While2 {

	public static void main(String[] args) {
		
		String texto = JOptionPane.showInputDialog("Digite sair para fechar");
		
		while(!texto.equals("sair")) {
			JOptionPane.showMessageDialog(null, "Lê direito cabaço!");
			
			texto = JOptionPane.showInputDialog("Digite sair para fechar");
		}
		
	}

}
