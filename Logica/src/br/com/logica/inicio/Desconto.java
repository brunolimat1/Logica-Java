package br.com.logica.inicio;

import java.util.Scanner;

public class Desconto {

	public static void main(String[] args) {
		
		double preco, taxa, valor, total;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o preço do produto: ");
		preco = entrada.nextDouble();
		
		System.out.println("Digite a taxa de desconto sem o simbolo de %: ");
		taxa = entrada.nextDouble();
		
		valor = preco * (taxa / 100);
		
		total = preco - valor;
		
		System.out.println("O valor de desconto é: "+valor);
		System.out.println("O valor final é: "+total);
		

	}

}