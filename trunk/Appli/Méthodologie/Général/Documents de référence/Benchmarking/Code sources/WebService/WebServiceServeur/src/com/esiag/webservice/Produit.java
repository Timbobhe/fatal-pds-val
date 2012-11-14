package com.esiag.webservice;

import java.io.Serializable;

public class Produit implements Serializable {

	private String Reference;
	private String Designation;
	private double quantite;
	private double prix;
	public Produit() {
		super();
	}
	public Produit(String reference, String designation, double quantite,
			double prix) {
		super();
		Reference = reference;
		Designation = designation;
		this.quantite = quantite;
		this.prix = prix;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [Reference=" + Reference + ", Designation="
				+ Designation + ", quantite=" + quantite + ", prix=" + prix
				+ "]";
	}
	
}
