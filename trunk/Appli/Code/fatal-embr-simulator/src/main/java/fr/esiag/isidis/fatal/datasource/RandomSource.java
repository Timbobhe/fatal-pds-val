package fr.esiag.isidis.fatal.datasource;

import java.util.HashMap;
import java.util.Random;

import fr.esiag.isidis.fatal.datasource.tables.CapteurIntelligent;
import fr.esiag.isidis.fatal.datasource.tables.CapteurSource;
import fr.esiag.isidis.fatal.datasource.tables.SourceEquippement;
import fr.esiag.isidis.fatal.datasource.tables.Type;
import fr.esiag.isidis.fatal.datasource.tables.Value;

public class RandomSource implements Source{
	
	private HashMap<String, SourceEquippement> sourcesEquipements;
	private HashMap<String, CapteurSource> capteursSources;
	private HashMap<String, Type> types;
	private HashMap<String, CapteurIntelligent> capteursIntelligent;
	private HashMap<String, Value> refCriticite;
	private String[] keys;
	
	public RandomSource() {
		initializeSourcesEquipements(4);
		initializeCapteursSources(8);
		initializeTypes(3);
		initializeCapteursIntelligents(2);
		initializeRefCriticite(10);
	}
	
	private void initializeRefCriticite(int taille) {
		refCriticite = new HashMap<String, Value>(taille);
		refCriticite.put("0000", new Value(60, 90));
		refCriticite.put("0010", new Value(850, 900));
		refCriticite.put("0100", new Value(0, 20));
		refCriticite.put("0101", new Value(0, 20));
	}

	private void initializeSourcesEquipements(int taille){
		sourcesEquipements = new HashMap<String, SourceEquippement>(taille);
		sourcesEquipements.put("Train", new SourceEquippement("I01", "00"));
		sourcesEquipements.put("Tunnel", new SourceEquippement("I02", "01"));
		sourcesEquipements.put("Rail", new SourceEquippement("I03", "10"));
		sourcesEquipements.put("Station", new SourceEquippement("I04", "11"));
	}

	private void initializeCapteursSources(int taille){
		capteursSources = new HashMap<String, CapteurSource>(taille);
		capteursSources.put("CapteurTemperature", new CapteurSource("00", "0000", "01", "00"));
		capteursSources.put("CapteurInfraRougePorte", new CapteurSource("00", "0001", "00", "00"));
		capteursSources.put("CapteurPoids", new CapteurSource("00", "0010", "01", "00"));
		capteursSources.put("CapteurQuai", new CapteurSource("11", "0011", "00", "00"));
		capteursSources.put("CapteurOxygene", new CapteurSource("00", "0100", "01", "00"));
		capteursSources.put("CapteurCO2", new CapteurSource("00", "0101", "01", "00"));
		keys = new String[]{"CapteurTemperature", "CapteurInfraRougePorte"
				,"CapteurPoids", "CapteurQuai", "CapteurOxygene", "CapteurCO2"};
	}
	
	private void initializeTypes(int taille){
		types = new HashMap<String, Type>(taille);
		types.put("Boolean", new Type("I01", "00"));
		types.put("Numerique", new Type("I02", "01"));
		types.put("Position", new Type("I03", "10"));
	}
	
	private void initializeCapteursIntelligents(int taille){
		capteursIntelligent = new HashMap<String, CapteurIntelligent>(taille);
		capteursIntelligent.put("NonIntelligent", new CapteurIntelligent("I01", "00"));
		capteursIntelligent.put("Intelligent", new CapteurIntelligent("I02", "01"));
		
	}
	//a resoudre
	public int randomizeValueOfData(int lenght){
		Random random = new Random();
		int index = random.nextInt(lenght);
		//System.out.println("index: " + index + " lenght: " + (tab.length-1));
		return index;
	}
	
	public String generateStream(int index){
		String key = keys[index];
		CapteurSource capteurSource = capteursSources.get(key);
		String source = capteurSource.getSource();
		String idSource = "00000000";
		String captSourceId = capteurSource.getCapteurSourceId();
		String idCaptSourceId = "000000";
		String type = capteurSource.getType();
		String capIntel = capteurSource.getCapteurIntelligent();
		String data = generateData(type, captSourceId);
		return (source + idSource + captSourceId + idCaptSourceId 
		+type + capIntel + data);
	}
	
	private int generateValueOfNumerique(int min, int max){
		Random random = new Random();
		int value = min + random.nextInt(max - min);
		return value;
	}
	private String validateLenght(String s, int lenght){
		int j = lenght - s.length();
		String add = "";
		for(int i = 0; i < j; i++){
			add = add + "0";
		}
		return add + s;
	}
	private String generateData(String type, String idCapteur){
		String data = "";
		if(type.equals("00")){
			return data = idCapteur + "000001";
		}
		else
		if(type.equals("01")){
			Value value = refCriticite.get(idCapteur);
			int valueNumerique = generateValueOfNumerique(value.getMin(), value.getMax());
			String s = Integer.toBinaryString(valueNumerique);
			return validateLenght(s, 10);
		}
		
		return data;
	}
	
	public HashMap<String, Value> getRefCriticite() {
		return refCriticite;
	}

	public void setRefCriticite(HashMap<String, Value> refCriticite) {
		this.refCriticite = refCriticite;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

	public HashMap<String, SourceEquippement> getSourcesEquipements() {
		return sourcesEquipements;
	}

	public void setSourcesEquipements(
			HashMap<String, SourceEquippement> sourcesEquipements) {
		this.sourcesEquipements = sourcesEquipements;
	}

	public HashMap<String, CapteurSource> getCapteursSources() {
		return capteursSources;
	}

	public void setCapteursSources(HashMap<String, CapteurSource> capteursSources) {
		this.capteursSources = capteursSources;
	}

	public HashMap<String, Type> getTypes() {
		return types;
	}

	public void setTypes(HashMap<String, Type> types) {
		this.types = types;
	}

	public HashMap<String, CapteurIntelligent> getCapteursIntelligent() {
		return capteursIntelligent;
	}

	public void setCapteursIntelligent(
			HashMap<String, CapteurIntelligent> capteursIntelligent) {
		this.capteursIntelligent = capteursIntelligent;
	}
	
	
	
}
