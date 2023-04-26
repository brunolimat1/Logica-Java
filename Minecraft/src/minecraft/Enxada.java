package minecraft;

// extends -> Herança
public class Enxada extends Bloco {
	// atributos
	// boolean (variável - true / false)
	boolean conquista;

	// construtor
	public Enxada() {
		System.out.println("");
		System.out.println("  -__");
		System.out.println("  /");
		System.out.println(" /");
	}

	// métodos
	public void arar() {
		System.out.println("Terra arada ._._._.");
		conquista = true;
	}

	// Uso do polimorfismo para modificar o
	// comportamento de um método
	// Obrigatório usar o mesmo nome do método
	public void minerar() {
		System.out.println("Dano causado!");
	}

}
