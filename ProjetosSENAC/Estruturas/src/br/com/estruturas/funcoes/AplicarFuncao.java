package br.com.estruturas.funcoes;

public class AplicarFuncao {

	public static void main(String[] args) {
		int[] numeros = {10,35,6,12,58,4,15,200,124,24,10};
		
		System.out.println(FuncaoCRCA.soma(numeros));
		System.out.println(FuncaoCRCA.maior(numeros));
		for(int i = 0 ; i < FuncaoCRCA.ordenacaoInsercao(numeros).length ; i++) {
			System.out.println(FuncaoCRCA.ordenacaoInsercao(numeros)[i]);
		}
		
		
	}

}
