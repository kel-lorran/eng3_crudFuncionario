package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dominio.EntidadeDominio;
import dominio.Funcionario;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;

public class FuncionarioDAO implements IDAO{
	private Connection con;
	
	public void conecta() throws Exception{
		this.con = ConnectionFactory.createConnectionToMySQL();		
	}

	@Override
	public void salvar(EntidadeDominio entidade)  {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		con = null;
		Funcionario funcionario = (Funcionario) entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO funcionarios(status, nome, matricula, setor, regional, email, cadastradoPor, cpf, dt_cadastro, cargo, dt_contratacao)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		
		//para testes inciais sem o type Timestamp
		//sql.append(
		//		"INSERT INTO funcionarios(status, nome, matricula, setor, regional, email, cadastradoPor, cpf, cargo)");
		//sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		
		try {
			//cria conex�o com o Banco
			conecta();
			//desativa auto commit
			con.setAutoCommit(false);
			
			
			pst = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, funcionario.getStatus());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getMatricula());
			pst.setString(4, funcionario.getSetor());
			pst.setString(5, funcionario.getRegional());
			pst.setString(6, funcionario.getEmail());
			pst.setString(7, funcionario.getCadastradoPor());
			pst.setString(8, funcionario.getCpf());
			pst.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pst.setString(10, funcionario.getCargo());
			//pst.setDate(11, (Date)funcionario.getDtContratacao());
			pst.setTimestamp(11, new Timestamp(funcionario.getDtContratacao().getTime()));
			//pst.setTimestamp(11, new Timestamp(funcionario.getDtContratacao().getTime()));
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			int id = 0;
			if (rs.next())
				id = rs.getInt(1);
			funcionario.setId(id);

			con.commit();
			
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void alterar(EntidadeDominio entidade)  {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		con = null;
		Funcionario funcionario = (Funcionario) entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append(
				"UPDATE funcionarios SET status = ?, nome = ?, matricula = ?, setor = ?, regional = ?, email = ?, cadastradoPor = ?, cpf = ?, cargo = ?, dt_contratacao = ?");
		sql.append("WHERE id = ?");
		
		//para testes inciais sem o type Timestamp
		//sql.append(
		//		"INSERT INTO funcionarios(status, nome, matricula, setor, regional, email, cadastradoPor, cpf, cargo)");
		//sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		
		try {
			//cria conex�o com o Banco
			conecta();
			//desativa auto commit
			con.setAutoCommit(false);
			
			
			pst = con.prepareStatement(sql.toString());
			pst.setString(1, funcionario.getStatus());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getMatricula());
			pst.setString(4, funcionario.getSetor());
			pst.setString(5, funcionario.getRegional());
			pst.setString(6, funcionario.getEmail());
			pst.setString(7, funcionario.getCadastradoPor());
			pst.setString(8, funcionario.getCpf());
			pst.setString(9, funcionario.getCargo());
			//pst.setDate(10, (Date)funcionario.getDtContratacao());
			pst.setTimestamp(10, new Timestamp(funcionario.getDtContratacao().getTime()));
			pst.setInt(11, funcionario.getId());
			pst.executeUpdate();
			//System.out.println(pst.toString());

			//ResultSet rs = pst.getGeneratedKeys();

			//int id = 0;
			//if (rs.next())
			//	id = rs.getInt(1);
			//funcionario.setId(id);

			con.commit();
			
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void excluir(EntidadeDominio entidade)  {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		con = null;
		Funcionario funcionario = (Funcionario) entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM funcionarios WHERE id = ?");
		
		
		//para testes inciais sem o type Timestamp
		//sql.append(
		//		"INSERT INTO funcionarios(status, nome, matricula, setor, regional, email, cadastradoPor, cpf, cargo)");
		//sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		
		try {
			//cria conex�o com o Banco
			conecta();
			//desativa auto commit
			con.setAutoCommit(false);
			
			
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, funcionario.getId());
			pst.executeUpdate();
			//System.out.println(pst.toString());

			//ResultSet rs = pst.getGeneratedKeys();

			//int id = 0;
			//if (rs.next())
			//	id = rs.getInt(1);
			//funcionario.setId(id);

			con.commit();
			
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<EntidadeDominio> consultar()  {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		con = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM funcionarios");
		
		List<EntidadeDominio> liFunc= new ArrayList<EntidadeDominio>();
		
		
		//para testes inciais sem o type Timestamp
		//sql.append(
		//		"INSERT INTO funcionarios(status, nome, matricula, setor, regional, email, cadastradoPor, cpf, cargo)");
		//sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		
		try {
			//cria conex�o com o Banco
			conecta();
			
			
			pst = con.prepareStatement(sql.toString());
			
			//System.out.println(pst.toString());

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String st = rs.getString("status");
				String nm = rs.getString("nome");
				String mt = rs.getString("matricula");
				String set = rs.getString("setor");
				String reg = rs.getString("regional");
				String em = rs.getString("email");
				String cPor = rs.getString("cadastradoPor");
				String cpf = rs.getString("cpf");
				Date dC = rs.getDate("dt_cadastro");
				String cg = rs.getString("cargo");
				Date dCt = rs.getDate("dt_contratacao");
				
				Funcionario func = new Funcionario(id,st,nm,mt,set,reg,em,cPor,cpf,dC,cg,dCt);
				
				liFunc.add(func);
			}

			//int id = 0;
			//if (rs.next())
			//	id = rs.getInt(1);
			//funcionario.setId(id);
			
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return liFunc;
	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;

		Funcionario filtroFuncionario = (Funcionario) entidade;

		if (filtroFuncionario.getNome() == null) {
			filtroFuncionario.setNome("");
		}
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * ");
		sql.append(" FROM funcionarios ");

		if(filtroFuncionario.getId() != 0 || !filtroFuncionario.getNome().equals("")) {
			sql.append("WHERE ");
		}
		if (filtroFuncionario.getId() != 0 && filtroFuncionario.getNome().equals("")) {
			sql.append("id =? ");
		}else if (filtroFuncionario.getId() == 0
				&& !filtroFuncionario.getNome().equals("")) {
			sql.append("nome like ?");
		}

		try {
			conecta();
			pst = con.prepareStatement(sql.toString());

			if (filtroFuncionario.getId() != 0
					&& filtroFuncionario.getNome().equals("")) {
				pst.setInt(1, filtroFuncionario.getId());
			} else if (filtroFuncionario.getId() == 0
					&& !filtroFuncionario.getNome().equals("")) {
				pst.setString(1, "%" + filtroFuncionario.getNome() + "%");
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> liFunc = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String st = rs.getString("status");
				String nm = rs.getString("nome");
				String mt = rs.getString("matricula");
				String set = rs.getString("setor");
				String reg = rs.getString("regional");
				String em = rs.getString("email");
				String cPor = rs.getString("cadastradoPor");
				String cpf = rs.getString("cpf");
				Date dC = rs.getDate("dt_cadastro");
				String cg = rs.getString("cargo");
				Date dCt = rs.getDate("dt_contratacao");
				
				Funcionario func = new Funcionario(id,st,nm,mt,set,reg,em,cPor,cpf,dC,cg,dCt);
				
				liFunc.add(func);			}
			return liFunc;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
