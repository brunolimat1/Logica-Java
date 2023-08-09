package br.com.projeto.papelaria.repository;

public interface AtualizarApagar<T> extends CadastroConsulta<T> {
	public String atualizar( T obj);
	public String apagar( T obj);
	
}