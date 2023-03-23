package br.com.logica.introducao;

import java.util.Scanner;

public class EntradaTexto {

	public static void main(String[] args) {
		
		String nome;
		
		Scanner texto = new Scanner(System.in);
		
		 System.out.println("Digite o seu nome:");
		 
		 nome = texto.next();
		 
		 System.out.println("Olá " + nome);
		 
		 
		 

	}

}