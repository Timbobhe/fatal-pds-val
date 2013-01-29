package fr.esiag.isidis.fatal.datasource;

import java.util.HashMap;

public class DataSource implements Source{
	private HashMap<String, String> sourcesEquipements;
	private HashMap<String, String> idSoucesEquipements;
	private HashMap<String, String> capteursSouces;
	private HashMap<String, String> idCapteursSources;
	private HashMap<String, String> types;
	private HashMap<String, String> capteurIntelligence;
	
	public DataSource() {
		sourcesEquipements = new HashMap<String, String>(5);
		idSoucesEquipements = new HashMap<String, String>(20);
		capteursSouces = new HashMap<String, String>(20);
		idCapteursSources = new HashMap<String, String>(20);
		types = new HashMap<String, String>(20);
		capteurIntelligence = new HashMap<String, String>(20);
		initializeSoucesEquipements();
		initializeIdSoucesEquipements();
		initializeCapteursSouces();
		initializeIdCapteursSources();
		initializeTypes();
		initializeCapteurIntelligence();
	}

	public HashMap<String, String> getSourcesEquipements() {
		return sourcesEquipements;
	}

	public void setSoucesEquipements(HashMap<String, String> soucesEquipements) {
		this.sourcesEquipements = soucesEquipements;
	}

	public HashMap<String, String> getIdSoucesEquipements() {
		return idSoucesEquipements;
	}

	public void setIdSoucesEquipements(HashMap<String, String> idSoucesEquipements) {
		this.idSoucesEquipements = idSoucesEquipements;
	}

	public HashMap<String, String> getCapteursSouces() {
		return capteursSouces;
	}

	public void setCapteursSouces(HashMap<String, String> capteursSouces) {
		this.capteursSouces = capteursSouces;
	}

	public HashMap<String, String> getIdCapteursSources() {
		return idCapteursSources;
	}

	public void setIdCapteursSources(HashMap<String, String> idCapteursSources) {
		this.idCapteursSources = idCapteursSources;
	}

	public HashMap<String, String> getTypes() {
		return types;
	}

	public void setTypes(HashMap<String, String> types) {
		this.types = types;
	}

	public HashMap<String, String> getCapteurIntelligence() {
		return capteurIntelligence;
	}

	public void setCapteurIntelligence(HashMap<String, String> capteurIntelligence) {
		this.capteurIntelligence = capteurIntelligence;
	}
	
	public void initializeSoucesEquipements(){
		sourcesEquipements.put("Train", "00");
		sourcesEquipements.put("Tunnel", "01");
		sourcesEquipements.put("Rail", "10");
		sourcesEquipements.put("Station", "11");
	}
	
	public void initializeIdSoucesEquipements(){
		
	}
	public String initializeIdSourceEquipement(){
		return "00000000";
	}
	public void initializeCapteursSouces(){
		capteursSouces.put("CapteurTemperature", "0000");
		capteursSouces.put("CapteurInfraRougePorte", "0001");
		capteursSouces.put("CapteurPoids", "0010");
		capteursSouces.put("CapteurQuai", "0011");
		capteursSouces.put("CapteurOxygene", "0100");
		capteursSouces.put("CapteurCO2", "0101");
		capteursSouces.put("CapteurPositionTrain", "0110");
		
	}
	public void initializeIdCapteursSources(){
	
	}
	public String initializeIdCapteurSource(){
		return "000000";
	}
	public void initializeTypes(){
		types.put("Boolean", "00");
		types.put("Numerique", "01");
		types.put("Position", "10");
	}
	public void initializeCapteurIntelligence(){
		capteurIntelligence.put("NonIntelligent", "00");
		capteurIntelligence.put("Intelligent", "01");
	}
	
}
