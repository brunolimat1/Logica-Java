package br.com.logica.array;

public class Array4 {
	public static void main(String[] args) {
		int[] anos = new int[30];
		int contador = 0;
		// adicionar anos bissextos no array anos
		for (int i = 1990; contador < 9; i++) {
			if ((i % 4 == 0 && i % 100 != 0 || i % 400 == 0)) {
				anos[contador] = i;
				contador++;
			}
		}
		System.out.println("Anos bissextos adicionados ao array: ");
		for (int i = 0; i < anos.length; i++) {
			if (anos[i] != 0) {
				System.out.println(anos[i] + " ");

			}
		}
	}
}
