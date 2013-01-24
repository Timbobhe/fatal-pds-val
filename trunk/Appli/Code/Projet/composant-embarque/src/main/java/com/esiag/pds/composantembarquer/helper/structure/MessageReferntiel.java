package com.esiag.pds.composantembarquer.helper.structure;

import java.util.HashMap;

public class MessageReferntiel {
	private HashMap<String, String> sources;
	private HashMap<String, String> capteurs;
	private HashMap<String, String> criticites;
	private HashMap<String, String> types;
	private HashMap<String, String> data;
	
	public void initializeSources(){
		sources = new HashMap<String, String>(5);
		sources.put("Train", "00");
		sources.put("Tunnel", "01");
		sources.put("Rail", "10");
		sources.put("Station", "11");
	}
	public void initializeCapteurs(){
		capteurs = new HashMap<String, String>(100);
		capteurs.put("capteurTemperature", "0000");
		capteurs.put("capteurVitesse", "0001");
		capteurs.put("capteurInfraRougePorte", "0010");
		capteurs.put("capteurOxygene", "0011");
		capteurs.put("capteurCO2", "0100");
		capteurs.put("capteurPressionDesPneus", "0101");
		capteurs.put("capteurDistanceAvant", "0110");
		capteurs.put("capteurPoids", "0111");
		capteurs.put("capteurTemperatureDesPneus", "1000");
		capteurs.put("capteurPoids", "1001");
		capteurs.put("capteurQuai", "1010");
		capteurs.put("capteurMotrice", "1011");
	}
	public void initializeCriticites(){
		criticites = new HashMap<String, String>(3);
		criticites.put("nonCritique", "00");
		criticites.put("critique", "01");
	}
	public void initializeTypes(){
		types = new HashMap<String, String>(5);
		types.put("boolean", "00");
		types.put("numerique", "01");
		types.put("string", "10");
	}
	
	public String getValue(HashMap<String, String> h,String key){
		return h.get(key);
	}
	public String initializeData(String value){
		return "";
	}
	public HashMap<String, String> getSources() {
		return sources;
	}
	public void setSources(HashMap<String, String> sources) {
		this.sources = sources;
	}
	public HashMap<String, String> getCapteurs() {
		return capteurs;
	}
	public void setCapteurs(HashMap<String, String> capteurs) {
		this.capteurs = capteurs;
	}
	public HashMap<String, String> getCriticites() {
		return criticites;
	}
	public void setCriticites(HashMap<String, String> criticites) {
		this.criticites = criticites;
	}
	public HashMap<String, String> getTypes() {
		return types;
	}
	public void setTypes(HashMap<String, String> types) {
		this.types = types;
	}
	public HashMap<String, String> getData() {
		return data;
	}
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	
}
