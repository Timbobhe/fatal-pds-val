package esisa.java.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDataSource extends DataSource {
	public MySqlDataSource(String name, String host, String user, String password) {
		super(name, host, user, password);
		setDriver("com.mysql.jdbc.Driver");
		setBridge("jdbc:mysql:");
	}


	public Connection getConnection() {
		try {
			Class.forName(getDriver());
			Connection db = DriverManager.getConnection(getURL(), getUser(), getPassword());
			
			System.out.println("Connexion est bien établie...");
			return db;
		}
		catch(Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
	}


	public String getURL() {
		return getBridge() + "//" + getHost() + "/" + getName();
	}
	
}
