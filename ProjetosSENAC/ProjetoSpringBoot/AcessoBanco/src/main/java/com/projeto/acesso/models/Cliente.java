package com.projeto.acesso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcliente;

	@Column
	private String nomecliente;

	@Column
	private String email;

	@Column
	private String cpf;

	@Column
	private String telefone;

	@Column
	private Integer idade;
	
	public Cliente() {
		
	}

	public Cliente(Integer idcliente, String nomecliente, String email, String cpf, String telefone, Integer idade) {
		super();
		this.idcliente = idcliente;
		this.nomecliente = nomecliente;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
