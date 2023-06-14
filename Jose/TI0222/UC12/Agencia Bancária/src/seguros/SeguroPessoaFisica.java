package seguros;

import contas.Conta;

public class SeguroPessoaFisica {

	public static void main(String[] args) {
		Conta cc3 = new Conta();
		cc3.cliente = "Robson Vaamonde";
		cc3.saldo = 30000;
		System.out.println("Cliente: " + cc3.cliente);
		cc3.exibirSaldo();
		System.out.println("-------------------------");

	}

}
