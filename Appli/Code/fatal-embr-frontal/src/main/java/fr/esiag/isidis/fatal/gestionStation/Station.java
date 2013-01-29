package fr.esiag.isidis.fatal.gestionStation;

import fr.esiag.isidis.fatal.outils.Position;

public class Station {
	
	private String nom;
	private Position position;


	public Station(String nom, Position position) {
		super();
		this.nom = nom;
		this.position = position;
	}
	
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
	
	
	

}
