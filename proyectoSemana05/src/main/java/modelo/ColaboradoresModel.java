package modelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Entidades.Colaboradores;
import db.MySQLConexion;
import interfaces.IColaboradores;

public class ColaboradoresModel implements IColaboradores {
	// Objetos que operan con la BDD de MySQL
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<Colaboradores> Lista;
	private MySQLConexion ObjMySQL;
	
	// Método Constructor
	public ColaboradoresModel() {
		try {
				ObjMySQL = new MySQLConexion();
				Cn = ObjMySQL.getConexion();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método para listar los colaboradores
	@Override
	public ArrayList<Colaboradores> Listar(){
		String SQL = "SELECT * FROM Colaboradores";
		Lista = new ArrayList<Colaboradores>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					Lista.add(new Colaboradores(Rs.getString("Id"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo").charAt(0)));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return Lista;
	}
		
	// Método para buscar un colaborador
	@Override
	public Colaboradores Buscar(String Id) {
		String SQL = "SELECT * FROM Colaboradores WHERE Id=?";
		Colaboradores ObjC = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjC = new Colaboradores(Rs.getString("Id"),
							Rs.getString("Apellidos"),
							Rs.getString("Nombres"),
							Rs.getInt("Edad"),
							Rs.getString("Sexo").charAt(0));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return ObjC;
	}
		
	// Método para insertar colaboradores
	@Override
	public void Insertar(Colaboradores ObjC) {
		String SQL = "insert into Colaboradores values(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjC.getId());
				Stmt.setString(2, ObjC.getApellidos());
				Stmt.setString(3, ObjC.getNombres());
				Stmt.setInt(4, ObjC.getEdad());
				Stmt.setString(5, ObjC.getSexo() + "");
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
		
	// Método para modificar colaboradores
	@Override
	public void Modificar(Colaboradores ObjC) {
		String SQL = "update Colaboradores set Apellidos=?,Nombres=?,Edad=?,Sexo=? where Id=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(1, ObjC.getApellidos());
				Stmt.setString(2, ObjC.getNombres());
				Stmt.setInt(3, ObjC.getEdad());
				Stmt.setString(4, ObjC.getSexo() + "");
				Stmt.setString(5, ObjC.getId());
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
		
	// Método para suprimir colaboradores
	@Override
	public void Suprimir(String Id) {
		String SQL = "delete from Colaboradores where Id=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(1, Id);
				Stmt.executeUpdate();			
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}

}
