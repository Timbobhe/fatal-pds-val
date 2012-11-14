package com.esiag.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.esiag.webservice.IWebService")
public class Service implements IWebService {

	private Database db;
	
	
	public Service() {
		super();
		
	//	db=new Database(new DataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/stock", "root", ""));
		db=new Database(new DataSource("org.postgresql.Driver", "jdbc:postgresql://localhost/stock", "admin", ""));
	}
	
	@Override
	public Boolean ajouter(Produit p) {
		db.insert(p);
		return true;
	}

	@Override
	public Produit Get(String ref) {
		Produit p=db.select(ref);
		return p;
	}

	@Override
	public void update(String table, String key, String value, String[] row) {
		db.update(table, key, value, row);
		
	}

	@Override
	public int Delete(String tablename, String key, String value) {
		return db.Delete(tablename, key, value);
	}

	

}
