package br.com.projeto.papelaria.dominio;

public class Fornecedor extends InformacoesPessoais {
	
	private Long idFornecedor;
	private String razaoSocial;
	private String cnpj;
	
	public Fornecedor(Usuario us, Contato ct, Endereco end) {
		super.usuario = us;
		super.contato = ct;
		super.endereco = end;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
