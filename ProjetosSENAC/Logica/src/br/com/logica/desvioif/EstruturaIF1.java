package br.com.logica.desvioif;

import java.util.Scanner;

public class EstruturaIF1 {

	public static void main(String[] args) {
		
		int numero;
		Scanner input = new Scanner(System.in);	
		System.out.println("Digite um número: ");
		
		numero = input.nextInt();

		if( numero % 2 == 0) 
			System.out.println("O número digitado é Par");
		
		else
			System.out.println("O número digitado é Impar");
	}

}
