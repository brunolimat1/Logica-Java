package br.com.projeto.papelaria.repository;

import br.com.projeto.papelaria.dominio.Contato;

import java.util.List;

import br.com.projeto.papelaria.dominio.Cliente;
import br.com.projeto.papelaria.dominio.Usuario;

public interface CadastroConsulta<T> {
	
	public String cadastro(T obj);
	public List<Usuario> consulta();
	public List<T> consulta(T obj);
	
	
}
