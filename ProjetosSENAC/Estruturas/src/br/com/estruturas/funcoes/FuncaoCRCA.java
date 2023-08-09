package br.com.estruturas.funcoes;

public abstract class FuncaoCRCA {

	public static int soma(int[] valores) {
		int resultado = 0;
		for (int i = 0; i < valores.length; i++) {
			resultado += valores[i];
		}
		return resultado;
	}

	public static int maior(int[]valores) {
		int m = valores[0];
		for(int i = 0; i < valores.length;i++) {
				
		}
		return m;
	}

	public static int[] ordenacaoInsercao(int[] valores) {

		for (int i = 1; i < valores.length; i++) {
			int x = valores[i];
			int j = 0;
			for (j = i - 1; j >= 0 && valores[j] > x; j++) {
				valores[j + 1] = valores[j];
			}
			valores[j + 1] = x;
		}
		return valores;
	}
}
