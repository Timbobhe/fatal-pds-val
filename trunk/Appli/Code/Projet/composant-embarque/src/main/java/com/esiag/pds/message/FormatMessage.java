package com.esiag.pds.message;

public class FormatMessage {
	private String[] type;
	private String[] idCapteur;
	private String[] criticite;
	private String[] value;
	
	public FormatMessage() {
		// TODO Auto-generated constructor stub
	}
	public void initialize(){
		type = new String[]{"Train", "Tunnel", "Rail", "Station"};
		idCapteur = new String[]{"capteurTemperature", "capteurVitesse"
				, "capteurInfraRougePorte", "capteurOxygene", "capteurCO2"
				, "capteurPressionDesPneus", "capteurDistanceAvant"
				, "capteurPoids", "capteurTemperatureDesPneus"
				, "capteurPoids", "capteurQuai", "capteurMotrice"};
		criticite = new String[]{"nonCritique", "critique"};
		value = new String[]{"boolean", "numerique", "string"};
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String[] getIdCapteur() {
		return idCapteur;
	}

	public void setIdCapteur(String[] idCapteur) {
		this.idCapteur = idCapteur;
	}

	public String[] getCriticite() {
		return criticite;
	}

	public void setCriticite(String[] criticite) {
		this.criticite = criticite;
	}

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

}
