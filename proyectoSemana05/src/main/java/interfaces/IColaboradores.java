package interfaces;
import java.util.ArrayList;
import Entidades.Colaboradores;

public interface IColaboradores {
	public ArrayList<Colaboradores> Listar();
	public Colaboradores Buscar(String Id);
	public void Insertar(Colaboradores ObjC);
	public void Modificar(Colaboradores ObjC);
	public void Suprimir(String Id);
}
