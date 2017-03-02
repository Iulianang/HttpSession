package ejemplosesion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeseionLogout
 */
@WebServlet("/SesionLogout")
public class SesionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SesionLogout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

		HttpSession sesion = request.getSession();

		if (action.equals("/out")) {
			sesion.invalidate();
			response.sendRedirect("adiosSesion.jsp");
		} else {
			sesion.invalidate();
			response.sendRedirect("adiosSesion.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession sesion = request.getSession();
	        String usu;
	        usu = request.getParameter("USUARIO");
            sesion.setAttribute("contador", 0);
	        
	        if(sesion.getAttribute("usuario") == null)
	        {
	            
	            sesion.setAttribute("usuario", usu);
	            
	            response.sendRedirect("principalsesion.jsp");
	        }
	        else
	        {
	        	sesion.invalidate();
	            response.sendRedirect("inicio.jsp");
	        }
		
		
	}

}
