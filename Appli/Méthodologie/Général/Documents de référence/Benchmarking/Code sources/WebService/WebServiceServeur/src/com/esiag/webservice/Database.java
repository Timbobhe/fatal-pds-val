package com.esiag.webservice;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.basex.core.Context;
import org.basex.core.cmd.Add;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.InfoDB;
import org.basex.core.cmd.Optimize;
import org.basex.core.cmd.Set;

import com.mysql.jdbc.ResultSetMetaData;
public class Database {
	private DataSource dataSource;
	private Connection connection;

	public Database() {
		super();
	}
	
	public Database(DataSource dataSource) {
		setDataSource(dataSource);
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		connection = dataSource.getConnection();
	}
	
	public void insert(Object object) {
		try {
			String tableName = object.getClass().getSimpleName();
			StringBuffer query = new StringBuffer("INSERT INTO " + tableName + " VALUES(");
			Field f[] = object.getClass().getDeclaredFields();
			f[0].setAccessible(true);
			query.append("'" + f[0].get(object) + "'");
			f[0].setAccessible(false);
			for (int i = 1; i < f.length; i++) {
				f[i].setAccessible(true);
				query.append(",'" + f[i].get(object) + "'");
				f[i].setAccessible(false);
			}
			query.append(")");
			System.out.println(query);
			Statement sql = connection.createStatement();
			System.out.println(sql.executeUpdate(query.toString()));
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public Produit select(Object object) {
		
		try {
			String query = "SELECT * FROM  Produit"  + " where Ref" + " = '" + object + "'" ;
			Statement sql = connection.createStatement();
			ResultSet rs = sql.executeQuery(query);
			if(rs.next()) {
				java.sql.ResultSetMetaData md=rs.getMetaData();
				String [] t =new String[md.getColumnCount()];
				for (int i = 0; i < md.getColumnCount(); i++) {

					
					t[i]=new String();
					t[i]=rs.getString(i+1);
				}
				rs.close();
				
				return new Produit(t[0], t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3]));
			}
			else {
				
			rs.close();
			return null;
			}
		
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public String[] getColumnName(String tablename) {
		String req = "SELECT * FROM " + tablename;
		try {
			Statement sql = connection.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
			String name[] = new String[rsm.getColumnCount()];
			for (int i=1; i<=rsm.getColumnCount(); i++) {
				name[i-1] = rsm.getColumnName(i);
			}
			return name;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	

	public void update(String table, String key, String value, String row[]) {
		try  {
			String []tablename = getColumnName(table);
			String query = "UPDATE " + table + " SET ";
			for (int i=0; i<tablename.length-1; i++) {
				query = query + tablename[i] + " = '" + row[i] + "', ";
			}
			query = query + tablename[tablename.length-1] + " = '" + row[tablename.length-1] + "' ";
			query = query + "WHERE " + key + " = '" +  value + "';";
			System.out.println(query);
			Statement sql = connection.createStatement();
			sql.executeUpdate(query);
		}
		catch (Exception e) {}
	}
	
	public int Delete(String tablename, String key, String value) {
		String req = "DELETE FROM " + tablename + " WHERE " + key + " = '" + value + "'";
		try {
			Statement sql = connection.createStatement();
			return sql.executeUpdate(req);
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return 0;
		}
	}
	
}
