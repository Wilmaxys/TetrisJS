package fr.formation.model;

public class Utilisateur {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Utilisateur() { }
	
	public Utilisateur(String username, String password) {
		this.username = username;
		this.password = password;
	}
}