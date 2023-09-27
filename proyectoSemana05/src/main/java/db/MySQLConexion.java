package db;
import java.sql.Connection;
import DAO.MySQLDAOFactory;

public class MySQLConexion {
	
	private MySQLDAOFactory ObjMySQL;
	
	// Método que retorna la Conexion actual con MySQL
	public Connection getConexion() {
		ObjMySQL = new MySQLDAOFactory();
		return ObjMySQL.Cn;
	}
}
