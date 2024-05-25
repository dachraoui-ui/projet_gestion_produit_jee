package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import metier.User;
import metier.Produit;
import java.util.List;
import dao.ProduitDaoImpl;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet (name = "ms", urlPatterns = {"/MyServlet", "*.do", "/updateProduit.send"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/MyServlet")) {
			// TODO Auto-generated method stub
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			
			User u = new User(login, pwd);
			String result = u.verif();
			String resultStr;
			if (result != null) {
				result = result.toUpperCase();
				resultStr = "Authentification avec succes";
				request.setAttribute("result", resultStr);
				ProduitDaoImpl produitDao = new ProduitDaoImpl();
				List<Produit> produits = produitDao.getProduits();
				request.setAttribute("produits", produits);
				if (result.equals("ADMIN")) {
					request.getRequestDispatcher("home.jsp").forward(request, response);
				} else if (result.equals("USER")) {
					request.getRequestDispatcher("result.jsp").forward(request, response);
				}
				
			} else {
				response.sendRedirect("login.html");
			}
		} else if (path.equals("/ajouterProduit.do")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			Produit p = new Produit(nom, prix);
			ProduitDaoImpl produitDao = new ProduitDaoImpl();
			produitDao.save(p);
			List<Produit> produits = produitDao.getProduits();
			request.setAttribute("produits", produits);
			String resultStr = "Authentification avec succes";
			request.setAttribute("result", resultStr);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (path.equals("/updateProduit.do")) {
			Long productId = Long.parseLong(request.getParameter("id"));
			
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			Produit produit = new Produit(nom, prix);
			produit.setIdProduit(productId);
			ProduitDaoImpl produitDao = new ProduitDaoImpl();
			produitDao.updateProduit(produit);
			List<Produit> produits = produitDao.getProduits();
			request.setAttribute("produits", produits);
			String resultStr = "Authentification avec succes";
			request.setAttribute("result", resultStr);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/deleteProduit.do")) {
			// Get the product ID to delete from the request parameter
		    Long productId = Long.parseLong(request.getParameter("id"));
		    
		    // Call the deleteProduit method in ProduitDaoImpl to delete the product
		    ProduitDaoImpl produitDao = new ProduitDaoImpl();
		    produitDao.deleteProduit(productId);
		    List<Produit> produits = produitDao.getProduits();
		    request.setAttribute("produits", produits);
		    String resultStr = "Authentification avec succes";
			request.setAttribute("result", resultStr);
		    
		    // Redirect back to the home.jsp page
		    request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (path.equals("/updateProduit.send")) {
			Long productId = Long.parseLong(request.getParameter("id"));
			
			ProduitDaoImpl produitDao = new ProduitDaoImpl();
			Produit produit = produitDao.getProduit(productId);
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("updateProduit.jsp").forward(request, response);
		} else if (path.equals("/searchProduits.do")) {
			String searchProduits = request.getParameter("searchProduits");
	        
	        ProduitDaoImpl produitDao = new ProduitDaoImpl();
	        List<Produit> filteredProduits = produitDao.produitsParMC(searchProduits);
	        String resultStr = "Authentification avec succes";
			
	        request.setAttribute("result", resultStr);
	        request.setAttribute("produits", filteredProduits);
	        request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
