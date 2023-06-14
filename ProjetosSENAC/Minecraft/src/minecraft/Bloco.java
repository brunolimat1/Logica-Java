package minecraft;

public class Bloco {
	// atributos
	int resistencia;
	String textura;

	// construtor (iniciar um código para cada objeto)
	// o construtor precisa ter o mesmo nome da classe
	public Bloco() {
		System.out.println("");// pular uma linha
		System.out.println(" ___ ");
		System.out.println("|   |");
		System.out.println("|___|");
		System.out.println("");
	}

	// métodos
	// void -> método simples (executar uma ação)
	void construir() {
		System.out.println("Bloco colocado");
	}

	void minerar() {
		System.out.println("Recursos obtidos");
	}

	void craftar() {
		System.out.println("Item criado");
	}
}
