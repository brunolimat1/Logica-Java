package br.com.projeto.papelaria.dominio;

public class Pagamento {
	
	private Long idPagamento;
	private Pedido Pedido;
	private TipoPagamento tipo;
	private String descricao;
	private Double valor;
	private Integer parcelas;
	private Double valorParcelas;
	public Long getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}
	public Pedido getPedido() {
		return Pedido;
	}
	public void setPedido(Pedido pedido) {
		Pedido = pedido;
	}
	public TipoPagamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	public Double getValorParcelas() {
		return valorParcelas;
	}
	public void setValorParcelas(Double valorParcelas) {
		this.valorParcelas = valorParcelas;
	}
	
	
	
}
