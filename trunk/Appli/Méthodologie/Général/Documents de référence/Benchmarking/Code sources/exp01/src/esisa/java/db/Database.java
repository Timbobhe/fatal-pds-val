package esisa.java.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class Database {
	private Connection db;
	private DatabaseMetaData dbm;
	
	public Database(DataSource ds) {
		try {
			db = ds.getConnection();
			dbm = db.getMetaData();
			System.out.println(dbm.getDriverName());
			System.out.println(dbm.getDriverVersion());
			System.out.println(dbm.getURL());
			System.out.println(dbm.getUserName());
			
			System.out.println("Connexion est bien établie...");
		}
		catch(Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
		}
	}
	
	public Vector<String> getTables() {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbm.getTables(null, null, null, new String[]{"TABLE", "VIEW"});
			while (rs.next()) {
				v.add(rs.getString(3));
			}
			return v;
		}
		catch(Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
	}
	
	public String[][] selectAll(String tableName) {
		String M[][];
		String req = "SELECT * FROM " + tableName;
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			rs.last();
			int rows = rs.getRow();
			M = new String[rows][cols];
			rs.beforeFirst();
			int j = 0;
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					M[j][i-1] = rs.getString(i);
				}
				j++;
			}
			return M;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	/*public void selectAll(String tableName) {
		String req = "SELECT * FROM " + tableName;
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			int n = rsm.getColumnCount();
			while (rs.next()) {
				//String desig = rs.getString("desig");
				//System.out.println(desig);
				for (int i = 1; i <= n; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}*/
	
	public String []select(String tableName, String key, String value) {
		String req = "SELECT * FROM " + tableName + " WHERE " + key + " = '" + value + "'";
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			if (rs.next()) {
				ResultSetMetaData rsm = rs.getMetaData();
				int n = rsm.getColumnCount();
				String T[] = new String[n];
				for (int i = 1; i <= n; i++) {
					T[i-1] = rs.getString(i);
				}
				return T;
			}
			else return null;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public int insert(String tableName, String T[]) {
		StringBuffer req = new StringBuffer("INSERT INTO " 
				+ tableName + " VALUES('" + T[0] + "'");
		for(int i=1; i<T.length; i++) req.append(", '" + T[i] + "'");
		req.append(")");
		                                                         
		try {
			Statement sql = db.createStatement();
			return sql.executeUpdate(req.toString());
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return -1;
		}
	}
	
}
