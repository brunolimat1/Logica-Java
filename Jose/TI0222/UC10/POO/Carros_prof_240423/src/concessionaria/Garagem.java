package concessionaria;

public class Garagem {

	public static void main(String[] args) {
		Carro carroFerrari = new Carro();
		carroFerrari.ano = 2020;
		carroFerrari.cor = "Vermelho";
		System.out.println("Ferrari");
		System.out.println("Ano: " + carroFerrari.ano);
		System.out.println("Cor: " + carroFerrari.cor);
		carroFerrari.ligar();
		carroFerrari.acelerar();
		
		Carro carroFusca = new Carro();
		carroFusca.ano = 1967;
		carroFusca.cor = "Azul";
		System.out.println("Fusca");
		System.out.println("Ano: " + carroFusca.ano);
		System.out.println("Cor: " + carroFusca.cor);
		carroFerrari.ligar();
		carroFusca.acelerar();
		carroFusca.desligar();
	}

}
