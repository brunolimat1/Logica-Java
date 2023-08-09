package br.com.bancoprodutos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproduto;
	
	@Column(length=100)
	private String nomeproduto;
	
	@Column
	private String descricao;
	
	@Column(length = 50)
	private String categoria;
	
	@Column(length = 20)
	private String lote;
	
	@Column(length = 20)
	private String datafabricacao;
	
	@Column(length = 20)
	private String datavalidade;
	
	@Column(precision = 2)
	private Double preco;
	
	@Column(length = 200)
	private String imagemproduto;

	public Produtos() {
	}

	public Produtos(Integer idproduto, String nomeproduto, String descricao, String categoria, String lote,
			String datafabricacao, String datavalidade, Double preco, String imagemproduto) {
		this.idproduto = idproduto;
		this.nomeproduto = nomeproduto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.lote = lote;
		this.datafabricacao = datafabricacao;
		this.datavalidade = datavalidade;
		this.preco = preco;
		this.imagemproduto = imagemproduto;
	}

	public Integer getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getDatafabricacao() {
		return datafabricacao;
	}

	public void setDatafabricacao(String datafabricacao) {
		this.datafabricacao = datafabricacao;
	}

	public String getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(String datavalidade) {
		this.datavalidade = datavalidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagemproduto() {
		return imagemproduto;
	}

	public void setImagemproduto(String imagemproduto) {
		this.imagemproduto = imagemproduto;
	}
	
	
	
}




