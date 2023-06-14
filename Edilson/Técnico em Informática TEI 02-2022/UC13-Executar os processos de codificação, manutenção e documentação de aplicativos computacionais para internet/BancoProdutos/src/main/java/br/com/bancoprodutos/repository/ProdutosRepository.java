package br.com.bancoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bancoprodutos.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

}
