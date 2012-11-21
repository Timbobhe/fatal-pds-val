package com.esiag.isidis;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ListeProduit {

	private Map<String, Produit> liste;

	public ListeProduit(Map<String, Produit> liste) {
		super();
		this.liste = liste;
	}

	public ListeProduit() {
		super();
		liste=new HashMap<>();
	}
	public void insert(Produit p)
	{
		liste.put(p.getRef(), p);
		
	}
	public Produit select(String ref)
	{
		return liste.get(ref);
	}
	
	
}
