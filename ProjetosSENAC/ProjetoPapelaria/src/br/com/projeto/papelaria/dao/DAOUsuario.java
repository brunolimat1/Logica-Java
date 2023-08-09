package br.com.projeto.papelaria.dao;

import java.util.List;

import br.com.projeto.papelaria.dominio.Usuario;
import br.com.projeto.papelaria.repository.AtualizarApagar;

public class DAOUsuario extends Conexao implements AtualizarApagar<Usuario> {

	public String cadastro(Usuario ob) {
		String msg = "";
		
		try {
			abrirBanco();
			String sql = "insert into usuario(nomeusuario, senha, nivelacesso) value ?, ?, ?";
			pst = con.prepareStatement(sql);
		
			pst.setString(1, ob.getNomeUsuario());
			pst.setString(2, ob.getSenha());
			pst.setString(3, ob.getNivelAcesso());
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return msg;

	}

	@Override
	public List<Usuario> consulta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> consulta(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean logar(Usuario usuario) {
		Boolean logou = true;

		return logou;
	}

	public Boolean sair() {
		return true;
	}

}
