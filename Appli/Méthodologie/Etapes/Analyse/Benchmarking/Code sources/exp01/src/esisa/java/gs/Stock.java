package esisa.java.gs;

import esisa.java.db.Database;

public class Stock {
	private Database db;
	
	public Stock(Database db) {
		this.db = db;
	}
	
	public Produit[] selectAllProduits() {
		String[][] M = db.selectAll("produit");
		Produit[] p = new Produit[M.length];
		for (int i = 0; i < p.length; i++) {
			p[i]= new Produit(M[i][0], M[i][1], Double.parseDouble(M[i][3]),Double.parseDouble(M[i][2]));
		}
		return p;
	}
	
	
	public Produit getProduit(String keyValue) {
		String[] M = db.select("produit", "ref", keyValue);
		if(M == null) return null;
		Produit p = new Produit(M[0], M[1], Double.parseDouble(M[2]), Double.parseDouble(M[3]));
		return p;
	}
	
	public void insertProduit(Produit p) {
		db.insert("produit",new String[]{ p.getRef(), p.getDesig(), p.getPrix()+"", p.getQ()+""});
	}
	
}
