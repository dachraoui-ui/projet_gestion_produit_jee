package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Metier.SingletonConnection;
import Metier.Produit;


public class ProduitDaoImpl implements IProduitDao {
	@Override
	public Produit save(Produit p) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUITS(NOM_PRODUIT,PRIX) VALUES(?,?)");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix()); 
			ps.executeUpdate();
			
			PreparedStatement ps2= conn.prepareStatement("SELECT MAX(IDPRODUIT) as MAX_ID FROM PRODUITS");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				p.setIdProduit(rs.getLong("MAX_ID"));
			}
			
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	@Override
	public List<Produit> produitsParMC(String mc) { 
		List<Produit> prods = new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM produits WHERE nom_produit LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setIdProduit(rs.getLong("IDPRODUIT"));
				p.setNomProduit(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prods;
	}
	
	public List<Produit> getProduits() { 
		List<Produit> prods = new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setIdProduit(rs.getLong("IDPRODUIT"));
				p.setNomProduit(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prods;
	}
	
	@Override
	public Produit getProduit(Long id) {
		Produit p = new Produit();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where idproduit = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setIdProduit(rs.getLong("IDPRODUIT"));
				p.setNomProduit(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	@Override
	public Produit updateProduit(Produit p) {
		Connection conn=SingletonConnection.getConnection();
		
		try {
			Statement smt = conn.createStatement();
			smt.executeUpdate("UPDATE produits SET nom_produit = '" + p.getNomProduit() + "', prix = " + p.getPrix() + " WHERE idproduit = " + p.getIdProduit());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public void deleteProduit(Long id) {
		Connection conn=SingletonConnection.getConnection();
		
		try {
			Statement smt = conn.createStatement();
			smt.executeUpdate("DELETE FROM produits WHERE idproduit = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}