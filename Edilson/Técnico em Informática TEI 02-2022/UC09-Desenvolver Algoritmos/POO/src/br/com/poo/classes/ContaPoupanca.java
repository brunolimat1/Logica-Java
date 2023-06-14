package br.com.poo.classes;

import java.util.Date;

public class ContaPoupanca extends ContaBancaria{

	private Date aniversario;
	
	public String abrirConta(Long nB, Long nA, Long nC, String titular, Double saldo) {
		super.numeroBanco = nB;
		super.numeroAgencia = nA;
		super.numeroConta = nC;
		super.titular = titular;
		super.saldo = saldo;
		return "Conta aberta";
	}
	
	@Override
	public String sacar(Double valor) {
		String retorno = "";
		if(valor > super.saldo) {
			retorno = "Saldo insuficiente";
		}
		else {
			super.saldo -= valor;
			retorno = "Saque efetuado";
		}
		return retorno;
	}
}
