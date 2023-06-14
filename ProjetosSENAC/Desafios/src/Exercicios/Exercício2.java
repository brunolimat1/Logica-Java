package Exercicios;

public class Exercício2 {
	public static void main(String[] args) {
		int[] valores = { 15, 35, 16, 82, 10, 26, 31, 47, 11, 19, 5, 13, 33, 51, 201, 200, 56 };
		System.out.println("============== Valores entre as posições 1 e 9 ==============");
		for (int i = 2; i <= 8; i++) {
			System.out.println(valores[i]);
		}
		System.out.println("============== Valores entre as posições 8 e 13 ==============");
		for (int i = 9; i <= 12; i++) {
			System.out.println(valores[i]);
		}
		System.out.println("============== Valores impares ==============");
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 2 == 0)
				System.out.println(valores[i]);
		}
		System.out.println("============== Valores Multiplos de 3 ==============");
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 3 == 0)
				System.out.println(valores[i]);
		}
		System.out.println("============== Valores Multiplos de 4 ==============");
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 4 == 0)
				System.out.println(valores[i]);
		}
		System.out.println("============== Valores Multiplos de 5 ==============");
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 5 == 0)
				System.out.println(valores[i]);
		}
		System.out.println("============== Valores Array Reverso ==============");
		for (int i = valores.length - 1; i >= 0; i--) {
			System.out.println(valores[i]);
		}
	}
}