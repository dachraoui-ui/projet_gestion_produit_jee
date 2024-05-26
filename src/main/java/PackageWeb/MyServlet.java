package PackageWeb;

import java.io.IOException;

import Metier.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@jakarta.servlet.annotation.WebServlet("/MyServlet")
public class MyServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String p = request.getParameter("profile");
		String l=request.getParameter("login");
		String m=request.getParameter("mdp");
		User u=new User(p,l,m);
		String rslt=u.verif();
		request.setAttribute("result", rslt);
        request.getRequestDispatcher("/Resultat.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
