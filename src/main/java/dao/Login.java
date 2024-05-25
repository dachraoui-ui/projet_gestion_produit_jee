package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Produit;
import Metier.SingletonConnection;
import Metier.User;

public class Login {
	
	public void createCompte(User v)
	{
		Connection conn=SingletonConnection.getConnection();
		if(!(this.getUserr(v.getLogin())))
		{ 
		 try
		 {
		    PreparedStatement ps= conn.prepareStatement("insert into users values(?,?,?)");
		    ps.setString(1,v.getLogin());
		    ps.setString(2,v.getPwd());
		    ps.setString(3,v.getProfile());
		    ps.executeUpdate();
		    System.out.println("Utilisateur ajouté");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}else {
		System.out.println("Utilisateur existe deja");
	}
	}
	public boolean getUserr(String login)
	{
		Connection conn=SingletonConnection.getConnection();
		try {
		    PreparedStatement ps= conn.prepareStatement("select * from USER where LOGIN= ?");
		    ps.setString(1,login);
		    boolean rs = ps.execute();
		    return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
