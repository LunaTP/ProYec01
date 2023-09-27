package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDAOFactory extends DAOFactory {
	// Objetos para la conexion con MySQL
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost/cibertec2023";
	private String Usuario = "root";
	private String Password = "root";
	
	public Connection Cn;
	
	// Método Constructor
	public MySQLDAOFactory() {
		try {
				Class.forName(Driver);
				Cn = DriverManager.getConnection(URL, Usuario, Password);
		} catch (Exception e) {
				System.out.println("ERROR DE CONEXION :" + e.getMessage());
		}
	}
}
