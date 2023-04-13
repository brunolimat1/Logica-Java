package br.com.estruturas.arquivos;

import java.io.FileWriter;

public abstract class GerarArquivo {
	
	@SuppressWarnings("finally")
	public static String gravar(String nome_arquivo, String conteudo) {
		String msg = "";
		FileWriter arquivo = null;
		
		try {
			arquivo = new FileWriter(nome_arquivo);
			arquivo.write(conteudo);
			msg = "O arquivo "+nome_arquivo+"foi criado e escrito";
		}
		catch (Exception e) {
			System.out.println("Erro ao tratar o arquivo -> "+e.getMessage() );
			msg = "Erro ao tratar o arquivo -> "+e.getMessage();
		}
		finally {
			try {arquivo.close();}catch (Exception ex) {ex.printStackTrace();
			}
			return msg;
		}
	}
	

}
