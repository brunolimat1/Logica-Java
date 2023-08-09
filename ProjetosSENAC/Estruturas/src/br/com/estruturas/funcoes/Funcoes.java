package br.com.estruturas.funcoes;

public abstract class Funcoes {
	public static void mensagem() {
		System.out.println("Olá, Seja bem vindo!");
	}

	public static void mensagem(String nome) {
		System.out.println("Olá " + nome);
	}

	public static void idade(int anonasc, int anoatual) {
		System.out.println("Você tem " + (anoatual - anonasc) + " anos");
	}

	public static void soma(int[] valores) {
		int total = 0;
		for (int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
		System.out.println(total);
	}

	public static void maior(int[] valores) {
		int m = valores[0];
		for (int i = 1; i < valores.length; i++) {
			if (valores[i] > m) {
				m = valores[i];
			}
		}
		System.out.println(m);
	}

	public static void menor(int[] valores) {
		int m = valores[0];
		for (int i = 1; i > valores.length; i++) {
			if (valores[i] > m) {
				m = valores[i];
			}
		}
	}
}