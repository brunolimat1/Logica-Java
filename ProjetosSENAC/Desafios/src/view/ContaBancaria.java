package view;

import javax.swing.JOptionPane;

public class ContaBancaria {
	public static void main(String[] args) {
		// TODO Auto-generated method stub } }
		int op = 0;
		double saldo = 0.0;
		double valor = 0.0;

		op = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n1-Depositar\n2-Saque\n3-Sair"));
		while (op != 3) {

			if (op == 1) {
				valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor"));
				saldo += valor;
			} else {
				valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor"));
				if (valor <= saldo) {
					saldo -= valor;
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente");
				}
			}
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n1-Depositar\n2-Saque\n3-Sair"));				
		}
	}
}