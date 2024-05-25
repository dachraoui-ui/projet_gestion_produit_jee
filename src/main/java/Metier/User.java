package Metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
	private String profile;
	private String login;
	private String pwd;

	public User(String profile, String login, String pwd) {
		this.profile = profile;
		this.login = login;
		this.pwd = pwd;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String verif() {
	    try {
	        Connection conn = SingletonConnection.getConnection();
	        
	        String sqlQuery = "SELECT profile FROM users WHERE login = ? AND pwd = ?";
	        PreparedStatement stmt = conn.prepareStatement(sqlQuery);
	        stmt.setString(1, login);
	        stmt.setString(2, pwd);
	        ResultSet res = stmt.executeQuery();
	        if (res.next()) {
	            
	        	String profile = res.getString("profile");
                return profile;
	        }
	        return null;
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        return null;
	    }
	}
}
