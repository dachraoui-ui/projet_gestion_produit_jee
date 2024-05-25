package Metier;

import dao.Login;

public class User {
	private String login;
	private String mdp;
	private String profile;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public User(String login, String mdp,String profile) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.profile=profile;
	}
	public User(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
	}
	public boolean verif(String l,String m)
	{
		Login logg=new Login();
		if(logg.getUserr(l)==true)
			return true;
		return false;
	}
	

}
