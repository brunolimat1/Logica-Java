package br.com.paperbook.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcategoria;
	
	@Column(nullable=false)
	private String nomecategoria;
	
	@Column(nullable = false)
	private String descricao;

	public Categoria() {
	}

	public Categoria(Integer idcategoria, String nomecategoria, String descricao) {
		this.idcategoria = idcategoria;
		this.nomecategoria = nomecategoria;
		this.descricao = descricao;
	}

	public Integer getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
