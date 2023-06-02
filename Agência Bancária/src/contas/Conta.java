package contas;

public class Conta {
	// atributos
	private String cliente;
	private double saldo;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}

	/**
	 * Método simples (void) Exibir o saldo da conta
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */
	void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);
	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */
	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	/**
	 * Método com 2 parâmetros(objeto e variável)
	 * 
	 * @param destino
	 * @param valor
	 */
	void transferir(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferência: R$ " + valor);
	}

	/**
	 * Método com 2 parâmetros (variáveis) e retorno
	 * 
	 * @param cc1
	 * @param cc2
	 * @return
	 */
	double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}

}
