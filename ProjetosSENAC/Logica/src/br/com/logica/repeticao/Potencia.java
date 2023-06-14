package br.com.logica.repeticao;

import javax.swing.JOptionPane;

public class Potencia {

	public static void main(String[] args) {
		
		int vbase,vexp,rs=1;
		vbase = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
		vexp = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número"));
		rs = vbase;
		
		for(int i = 1; i < vexp ; i++) {
			rs *= vbase;
			
		}
		JOptionPane.showMessageDialog(null, "O resultado é: "+rs);
	}

}

