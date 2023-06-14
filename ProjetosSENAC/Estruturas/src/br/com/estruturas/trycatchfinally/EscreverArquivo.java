package br.com.estruturas.trycatchfinally;

import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {
	public static void main(String[] args) {
		FileWriter arquivo = null;
		try {
			arquivo = new FileWriter("arquivo.txt");
			arquivo.write("Primeiro texto");
			arquivo.write("/r/n");
			arquivo.write("Nova mensagem");
			System.out.println("Arquivo criado");
		} catch (IOException arq) {
			System.out.println("Erro ao escrever " + arq.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado " + e.getMessage());
		} finally {
			try {
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}