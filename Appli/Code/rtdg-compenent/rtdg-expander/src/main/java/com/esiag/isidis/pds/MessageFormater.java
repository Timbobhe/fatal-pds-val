package com.esiag.isidis.pds;

import java.util.HashMap;

public class MessageFormater {
	
	
	private String SOURCE="";
	private int CODE_TYPE_EVENEMENT;
	private String POSITION="";
	//private String VALUE="";
	private int CRITICITE;
	
	private HashMap<String,Integer> INCIDENTS;
	private HashMap<String,Integer> POSITIONS;
	
	public MessageFormater() {
		initialize();
	}
	
	@Override
	public String toString() {
		return "MessageFormater [SOURCE=" + SOURCE + ", CODE_TYPE_EVENEMENT="
				+ CODE_TYPE_EVENEMENT + ", POSITION=" + POSITION
				+ ", CRITICITE=" + CRITICITE + "]";
	}


	public void initialize(){
		INCIDENTS=new HashMap<String,Integer>();
		//INCIDENTS.put("Voyageur malade",1);
		//INCIDENTS.put("Suicide",2);
		//INCIDENTS.put("Colis suspect",3);
		INCIDENTS.put("CapteurAlarme",4);
		//INCIDENTS.put("Incendie",5);
		//INCIDENTS.put("Inondation",6);
		INCIDENTS.put("CapteurNeige",7);
		INCIDENTS.put("Portes bloquees",8);
		//INCIDENTS.put("Collision",9);
		//INCIDENTS.put("Manifestation",10);
		
		//POSITIONS=new HashMap<String,Integer>();
		
		
		
	}
	
	public MessageFormater(String sOURCE, int cODE_TYPE_EVENEMENT,
			String pOSITION, int cRITICITE) {
		super();
		SOURCE = sOURCE;
		CODE_TYPE_EVENEMENT = cODE_TYPE_EVENEMENT;
		POSITION = pOSITION;
		CRITICITE = cRITICITE;
	}





	public String getSOURCE() {
		return SOURCE;
	}

	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}

	public int getCODE_TYPE_EVENEMENT() {
		return CODE_TYPE_EVENEMENT;
	}

	public void setCODE_TYPE_EVENEMENT(int cODE_TYPE_EVENEMENT) {
		CODE_TYPE_EVENEMENT = cODE_TYPE_EVENEMENT;
	}

	public String getPOSITION() {
		return POSITION;
	}

	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}

	public int getCRITICITE() {
		return CRITICITE;
	}

	public void setCRITICITE(int cRITICITE) {
		CRITICITE = cRITICITE;
	}

	public HashMap<String, Integer> getINCIDENTS() {
		return INCIDENTS;
	}

	public void setINCIDENTS(HashMap<String, Integer> iNCIDENTS) {
		INCIDENTS = iNCIDENTS;
	}

	public HashMap<String, Integer> getPOSITIONS() {
		return POSITIONS;
	}

	public void setPOSITIONS(HashMap<String, Integer> pOSITIONS) {
		POSITIONS = pOSITIONS;
	}

	@Override
	public boolean equals(Object obj) {
		
		MessageFormater obj1=(MessageFormater)obj;
		if (SOURCE.equals(obj1.getSOURCE()) && POSITION.equals(obj1.getPOSITION()) && CODE_TYPE_EVENEMENT==obj1.getCODE_TYPE_EVENEMENT() && CRITICITE==obj1.getCRITICITE( )) {
			return true;
		}
		return false;
	}
	
	

}
