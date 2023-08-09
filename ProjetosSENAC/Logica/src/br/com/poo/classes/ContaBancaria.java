package br.com.poo.classes;

public abstract class ContaBancaria {
	protected Long numeroBanco;
	protected Long numeroAgencia;
	protected Long numeroConta;
	protected String titular;
	protected Double saldo;
	
	public double verificarSaldo() {
		return saldo;
	}
	public String depositar(Double valor) {
		saldo += valor;
		return "Depósito efetuado";
	}
	public String sacar(Double valor) {
		saldo -= valor;
		return "Saque efetuado";
	}
}
