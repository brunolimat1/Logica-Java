package contas;

public class Conta {
	//atributos
	public String cliente;
	public double saldo;
	
	//construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}
	
	//métodos
	
	/**
	 * Método simples (void)
	 * Exibir o saldo da conta 
	 */
	public void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}
	
	/**
	 * Método com parâmetro (variável)
	 * @param valor
	 */
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);
	}
	
	/**
	 * Método com parâmetro (variável)
	 * @param valor
	 */
	public void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}
	
	/**
	 * Método com 2 parâmetros(objeto e variável)
	 * @param destino
	 * @param valor
	 */
	public void transferir(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferência: R$ " + valor);
	}
	
	/**
	 * Método com 2 parâmetros (variáveis) e retorno
	 * @param cc1
	 * @param cc2
	 * @return
	 */
	public double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}
	
}
