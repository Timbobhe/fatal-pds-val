package com.esiag.isidis.pds;

import java.util.HashMap;

import org.rtdg.parser.ParsedMessage;

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

	public String getPosition(ParsedMessage pm){
		// si le parsedMessage recu est deja une info sur une position
		if(pm.getDATA_TYPE_VALUE()== "position"){
			int x = Integer.parseInt(pm.getDATA_INDICATION().substring(4, 9), 2);
			int y = Integer.parseInt(pm.getDATA_INDICATION().substring(14, 19), 2);
			
			return x+":"+y;
		}
		else{
			/*
			//prendre la derniere position de ce capteur dans le buffer
			BufferManager buf1 = new BufferManager();
			MessageBuffer buf2 = new MessageBuffer("noncritique");
			buf2 = buf1.getBuf2();
			int j= buf2.size();
			boolean found = false;
			for (int i = j; i > 1; i--) {
				if(buf2.get(i).getDATA_TYPE_VALUE()=="position" && buf2.get(i).getSOURCE_VALUE()==pm.getSOURCE_VALUE() && found ==false){
					found = true;
					int x = Integer.parseInt(pm.getDATA_INDICATION().substring(4, 9), 2);
					int y = Integer.parseInt(pm.getDATA_INDICATION().substring(14, 19), 2);
					
					return x+":"+y;
				}
			}
			*/
		}
			
		return null;
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


	public void formatMessage(ParsedMessage pm){
		
		this.SOURCE = pm.getSOURCE_VALUE();		
		this.CODE_TYPE_EVENEMENT = INCIDENTS.get(pm.getSENSOR_TYPE_VALUE());
		this.POSITION = getPosition(pm);
		this.CRITICITE = 1;
		

		
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
	
	

}
