package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Nave {
	// criar um sprite com uma imagem existente(upload)
	BufferedImage sprite1;

	// variáveis
	int posX = 600;
	int posY = 550;
	int velocidade = 1;

	// construtor
	public Nave() {
		// tratamento de exceções
		try {
			// carregar a imagem(upload)
			sprite1 = ImageIO.read(new File("img/nave.png"));
		} catch (Exception e) {
			System.out.println("Não foi possível carregar a imagem");
			System.out.println(e);
		}
	}

	// método responsável por "desenhar" a nave
	public void exibirNave(Graphics g) {
		g.drawImage(sprite1, posX, posY, null); // 600 -> posição x | 550 -> pos y
	}

	// método que ao ser executado recebe um valor para a variável sentido
	public void moverNave(int sentido) {
		//System.out.println(sentido);
		// sentido x positivo >>>> (1)
		// sentido x negativo <<<< (-1)
		// sentido y positivo ^^^^^ (2)
		// sentido y negativo vvvvv (-2)
		if (sentido == 1) {
			posX += velocidade;
		} else if (sentido == -1) {
			posX -= velocidade;
		} else if (sentido == 2) {
			posY -= velocidade;
		} else if (sentido == -2) {
			posY += velocidade;
		}

		// Evitar que a nave "escape" da tela
		// System.out.println(posX);
		//System.out.println(posY);
		if (posX < 1) {
			posX = 1;
		}

		if (posX > 1203) {
			posX = 1203;
		}
		
		if (posY < 3) {
			posY = 3;
		}

		if (posY > 550) {
			posY = 550;
		}
	}
	
	//Criar o tiro passando a posição x da nave para a classe Laser
	//retornar o "tiro" para a Engine
	public Laser atirar() {
		Laser tiro = new Laser(posX + 28);
		return tiro;
	}
	
}
