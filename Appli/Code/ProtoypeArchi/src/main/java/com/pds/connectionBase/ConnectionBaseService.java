package com.pds.connectionBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Hamza
 * 
 */
public class ConnectionBaseService {
	/**
	 * 
	 * @throws SQLException
	 */
	public ConnectionBaseService() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/baseprototypepds", "root", "root");
		return con;
	}

	/**
	 * 
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public static String getinfoRequest(Connection con) throws SQLException {
		PreparedStatement statement = con
				.prepareStatement("select * from message");

		// PreparedStatement statement =
		// con.prepareStatement("INSERT INTO message (type, info) VALUES
		// ("alert msg" , 'incendie');

		ResultSet result = statement.executeQuery();
		result.next();
		return result.getString(2);
	}

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		ConnectionBaseService c = new ConnectionBaseService();
		String s = getinfoRequest(c.connect());
		System.out.println("dérnière info reçu " + s);

	}
}