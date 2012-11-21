package com.esiag.isidis;

import java.io.Serializable;


public class Produit  implements Serializable{
	private String ref;
	private String desig;
	private double prix;
	private double q;

	public Produit() {
		
	}

	public Produit(String ref, String desig, double prix, double q) {
		this.ref = ref;
		this.desig = desig;
		this.prix = prix;
		this.q = q;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getQ() {
		return q;
	}

	public void setQ(double q) {
		this.q = q;
	}
	
	@Override
	public String toString() {
		return ref+"\t"+desig+"\t"+prix+"\t"+q;
	}
	
}
