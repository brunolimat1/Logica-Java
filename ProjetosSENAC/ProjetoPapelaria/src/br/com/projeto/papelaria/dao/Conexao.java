package br.com.projeto.papelaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Conexao {

	protected Connection con = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;

	@SuppressWarnings("deprecation")
	protected void abrirBanco() {
		try {
			// Carregando o drivre de comunicação com o banco de dados mysql
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			// Passar url, nome de usuario, senha e timezone
			con = DriverManager.getConnection("jdbc:mysql://10.26.44.234:6020/papelariadb?usetimezone=true", "root", "123@senac");

		} catch (ClassNotFoundException cnf) {
			System.out.println("Erro ao carregar o driver ->" + cnf.getMessage());
		} catch (SQLException se) {
			System.out.println("Erro ao estabelecer conexão ->" + se.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado ->" + e.getMessage());
		}

	}

	protected void fecharBanco() {
		try {
			con.close();
		} catch (Exception se) {
			System.out.println("Não foi possivel fechar o banco" + se.getMessage());
		}

	}

}
