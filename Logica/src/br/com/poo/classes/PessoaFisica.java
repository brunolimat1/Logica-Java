package br.com.poo.classes;

public abstract class PessoaFisica extends Pessoa{
	private String nome;
	private String cpf;
	
	public PessoaFisica() {	}

	public PessoaFisica(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
