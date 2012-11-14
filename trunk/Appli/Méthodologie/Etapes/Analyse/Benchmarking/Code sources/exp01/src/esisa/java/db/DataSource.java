package esisa.java.db;

import java.sql.Connection;

public abstract class DataSource {
	private String driver, bridge;

	private String name, host;
	private String user, password;
	
	public DataSource(String name, String host, String user, String password) {
		super();
		this.name = name;
		this.host = host;
		this.user = user;
		this.password = password;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setBridge(String bridge) {
		this.bridge = bridge;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getDriver() {
		return driver;
	}
	
	public String getBridge() {
		return bridge;
	}

	public String getName() {
		return name;
	}
	public String getHost() {
		return host;
	}
	public abstract String getURL();
	
	public abstract Connection getConnection();
}
