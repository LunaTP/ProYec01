package MisServlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Colaboradores;
import negocio.BSColaboradores;

@WebServlet("/grabar")
public class grabar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public grabar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BSColaboradores ObjBD = new BSColaboradores();
		Colaboradores ObjC = null;
		// Recuperar los parámetros desde la URL
		int op = Integer.parseInt(request.getParameter("op"));
		ObjC = new Colaboradores(request.getParameter("txtid"),
												request.getParameter("txtape"),
												request.getParameter("txtnom"),
												Integer.parseInt(request.getParameter("txteda")),
												request.getParameter("txtsex").charAt(0));		
		// Evaluar el metodo a invocar segun el valor de op
		switch(op) {
			case 1: ObjBD.Modificar(ObjC); break;
			case 2: ObjBD.Suprimir(ObjC.getId()); break;
			case 3: ObjBD.Insertar(ObjC); break;
		}
		// Regresar a la pagina principal
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
