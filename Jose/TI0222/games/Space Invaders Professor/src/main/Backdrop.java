package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Backdrop {
	BufferedImage background;

	// posição inicial eixo y para desenhar o background
	// esta variável precisa ser global
	int posBy = 0;

	// construtor
	public Backdrop() {
		// tratamento de exceções
		try {
			// carregar a imagem(upload)
			// Atenção! escolher imagens de background do tamanho da tela ou superior
			background = ImageIO.read(new File("img/background.jpg"));
		} catch (Exception e) {
			System.out.println("Não foi possível carregar a imagem");
			System.out.println(e);
		}

	}// fim do construtor

	// método responsável por "desenhar" o background
	public void exibirBackground(Graphics g) {
		g.drawImage(background, 0, posBy - 720, null);
		g.drawImage(background, 0, posBy, null);

		if (posBy > 720) {
			posBy = 0;
		} else {
			posBy += 2;
		}
	}

}// fim do código
