package minecraft;

public class Mundo {

	public static void main(String[] args) {
		// Instanciar(criar) um objeto
		Bloco blocoTerra = new Bloco();
		blocoTerra.resistencia = 1;
		blocoTerra.textura = "Terra";
		System.out.println("Bloco " + blocoTerra.textura);
		System.out.println("Resistência: " + blocoTerra.resistencia);
		blocoTerra.construir();
		blocoTerra.minerar();
		blocoTerra.craftar();

		Bloco blocoMadeira = new Bloco();
		blocoMadeira.resistencia = 1;
		blocoMadeira.textura = "Madeira";
		System.out.println("Bloco " + blocoMadeira.textura);
		System.out.println("Resistência: " + blocoMadeira.resistencia);
		blocoMadeira.minerar();
		blocoMadeira.craftar();
		blocoMadeira.construir();
	}
}
