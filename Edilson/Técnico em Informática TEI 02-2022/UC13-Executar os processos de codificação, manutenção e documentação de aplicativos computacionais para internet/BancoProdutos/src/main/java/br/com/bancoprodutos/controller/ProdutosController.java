package br.com.bancoprodutos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancoprodutos.models.Produtos;
import br.com.bancoprodutos.repository.ProdutosRepository;

@RestController
public class ProdutosController {

	@Autowired
	private ProdutosRepository prod;
	
	@GetMapping("/produtos/listar")
	public List<Produtos> listar(){
		return prod.findAll();
	}
	
	@PostMapping("/produtos/cadastro")
	public String cadastro(@RequestBody Produtos produto) {
		prod.save(produto);
		return "Produto cadastrado";
				
	}
	@PutMapping("/produtos/atualizar/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Produtos produto) {
		Optional<Produtos> pr = prod.findById(id);
		
		String msg = "";
		
		if(pr.isPresent()) {
			produto.setIdproduto(id);
			prod.save(produto);
			msg = "Produto atualizado";
		}
		else {
			msg = "Produto não encontrado";
		}
		
		return msg;
	}
	
	@DeleteMapping("/produtos/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		prod.deleteById(id);
		return "Produto apagado";
	}
	
}







