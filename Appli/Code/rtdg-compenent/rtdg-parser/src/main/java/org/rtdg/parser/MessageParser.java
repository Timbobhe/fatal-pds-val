package org.rtdg.parser;


import java.util.HashMap;






public class MessageParser {
	
	
	private HashMap<String,String> TYPE_SENSOR;
	private HashMap<String,String> ID_SENSOR_TYPE;
	private HashMap<String,String> DATA_MESSAGE;

	
	
	public MessageParser(){
		initialize();
	}
	
	
	public void initialize(){
		/**
		 * initialis� temporairement pour tester
		 */
		TYPE_SENSOR=new HashMap<String,String>();
		TYPE_SENSOR.put("00","Train");
		TYPE_SENSOR.put("01","Tunnel");
		TYPE_SENSOR.put("10","Rail");
		TYPE_SENSOR.put("11","Station");
		
		ID_SENSOR_TYPE=new HashMap<String,String>();
		ID_SENSOR_TYPE.put("0000","CapteurTemperature");
		ID_SENSOR_TYPE.put("0001","CapteurInfraRougePorte");
		ID_SENSOR_TYPE.put("0010","CapteurPoids");
		ID_SENSOR_TYPE.put("0011","CapteurQuai");
		ID_SENSOR_TYPE.put("0100","CapteurOxygene");
		ID_SENSOR_TYPE.put("0101","CapteurCO2");
		ID_SENSOR_TYPE.put("0110","Capteurdeposition");

		
		
		DATA_MESSAGE=new HashMap<String,String>();
		DATA_MESSAGE.put("0000000001", "porte ouverte");
		
	}
	
	
	
	public ParsedMessage parse(SplitedMessage sp)
	{
		
		/**
		 * on r�cup�re la source de message		
		 */
		 String source = TYPE_SENSOR.get(transformToBinary(sp.getTYPE_MESSAGE()));
		 String id_Source =sp.getID_SOURCE();
		
		/**
		 * on Slpite l'id de capteur : ID= type+num�ro
		 * type: sur 4 bits
		 * num�ro : sur 6 bits
		 */
		 String ID_TYPE = transformToBinary(sp.getID_MESSAGE()).substring(0,4);
		 String ID_NUM =transformToBinary(sp.getID_MESSAGE()).substring(4,10);
		
		/**
		 * On r�cup�re le type de capteur � partir de r�f�rentiel
		 */
		// String sensorType = ID_SENSOR_TYPE.get(ID_TYPE);
		 String sensorType = ID_TYPE;
		/**
		 * On r�cup�re la criticit� 
		 * indication:
		 * 00:intellegent
		 * 01:non intellegent
		 */
		 String crit ;
		 
		 if(transformToBinary(sp.getCRIT_MESSAGE()).equals("01"))
			crit="intellegent";
		 else 
			crit="nonIntellegent";
			
		/**
		 * On r�cup�re la donn�e de message	
		 * cas : donn�es = indication et data:false ou true
		 */
		 String value;
		 String indication;
		 if(transformToBinary(sp.getVALUE_MESSAGE()).equals("00")){
			value=transformToBinary(sp.getDATA_MESSAGE()).substring(5, 10);
				if(value.equals("000001"))
					value="true";
				else
					value="false";
				indication =DATA_MESSAGE.get(transformToBinary(sp.getDATA_MESSAGE()));
				
			return  new ParsedMessage(source,id_Source,sensorType,ID_NUM,crit,indication,value);
		}
		
		/**
		 * donn�e=valeur num�rique
		 */
		else if(transformToBinary(sp.getVALUE_MESSAGE()).equals("10")){
			indication="position";
			String x = (transformToBinary(sp.getDATA_MESSAGE())).substring(0, 5);
			String y=	(transformToBinary(sp.getDATA_MESSAGE())).substring(5, 10);
			String pos = "(X: "+x+", Y: "+y + ")";
			return new ParsedMessage(source,id_Source,sensorType,ID_NUM,crit,indication,pos);
		}
		else if(transformToBinary(sp.getVALUE_MESSAGE()).equals("01")){
			indication="numérique";
			int val = Integer.parseInt(transformToBinary(sp.getDATA_MESSAGE()),2);
			return new ParsedMessage(source,id_Source,sensorType,ID_NUM,crit,indication,val);
		}
		System.out.println("null parsed message");
		return null;
									
		
	}
	
	/**
	 * Transforme la forme de lachaine de byte vers binaire
	 * @param value
	 * @return
	 */
	public String transformToBinary(String value){
		String tmp = value.replace("48", "0");
		String binary= tmp.replace("49", "1");
		return binary;
	}

}
