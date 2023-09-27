package DAO;

public abstract class DAOFactory {
	// Tipos de BDD 
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	// Establecer la BDD a utilizar
	public static DAOFactory getDaoFactory(int tipo) {
		switch(tipo) {
			case MYSQL:
				return new MySQLDAOFactory();
			default:
				return null;
		}
	}
}
