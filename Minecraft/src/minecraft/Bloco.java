package minecraft;

public class Bloco {
	//Atributos
	int resistencia;
	String textura;
	
	//Construtor (iniciar um código para cada objeto)
	public Bloco() {
		System.out.println("");//pular uma linha
		System.out.println(" ---- ");
		System.out.println("|    |");
		System.out.println("|    |");
		System.out.println(" ---- ");
	}
	
	//Métodos
	//Void -> Função
	void construir() {
		System.out.println("Bloco colocado");
	}
	void minerar() {
		System.out.println("Recursos obtidos");
	}
	void craftar() {
		System.out.println("Item criados");
	}
}
