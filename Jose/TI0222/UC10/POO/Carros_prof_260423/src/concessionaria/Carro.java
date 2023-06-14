package concessionaria;

import java.util.Random;

public class Carro {
	// atributos
	int ano;
	String cor;

	// construtor
	public Carro() {
		System.out.println("______________________________________");
		// alinha abaixo cria um objeto de nome chassi
		// chassi também é uma variável que recbe os caracteres dentro de ()
		String chassi = new String("123456789ABCDEFGHIJKLMNOPQRSTUVXYZ");
		// a linha abaixo cria um objeto de nome gerador
		// random é usado para gerar números aleatórios
		Random gerador = new Random();
		System.out.print("Chassi: * ");
		// o laço abaixo imprime aleatóriamente 16 números da String
		for (int i = 1; i < 16; i++) {
			//gerar aleatóriamente um caractere da String a cada loop
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" *");
	}

	// métodos
	void ligar() {
		System.out.println("Motor ligado....");
	}

	void desligar() {
		System.out.println("Motor desligado.");
	}

	void acelerar() {
		System.out.println("Vrummmmmmm..............");
	}
}
