package br.com.dominio;

import java.sql.Date;

public class Chamado {
		private Long idChamado; 
		private String solicitacao; 
		private String depSolicitado; 
		private String descChamado; 
		private String dataAbertura; 
		private Date dataResolucao; 
		private String statusChamado; 
		private String observacoes; 
		private String atendente; 
		 
		public Chamado(Long idChamado, String solicitacao, String depSolicitado, String descChamado, 
				String dataAbertura, 
				 Date dataResolucao, String statusChamado, String observacoes, String 
				atendente) { 
				 this.idChamado = idChamado; 
				 this.solicitacao = solicitacao; 
				 this.depSolicitado = depSolicitado; 
				 this.descChamado = descChamado; 
				 this.dataAbertura = dataAbertura; 
				 this.dataResolucao = dataResolucao; 
				 this.statusChamado = statusChamado; 
				 this.observacoes = observacoes; 
				 this.atendente = atendente; 
				 }

		public Chamado() {
			// TODO Auto-generated constructor stub
		}

		public Long getIdChamado() {
			return idChamado;
		}

		public void setIdChamado(Long string) {
			this.idChamado = string;
		}

		public String getSolicitacao() {
			return solicitacao;
		}

		public void setSolicitacao(String solicitacao) {
			this.solicitacao = solicitacao;
		}

		public String getDepSolicitado() {
			return depSolicitado;
		}

		public void setDepSolicitado(String depSolicitado) {
			this.depSolicitado = depSolicitado;
		}

		public String getDescChamado() {
			return descChamado;
		}

		public void setDescChamado(String descChamado) {
			this.descChamado = descChamado;
		}

		public String getDataAbertura() {
			return dataAbertura;
		}

		public void setDataAbertura(String dataAbertura) {
			this.dataAbertura = dataAbertura;
		}

		public Date getDataResolucao() {
			return dataResolucao;
		}

		public void setDataResolucao(Date date) {
			this.dataResolucao = date;
		}

		public String getStatusChamado() {
			return statusChamado;
		}

		public void setStatusChamado(String statusChamado) {
			this.statusChamado = statusChamado;
		}

		public String getObservacoes() {
			return observacoes;
		}

		public void setObservacoes(String observacoes) {
			this.observacoes = observacoes;
		}

		public String getAtendente() {
			return atendente;
		}

		public void setAtendente(String atendente) {
			this.atendente = atendente;
		}
		
}
