package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dominio.EntidadeDominio;
import util.ConnectionFactory;

public class UsuarioDAO implements IDAO {
private Connection con;
	
	public void conecta() throws Exception{
		this.con = ConnectionFactory.createConnectionToMySQL();		
	}


	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EntidadeDominio> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

}
