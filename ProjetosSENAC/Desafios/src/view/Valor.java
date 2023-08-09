package view;

import java.util.Scanner;

public class Valor {
	public static void main(String[] args) {
		double a, b, c;
		Scanner entrar = new Scanner(System.in);
		System.out.println("Digite um valor inteiro");
		a = entrar.nextInt();
		System.out.println("Digite um valor inteiro");
		b = entrar.nextInt();
		System.out.println("Digite um valor em casa Decimal");
		c = entrar.nextDouble();
		double s = a * 2 + b / 2;
		System.out.println(s);
		double s1 = 1 * 3 + c;
		System.out.println(s1);
		double s2 = ((c * 3) / 2 * (b * 2) / 0.25) / (a * a);
		System.out.println(s2);
	}
}
