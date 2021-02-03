package conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDConecta
 */
@WebServlet("/CRUDConecta")
public class CRUDConecta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDConecta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String jdbc_url = "jdbc:postgresql://localhost:7777/crud_spring?useSSL=false";
		String usuario = "postgres";
		String pass = "4321";
		
		String driver = "org.postgresql.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.print("Nombre de la BBDD: " + jdbc_url + " <br>");
			
			Class.forName(driver);
			
			Connection mi_conexion = DriverManager.getConnection(jdbc_url, usuario, pass);
			
			out.print("Conectado!!");
			
			mi_conexion.close();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
