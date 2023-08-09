package exercicios;

import java.util.Random;

public class Carro {
	int ano;
	String cor;
	double envergadura;

	public static void main(String[] args) {
		System.out.println("FERRARI");
		Carro ferrari = new Carro();
		ferrari.ano = 2008;
		ferrari.cor = "Vermelho";
		System.out.println("Ano: " + ferrari.ano);
		System.out.println("Cor: " + ferrari.cor);
		ferrari.ligar();
		ferrari.desligar();
		ferrari.acelerar();
		String chassi = new String("123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Random gerador = new Random();
		System.out.print("Chassi: * ");
		for (int i = 1; i < 16; i++) {
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" * ");

		System.out.println();

		System.out.println("FUSCA");
		Carro fusca = new Carro();
		fusca.ano = 1989;
		fusca.cor = "Azul";
		System.out.println("Ano: " + fusca.ano);
		System.out.println("Cor: " + fusca.cor);
		fusca.ligar();
		fusca.desligar();
		fusca.acelerar();
		System.out.print("Chassi: * ");
		for (int i = 1; i < 16; i++) {
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" * ");

	}

	void ligar() {
		System.out.println("Ligado");
	}

	void desligar() {
		System.out.println("Desligado");
	}

	void acelerar() {
		System.out.println("Velocidade Máxima");
	}

	void aterrissar() {
		System.out.println("Pousando...");
		
	}

}
