package br.com.projeto.papelaria.repository;

import br.com.projeto.papelaria.dominio.Usuario;

public interface LoginUsuario<T> extends AtualizarApagar<T> {
	public Boolean logar ( T obj );
	public Boolean sair ();

}
