package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	public void play() {
		//carregar o arquivo de áudio
		File file = new File("som/laser1.wav");
		//tratamento de exceções(arquivo não encontrado, formato etc)
		try {
			//relacionado ao hardware de áudio do sistema
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			//Controle do áudio (reprodução, pausa, avanço etc)
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
