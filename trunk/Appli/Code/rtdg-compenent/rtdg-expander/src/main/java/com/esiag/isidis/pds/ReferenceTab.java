package com.esiag.isidis.pds;

import java.util.HashMap;
import java.util.Iterator;


public class ReferenceTab {


	public class Ref {
		private String name_evenment;
		private int id_evenement;
		private String id_capteur;
		
		
		
		@Override
		public String toString() {
			return "Ref [name_evenment=" + name_evenment + ", id_evenement="
					+ id_evenement + ", id_capteur=" + id_capteur + "]";
		}
		public int getId_evenement() {
			return id_evenement;
		}
		public void setId_evenement(int id_evenement) {
			this.id_evenement = id_evenement;
		}
		public String getId_capteur() {
			return id_capteur;
		}
		public void setId_capteur(String id_capteur) {
			this.id_capteur = id_capteur;
		}
		public Ref(String name_evenment, int id_evenement, String id_capteur) {
			super();
			this.name_evenment = name_evenment;
			this.id_evenement = id_evenement;
			this.id_capteur = id_capteur;
		}
		public String getName_evenment() {
			return name_evenment;
		}
		public void setName_evenment(String name_evenment) {
			this.name_evenment = name_evenment;
		}
		
	}
	
	public class LocalisationCapteur {
		private String id_capteur;
		private String source;
		private String position;
		private String evenement_name;
		
		
		
		
		
		@Override
		public String toString() {
			return "LocalisationCapteur [id_capteur=" + id_capteur
					+ ", source=" + source + ", position=" + position
					+ ", evenement_name=" + evenement_name + "]";
		}
		public LocalisationCapteur(String id_capteur, String source,
				String position, String evenement_name) {
			super();
			this.id_capteur = id_capteur;
			this.source = source;
			this.position = position;
			this.evenement_name = evenement_name;
		}
		public String getId_capteur() {
			return id_capteur;
		}
		public void setId_capteur(String id_capteur) {
			this.id_capteur = id_capteur;
		}
		public String getEvenement_name() {
			return evenement_name;
		}
		public void setEvenement_name(String evenement_name) {
			this.evenement_name = evenement_name;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
		
	}
	
	private HashMap<Integer,Ref> INCIDENTS;
	private HashMap<Integer,LocalisationCapteur> CAPTEURS;

	public ReferenceTab() {
		super();
		INCIDENTS=new HashMap<Integer,Ref>();
		/*
		INCIDENTS.put(0,new Ref("Voyageur malade",1, "0000"));
		INCIDENTS.put(1,new Ref("Suicide", 2, "0001"));
		INCIDENTS.put(2,new Ref("Colis suspec", 3, "0002"));
		INCIDENTS.put(3,new Ref("CapteurAlarme", 4, "0003"));
		INCIDENTS.put(4,new Ref("Incendie", 5, ""));
		INCIDENTS.put(5,new Ref("Inondation", 6, ""));
		INCIDENTS.put(6,new Ref("CapteurNeige", 7, ""));
		INCIDENTS.put(7,new Ref("Portes bloquees", 8, ""));
	    INCIDENTS.put(8,new Ref("Collision", 9, ""));
		INCIDENTS.put(9,new Ref("Manifestation", 10, ""));
		INCIDENTS.put(10,new Ref("Ouverture Porte", 11, "1010"));
		INCIDENTS.put(11,new Ref("Fermeture Porte", 12, "0101"));
		INCIDENTS.put(12,new Ref("Arreter Train", 13, "1100"));
		INCIDENTS.put(13,new Ref("Demarer Train", 14, "0011"));
		*/
		INCIDENTS.put(0,new Ref("CapteurTemperature",1, "0000"));
		INCIDENTS.put(1,new Ref("CapteurInfraRougePorte",2,"0001"));
		INCIDENTS.put(2,new Ref("CapteurPoids",3, "0010"));
		INCIDENTS.put(3,new Ref("CapteurQuai",4, "0011"));
		INCIDENTS.put(4,new Ref("CapteurOxygene",5, "0100"));
		INCIDENTS.put(5,new Ref("CapteurCO2", 6,"0101"));
		INCIDENTS.put(6,new Ref("CapteurPositionTrain",7 ,"0110"));
		
		CAPTEURS=new HashMap<Integer, ReferenceTab.LocalisationCapteur>();

		CAPTEURS.put(0,new LocalisationCapteur("0000000000", "train", "X:1000Y:0000", "CapteurTemperature"));
		CAPTEURS.put(1,new LocalisationCapteur("0100000000", "tunnel", "X:1111Y:0000", "CapteurOxygene"));
		CAPTEURS.put(2,new LocalisationCapteur("0110000000", "train", "X:1000Y:1111", "CapteurPositionTrain"));
		CAPTEURS.put(2,new LocalisationCapteur("0011000000", "station", "X:1000Y:1111", "CapteurQuai"));
		CAPTEURS.put(1,new LocalisationCapteur("0001000000", "train", "X:1111Y:0000", "CapteurInfraRougePorte"));
		CAPTEURS.put(2,new LocalisationCapteur("0101000000", "tunnel", "X:1000Y:1111", "CapteurCO2"));
		CAPTEURS.put(2,new LocalisationCapteur("0010000000", "train", "X:1000Y:1111", "CapteurPoids"));
		/*
		CAPTEURS.put(0,new LocalisationCapteur("CapteurTemperature", "train", "X:10000Y:00000", "CapteurTemperature"));
		CAPTEURS.put(1,new LocalisationCapteur("CapteurOxygene", "tunnel", "X:11111Y:00000", "CapteurOxygene"));
		CAPTEURS.put(2,new LocalisationCapteur("CapteurPositionTrain", "train", "X:10000Y:11111", "CapteurPositionTrain"));
		CAPTEURS.put(2,new LocalisationCapteur("CapteurQuai", "station", "X:10000Y:11111", "CapteurQuai"));
		CAPTEURS.put(1,new LocalisationCapteur("CapteurInfraRougePorte", "train", "X:11111Y:00000", "CapteurInfraRougePorte"));
		CAPTEURS.put(2,new LocalisationCapteur("CapteurCO2", "tunnel", "X:10000Y:11111", "CapteurCO2"));
		CAPTEURS.put(2,new LocalisationCapteur("CapteurPoids", "train", "X:10000Y:11111", "CapteurPoids"));
	 */
		
	}
	public String getidcapteur_to_incident(String s)
	{
		for(int i = 0; i < INCIDENTS.size(); i++) {
			
			if (s.equals(INCIDENTS.get(i).getName_evenment())) {
					return INCIDENTS.get(i).getId_capteur();
			}
		}
		return "";
			
	}
	public String getidcapteur_to_incident(int cp)
	{
			for(int i = 0; i < INCIDENTS.size(); i++) {
			
			if (cp==INCIDENTS.get(i).getId_evenement()) {
					return INCIDENTS.get(i).getId_capteur();
			}
		}
			return "";
	}
	public String getposition_to_idcapteur(String s)
	{
		for(int i = 0; i < CAPTEURS.size(); i++) {
			
			if (s.equals(CAPTEURS.get(i).getId_capteur())) {
					return CAPTEURS.get(i).getPosition();
			}
		}
			return "";
	}
	
	public String getevenement_name_to_idcapteur(String s)
	{
		
		for(int i = 0; i < INCIDENTS.size(); i++) {
			
			if (s.equals(INCIDENTS.get(i).getId_capteur())) {
					return INCIDENTS.get(i).getName_evenment();
			}
		}
			return "";
	}
	public String getidcapteur_to_evenementname(String s)
	{
		for(int i = 0; i < CAPTEURS.size(); i++) {
			
			if (s.equals(CAPTEURS.get(i).getEvenement_name())) {
					return CAPTEURS.get(i).getId_capteur();
			}
		}
			return "";
	}
	public Integer getcode_evenement_to_evenementname(String s)
	{
		for(int i = 0; i < INCIDENTS.size(); i++) {
			
			if (s.equals(INCIDENTS.get(i).getName_evenment())) {
					return INCIDENTS.get(i).getId_evenement();
			}
		}
			return -1;
	}
	public String getidcapteur_to_position(String position)
	{
		for(int i = 0; i < CAPTEURS.size(); i++) {
			
			if (position.equals(CAPTEURS.get(i).getPosition())) {
					return CAPTEURS.get(i).getId_capteur();
			}
		}
			return "";
	}
	public String getname_evenement_to_code(int code)
	{
		for(int i = 0; i < INCIDENTS.size(); i++) {
			
			if (code==INCIDENTS.get(i).getId_evenement()) {
					return INCIDENTS.get(i).getName_evenment();
			}
		}
			return "";
	}
}
