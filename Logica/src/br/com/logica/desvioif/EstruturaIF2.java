package br.com.logica.desvioif;

import javax.swing.JOptionPane;

public class EstruturaIF2 {

	public static void main(String[] args) {
		
		//Vamos criar um programa para calcular a média do aluno.
		//Teremos de inserir 4 notas, e calcular a média destas
		//4 notas e exibir o resultado final!
		double nota1,nota2,nota3,nota4,media;
		
		
//		JOptionPane.showMessageDialog(null,"Olá","Alerta!", JOptionPane.WARNING_MESSAGE);
		nota1 = Double.parseDouble( JOptionPane.showInputDialog("Digite a Primeira Nota"));
		
		nota2 = Double.parseDouble( JOptionPane.showInputDialog("Digite a Segunda Nota"));
		
		nota3 = Double.parseDouble( JOptionPane.showInputDialog("Digite a Terceira Nota"));
		
		nota4 = Double.parseDouble( JOptionPane.showInputDialog("Digite a Quarta Nota"));
		
		media = (nota1+nota2+nota3+nota4) / 4;
		
		if(media >= 5)
			JOptionPane.showMessageDialog(null, "A Média do Aluno é: "+media+"!  Ele está Aprovado!!!");
		else
			JOptionPane.showMessageDialog(null, "A Média do Aluno é: "+media+"!  Ele está Reprovado!!!");
			
	}

}
