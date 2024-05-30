package dao;

import java.util.List;
import Metier.Produit;


public class TestDao {
	public static void main(String[] args) {
		ProduitDaoImpl pdao= new ProduitDaoImpl();
		Produit prod= pdao.save(new Produit("iphone 8 plus",2800));
		System.out.println(prod);

		List<Produit> prods =pdao.produitsParMC("HP");
		for (Produit p : prods) {
			System.out.println(p);
		}
		
		System.out.println("________");
		System.out.println(pdao.getProduit((long) 1).toString());
		
		System.out.println("_________");
		Produit p = new Produit("Samsung A30", 870);
		p.setIdProduit((long) 1);
		System.out.println(pdao.updateProduit(p));

		System.out.println("___________");
		pdao.deleteProduit((long)5);
	}
}