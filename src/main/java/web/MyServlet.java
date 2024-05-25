package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Metier.User;
import Metier.Produit;
import java.util.List;
import dao.ProduitDaoImpl;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet (name = "ms", urlPatterns = {"/MyServlet", "*.do", "/updateProduit.send"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/MyServlet")) {
			
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			
			User u = new User(login, pwd);
			String result = u.verif();
			String resultStr;
			if (result != null) {
				result = result.toUpperCase();
				resultStr = "Authentification";
				request.setAttribute("result", resultStr);
				ProduitDaoImpl produitDao = new ProduitDaoImpl();
				List<Produit> produits = produitDao.getProduits();
				request.setAttribute("produits", produits);	
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
			String resultStr = "Authentification ";
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
			String resultStr = "Authentification ";
			request.setAttribute("result", resultStr);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/deleteProduit.do")) {
			
		    Long productId = Long.parseLong(request.getParameter("id"));
		    
		   
		    ProduitDaoImpl produitDao = new ProduitDaoImpl();
		    produitDao.deleteProduit(productId);
		    List<Produit> produits = produitDao.getProduits();
		    request.setAttribute("produits", produits);
		    String resultStr = "Authentification ";
			request.setAttribute("result", resultStr);
		    
		   
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
	        String resultStr = "Authentification";
			
	        request.setAttribute("result", resultStr);
	        request.setAttribute("produits", filteredProduits);
	        request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
