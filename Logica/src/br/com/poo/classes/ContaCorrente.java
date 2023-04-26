package br.com.poo.classes;

public class ContaCorrente extends ContaBancaria {
	private double limite;
	private double limiteInicial;

	public ContaCorrente() {}

	public ContaCorrente(double limite) {
		this.limite = limite;
		limiteInicial = limite;
	}
	
	
	public ContaCorrente(Long numeroBanco, int agencia, Long numeConta, String titular, double saldo,double limite) {
		super.setNumeroBanco(numeroBanco);
		super.setAgencia(agencia);
		super.setNumeroConta(numeConta);
		super.setTitular(titular);
		super.setSaldo(saldo);
		this.limite = limite;
		limiteInicial = limite;
	}
	
	@Override
	public String sacar(double valor) {
		String msg = "";
		
		if(limite+super.getSaldo() < valor) {
			msg = "Saldo insuficiente";
		}
		else if(super.getSaldo() < valor) {
			
			this.limite = this.limite - (valor - super.getSaldo());
			super.setSaldo(0);
			msg = "Saque realizado.\n Seu limite atual é "+
			this.limite+"\nSeu saldo é 0";
		}
		else {
			super.setSaldo(super.getSaldo()-valor);
			msg = "Saque realizado.\nSeu novo saldo é: "+super.getSaldo();
		}
		return msg;
	}
	
	@Override
	public String depositar(double valor) {
		
		String msg = "";
		if(limiteInicial != limite) {
			
			super.setSaldo(valor - (limiteInicial - limite));
			limite += limiteInicial - limite;
			msg = "Depósito realizado.\nSeu saldo é: "
			+super.getSaldo()+"\n e seu limite atual é "+
					limite;
		}
		else {
			super.setSaldo(super.getSaldo()+valor);
			msg = "Depósito realizado.\nSeu saldo é: "+super.getSaldo();
		}
		return msg;
		
	}
	
	
	
}
