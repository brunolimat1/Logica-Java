package minecraft;

// extends -> Herança
public class Enxada extends Bloco{
	//atributos
	//boolean (variável - true / false)
	boolean conquista;
	//métodos
	
	//construtor
	public Enxada() {
		System.out.println("");
		System.out.println("  -__");
		System.out.println("  /");
		System.out.println(" /");
	}
	
	public void arar() {
		System.out.println("Terra arada ._._._.");
		conquista = true;
	}
	
}
