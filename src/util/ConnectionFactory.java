package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//nome do usuário do mysql
	private static final String USERNAME = "root";
	
	//senha do mysql
	private static final String PASSWORD = "";
	
	//dados de caminho, porta e nome da base de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";

	public static Connection createConnectionToMySQL() throws Exception{
	      Class.forName("com.mysql.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
	 
	      //Cria a conexão com o banco de dados
	      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	 
	      return connection;
	   }
//	   public static void main(String[] args) throws Exception{
//	 
//	      //Recupera uma conexão com o banco de dados
//	      Connection con = createConnectionToMySQL();
//	 
//	      //Testa se a conexão é nula
//	      if(con != null){
//	         System.out.println("Conexão obtida com sucesso!" + con);
//	         con.close();
//	      }
//	 
//	   }

}
