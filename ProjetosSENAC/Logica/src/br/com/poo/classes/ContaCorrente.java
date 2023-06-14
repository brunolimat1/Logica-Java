package br.com.poo.classes;

public class ContaCorrente extends ContaBancaria{
	
	private double limite;
	private double limiteInicial;
	
	public String abrirConta(Long nB, Long nA, Long nC,String t,double s, double l) {
		super.numeroBanco = nB;
		super.numeroAgencia = nA;
		super.numeroConta = nC;
		super.titular = t;
		super.saldo = s;
		this.limite = l;
		this.limiteInicial = l;
		return "Conta aberta";
		
	}
	
	@Override
	public String depositar(Double valor) {
		String msg = "";
		
		if(limiteInicial==limite) {
			super.saldo += valor;
			msg = "Seu depósito foi efetuado no saldo";
		}
		else {
			double sd = limiteInicial - limite;
			if(valor > sd) {
				limite = limiteInicial;
				super.saldo+= valor-sd;
				msg = "O depósito cobriu o limite e o restante foi para o saldo";
			}
			else {
				limite+=valor;
				msg = "O depósito foi direto para o limite da conta";
			}
		}
		
		return msg;
	}
	
	@Override
	public String sacar(Double valor) {
		String msg = "";
		
		if(valor > limite+super.saldo) {
			msg = "Saldo insuficiente";
		}
		else if(valor > super.saldo) {
			double sd = valor - super.saldo;
			super.saldo = 0.0;
			limite -= sd;
			msg = "Seu saldo é 0 e seu limite é "+limite+" você está "+sd+" negativo";
		}
		else {
			super.saldo -= valor;
			msg="Seu saldo é "+super.saldo+" e seu limite é "+limite;
		}
	return msg;
	}
	
}






