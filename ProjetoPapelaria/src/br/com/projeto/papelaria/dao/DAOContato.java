package br.com.projeto.papelaria.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.projeto.papelaria.dominio.Contato;
import br.com.projeto.papelaria.dominio.Usuario;
import br.com.projeto.papelaria.repository.AtualizarApagar;

public class DAOContato extends Conexao implements AtualizarApagar<Contato>{

	@Override
	public String cadastro(Contato ob) {
		String idcontato = "";
		
		try {
			//abrir o banco
			abrirBanco();
			String sql = "insert into contato(telefone,email)values(?,?)";
			//vamos preparar a conexao para executar a consulta
			//O comando Statement.RETURN_GENERATED_KEYS retorna o id gerado no cadastro
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			//Realizar a passagem de parâmetros a consulta sql 
			pst.setString(1, ob.getTelefone());
			pst.setString(2, ob.getEmail());
			
			@SuppressWarnings("unused")
			int r = pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				idcontato = String.valueOf(rs.getInt(1));
			}
			

			else {
				idcontato = null;
			}
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			fecharBanco();
		}
		return idcontato;
	}

	@Override
	public List<Usuario> consulta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> consulta(Contato ob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(Contato ob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(Contato ob) {
		// TODO Auto-generated method stub
		return null;
	}

}
