package com.esiag.pds.CollecteInfo;

import java.io.Serializable;

public class Message implements Serializable{

	
	protected String nom;
	protected String prenom;
	protected double age;
	
	
	public Message(String nom, String prenom, double age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	public Message() {
		super();
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Message [nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ "]";
	}
	
}
