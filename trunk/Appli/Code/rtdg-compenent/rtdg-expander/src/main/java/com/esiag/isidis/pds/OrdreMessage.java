package com.esiag.isidis.pds;

public class OrdreMessage {
	
	private String SOURCE_VALUE; //  source  train
	private String SENSOR_TYPE_VALUE;  //position
	private String SENSOR_NUM_VALUE;// position  idcapteur 
	private String CRIT_VALUE; //crititce
	private String DATA_TYPE_VALUE;// "Ordre"
	private String DATA_INDICATION;
	private String DATA_VALUE;//code;
	
	
	
	public OrdreMessage(String sOURCE_VALUE, String sENSOR_TYPE_VALUE,
			String sENSOR_NUM_VALUE, String cRIT_VALUE, String dATA_TYPE_VALUE,
			String dATA_INDICATION, String dATA_VALUE) {
		super();
		SOURCE_VALUE = sOURCE_VALUE;
		SENSOR_TYPE_VALUE = sENSOR_TYPE_VALUE;
		SENSOR_NUM_VALUE = sENSOR_NUM_VALUE;
		CRIT_VALUE = cRIT_VALUE;
		DATA_TYPE_VALUE = dATA_TYPE_VALUE;
		DATA_INDICATION = dATA_INDICATION;
		DATA_VALUE = dATA_VALUE;
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
	public String getDATA_TYPE_VALUE() {
		return DATA_TYPE_VALUE;
	}
	public void setDATA_TYPE_VALUE(String dATA_TYPE_VALUE) {
		DATA_TYPE_VALUE = dATA_TYPE_VALUE;
	}
	public String getDATA_INDICATION() {
		return DATA_INDICATION;
	}
	public void setDATA_INDICATION(String dATA_INDICATION) {
		DATA_INDICATION = dATA_INDICATION;
	}
	public String getDATA_VALUE() {
		return DATA_VALUE;
	}
	public void setDATA_VALUE(String dATA_VALUE) {
		DATA_VALUE = dATA_VALUE;
	}
	@Override
	public String toString() {
		return "OrdreMessage [SOURCE_VALUE=" + SOURCE_VALUE
				+ ", SENSOR_TYPE_VALUE=" + SENSOR_TYPE_VALUE
				+ ", SENSOR_NUM_VALUE=" + SENSOR_NUM_VALUE + ", CRIT_VALUE="
				+ CRIT_VALUE + ", DATA_TYPE_VALUE=" + DATA_TYPE_VALUE
				+ ", DATA_INDICATION=" + DATA_INDICATION + ", DATA_VALUE="
				+ DATA_VALUE + "]";
	}
	@Override
	public boolean equals(Object obj) {
		
		OrdreMessage obj1=(OrdreMessage)obj;
		if (SOURCE_VALUE.equals(obj1.getSOURCE_VALUE()) && SENSOR_TYPE_VALUE.equals(obj1.getSENSOR_TYPE_VALUE()) && SENSOR_NUM_VALUE.equals(obj1.getSENSOR_NUM_VALUE()) && CRIT_VALUE.equals(obj1.getCRIT_VALUE()) && DATA_VALUE.equals(obj1.getDATA_VALUE())) {
			return true;
		}
		return false;
	}
	
}
