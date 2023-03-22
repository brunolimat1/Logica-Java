package br.com.logica.inicio;

import java.util.Scanner;

public class Operacoes {

	public static void main(String[] args) {
		
		//Vamos declarar 2 variáveis para realizar cálculos:
		int n1;
		int n2;
		int soma, multiplicar, subtrair, dividir;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		n1 = input.nextInt();
		
		System.out.println("Digite outro número: ");
		n2 = input.nextInt();
		
		soma = n1 + n2;
		multiplicar = n1 * n2;
		subtrair = n1 - n2;
		dividir = n1 / n2;
		
		System.out.println("O resultado da soma é: " + soma);
		System.out.println("O resultado da multiplicação é: " + multiplicar);
		System.out.println("O resultado da subtração é: " + subtrair);
		System.out.println("O resultado da divisão é: " + dividir);
		
		
	}

}