package br.com.logica.inicio;

import java.text.DecimalFormat;

import java.util.Scanner;

public class salario {

	public static void main(String[] args) {

		double sal, med, tra, total, liq;
	    med = 7;
		tra = 6.22;
		
		Scanner desconto = new Scanner(System.in);
		
		System.out.println("Qual é o seu salário? ");
		sal = desconto.nextDouble();
		
		total = sal/100 * (med + tra);
		liq = sal - total;
		
		System.out.println( new DecimalFormat("Valor total de descontos: #,##0.00").format(total));
		System.out.println("Valor do salário líquido: "+liq);
	
		
	}

}
