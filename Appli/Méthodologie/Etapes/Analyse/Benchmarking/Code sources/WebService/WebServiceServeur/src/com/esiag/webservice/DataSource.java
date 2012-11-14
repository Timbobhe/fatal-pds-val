package com.esiag.webservice;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	private String driver;
	private String url;
	private String userName;
	private String password;
	
	private Connection connection = null;
	
	public DataSource() {
		super();
	}

	public DataSource(String driver, String url, String userName,
			String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DataSource [driver=" + driver + ", password=" + password
				+ ", url=" + url + ", userName=" + userName + "]";
	}
	
	public Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("Connexion bien �tablie!");
			}
			catch(Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
		}
		return connection;
	}
}
