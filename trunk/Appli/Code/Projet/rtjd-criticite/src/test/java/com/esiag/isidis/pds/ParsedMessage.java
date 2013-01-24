package com.esiag.isidis.pds;

public class ParsedMessage  {
	
	private String SOURCE_VALUE;
	private String SENSOR_TYPE_VALUE;
	private String SENSOR_NUM_VALUE;
	private String CRIT_VALUE;
	private String DATA_TYPE_VALUE;
	private String DATA_INDICATION;
	private int DATA_VALUE;
	
	public ParsedMessage(String sOURCE_VALUE, String sENSOR_TYPE_VALUE,
			String sENSOR_NUM_VALUE, String cRIT_VALUE,String dATA_TYPE_VALUE, String dATA_INDICATION
			) {
		super();
		SOURCE_VALUE = sOURCE_VALUE;
		SENSOR_TYPE_VALUE = sENSOR_TYPE_VALUE;
		SENSOR_NUM_VALUE = sENSOR_NUM_VALUE;
		CRIT_VALUE = cRIT_VALUE;
		DATA_TYPE_VALUE=dATA_TYPE_VALUE;
		DATA_INDICATION = dATA_INDICATION;
	}
	


	public ParsedMessage(String sOURCE_VALUE, String sENSOR_TYPE_VALUE,
		String sENSOR_NUM_VALUE, String cRIT_VALUE,String dATA_TYPE_VALUE,
		int dATA_VALUE) {
		super();
		SOURCE_VALUE = sOURCE_VALUE;
		SENSOR_TYPE_VALUE = sENSOR_TYPE_VALUE;
		SENSOR_NUM_VALUE = sENSOR_NUM_VALUE;
		CRIT_VALUE = cRIT_VALUE;
		DATA_TYPE_VALUE=dATA_TYPE_VALUE;
		DATA_VALUE = dATA_VALUE;
}
	
	public String getDATA_TYPE_VALUE() {
		return DATA_TYPE_VALUE;
	}

	public void setDATA_TYPE_VALUE(String dATA_TYPE_VALUE) {
		DATA_TYPE_VALUE = dATA_TYPE_VALUE;
	}
	
	public String getSOURCE_VALUE() {
		return SOURCE_VALUE;
	}

	public void setSOURCE_VALUE(String sOURCE_VALUE) {
		SOURCE_VALUE = sOURCE_VALUE;
	}

	public String getSENSOR_TYPE_VALUE() {
		return SENSOR_TYPE_VALUE;
	}

	public void setSENSOR_TYPE_VALUE(String sENSOR_TYPE_VALUE) {
		SENSOR_TYPE_VALUE = sENSOR_TYPE_VALUE;
	}

	public String getSENSOR_NUM_VALUE() {
		return SENSOR_NUM_VALUE;
	}

	public void setSENSOR_NUM_VALUE(String sENSOR_NUM_VALUE) {
		SENSOR_NUM_VALUE = sENSOR_NUM_VALUE;
	}

	public String getCRIT_VALUE() {
		return CRIT_VALUE;
	}

	public void setCRIT_VALUE(String cRIT_VALUE) {
		CRIT_VALUE = cRIT_VALUE;
	}

	public String getDATA_INDICATION() {
		return DATA_INDICATION;
	}

	public void setDATA_INDICATION(String dATA_INDICATION) {
		DATA_INDICATION = dATA_INDICATION;
	}

	public int getDATA_VALUE() {
		return DATA_VALUE;
	}

	public void setDATA_VALUE(int dATA_VALUE) {
		DATA_VALUE = dATA_VALUE;
	}
	
	
	public  String toString(){
		String indication;
		if(DATA_INDICATION==null)
			indication="Pas d'indication pour ce message";
			else
				indication=DATA_INDICATION;
		
		return "Parsed Message :" +
				"source message : ["+SOURCE_VALUE+"]\n" +
						"type sensor : [" +SENSOR_TYPE_VALUE+"]\n"+
						"numero sensor : [" +SENSOR_NUM_VALUE+"]\n"+
						"criticit� value : [" +CRIT_VALUE+"]\n"+
						"type data : ["+DATA_TYPE_VALUE+"]\n" +
						"indication: [" +indication+"]\n"+
						"value data:["+DATA_VALUE+"]\n";
		
		
	}


	
	
	

}
