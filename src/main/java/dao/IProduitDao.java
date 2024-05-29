package dao;

import java.util.List;
import Metier.Produit;


public interface IProduitDao {
	 Produit save(Produit p);
	 List<Produit> produitsParMC(String mc);
	 Produit getProduit(Long id);
	 Produit updateProduit(Produit p);
	 void deleteProduit(Long id);
}