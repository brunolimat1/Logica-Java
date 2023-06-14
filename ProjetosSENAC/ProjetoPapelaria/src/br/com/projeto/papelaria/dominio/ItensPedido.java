package br.com.projeto.papelaria.dominio;

public class ItensPedido {
	
	private Long idItensPedido;
	private Long idPedido;
	private Long idProduto;
	private Double desconto;
	private Long quantidade;
	private Double precoTotal;
	public Long getIdItensPedido() {
		return idItensPedido;
	}
	public void setIdItensPedido(Long idItensPedido) {
		this.idItensPedido = idItensPedido;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	

}
