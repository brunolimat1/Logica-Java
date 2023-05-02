package br.com.projeto.papelaria.dominio;

public class Cliente extends InformacoesPessoais{

	private Long idCliente;
	private String nomeCliente;
	private String cpf;
	
	public Cliente(Usuario us, Contato ct, Endereco end) {
		super.usuario = us;
		super.contato = ct;
		super.endereco = end;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
