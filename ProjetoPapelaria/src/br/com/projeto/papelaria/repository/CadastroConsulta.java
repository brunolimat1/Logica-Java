package br.com.projeto.papelaria.repository;

import java.util.List;

public interface CadastroConsulta<T> {
	
	public String cadastro(T obj);
	public List<T> consulta();
	public List<T> consulta(T obj);
	
	
}
