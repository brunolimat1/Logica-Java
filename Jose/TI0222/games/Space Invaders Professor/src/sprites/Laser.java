package sprites;

import java.awt.Color;
import java.awt.Graphics;

public class Laser {
	//variáveis
	int posXL;
	int posYL = 540;
	
	//construtor que recebe como parâmetro a posição da nave
	public Laser(int posXLInicial) {
		posXL = posXLInicial;
	}
	
	//método responsável para exibir(desenhar) o tiro de laser
	public void exibirLaser(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(posXL, posYL, 5, 20); //x,y,width, height
	}
	
	//método responsável pelo movimento do laser
	public void moverLaser() {
		posYL -= 5; //ajuste da velocidade do tiro de laser
		// apoio ao entendimento da lógica do tiro
		System.out.println(posYL);
	}
	
	//método responsável pela "remoção" do laser
	public boolean removerLaser() {
		if (posYL < 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
