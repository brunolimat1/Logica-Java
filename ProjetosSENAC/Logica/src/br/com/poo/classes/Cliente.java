package br.com.poo.classes;

public class Cliente {

	private int idCliente;
	private String nomeCliente;
	private String emailCliente;
	private String cpfCliente;
	private int idadeCliente;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public int getIdadeCliente() {
		return idadeCliente;
	}
	public void setIdadeCliente(int idadeCliente) {
		this.idadeCliente = idadeCliente;
	}
	
	public String cadastro() {
		String msg = "";
		if(idCliente < 1 || 
				nomeCliente.trim().equals("") || 
				emailCliente.trim().equals("") ||
				cpfCliente.trim().equals("") ||
				idadeCliente < 1) {
			msg = "Os dados devem ser preenchidos";
		}
		else {
			msg = "Dados cadastrados";
		}
		return msg;		
	}	
}



