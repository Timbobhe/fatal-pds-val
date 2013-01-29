package fr.esiag.isidis.fatal.gestionRame;

import fr.esiag.isidis.fatal.outils.Position;

public class Rame {
	
	private String nom; 
	private EffecteurRame eff;
	private Position position;
	private boolean etat;


	
	
	public Rame(String nom ,EffecteurRame eff)
	{
		position= new Position(-400,100);
		this.nom =nom;
		this.eff=eff;
		etat=false;
	}
	
	
	
	public String getNom()
	{
		return this.nom;
	}
	
	public EffecteurRame getEffecteur(){
		return this.eff;
	}
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	public Position getPosition(){
		return eff.getPosition();
	}



	public boolean isEtat() {
		return etat;
	}



	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean getEtat() {
		return etat;
	}
	
	
	
	

	
	

}
