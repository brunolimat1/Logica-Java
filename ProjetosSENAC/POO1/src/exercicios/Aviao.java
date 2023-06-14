package exercicios;

import java.util.Random;

public class Aviao extends Carro {

	double envergadura;

	public static void main(String[] args) {
		System.out.println("AVIÃO");
		Carro avião = new Carro();
		avião.ano = 1980;
		avião.cor = "Branco";
		avião.envergadura = 79;
		System.out.println("Ano: " + avião.ano);
		System.out.println("Cor: " + avião.cor);
		System.out.println("Envergadura: " + avião.envergadura);
		avião.ligar();
		avião.desligar();
		avião.acelerar();
		avião.aterrissar();
		String chassi = new String("123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Random gerador = new Random();
		System.out.print("Chassi: * ");
		for (int i = 1; i < 16; i++) {
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
			
		}
		
		System.out.println(" * ");

	}
	
	//polimorfismo
	public void acelerar() {
		System.out.println("Vruuummmmm...");
	}
	
}
