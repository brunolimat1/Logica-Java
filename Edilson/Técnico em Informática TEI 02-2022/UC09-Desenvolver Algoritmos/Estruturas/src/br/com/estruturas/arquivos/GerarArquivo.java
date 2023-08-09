package br.com.estruturas.arquivos;

import java.io.FileWriter;

/**
 * <b>GerarArquivo</b><br>
 * A classe GerarArquivo cria novos arquivos ou os abre. 
 * Insere dados no arquivo<br>
 * e possui um método chamado gravar.<br>
 * O método gravar pede 2 argumentos, onde:<br>
 * <ol>
 * <li> nome_arquivo: você deve passar o caminho com o nome do arquivo</li>
 * <li> conteudo: você deve passar o que será escrito no arquivo</li>
 * </ol>
 * @author Edilson Silva
 * @email edilson.js@yahoo.com.br
 */
public abstract class GerarArquivo {

	/**
	 * <b>gravar</b><br>
	 * O método gravar realiza a gravação ou a abertura do arquivo 
	 * passado como parametro e, adiciona o conteúdo ao arquivo.
	 * @param nome_arquivo
	 * 	 nome e/ou caminho do arquivo com extensão
	 * @param conteudo
	 * 	 texto que será inserido no arquivo.
	 * @return 
	 * 	mensagem de arquivo criado ou mensagem de erro
	 */
	public static String gravar(String nome_arquivo, String conteudo) {
		String msg = "";
		
		//Para criar um arquivo, iremos usar a classe FileWriter
		FileWriter arquivo = null;
		

		
		try {
			arquivo = new FileWriter(nome_arquivo);
			arquivo.write(conteudo);
			msg = "O arquivo "+nome_arquivo+" foi criado e escrito";
		}
		catch(Exception e) {
			System.out.println("Erro ao tratar o arquivo -> "+e.getMessage());
			msg = "Erro ao tratar o arquivo -> "+e.getMessage();
		}
		finally {
			try {
					arquivo.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		return msg;
	}
	
	
}
