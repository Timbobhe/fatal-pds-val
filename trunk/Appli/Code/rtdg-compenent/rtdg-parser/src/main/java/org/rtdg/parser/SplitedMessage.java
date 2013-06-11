package org.rtdg.parser;


public class SplitedMessage  {
	
	
	
	private String TYPE_MESSAGE;
	private String ID_SOURCE;
	public String getID_SOURCE() {
		return ID_SOURCE;
	}

	public void setID_SOURCE(String iD_SOURCE) {
		ID_SOURCE = iD_SOURCE;
	}

	private String ID_MESSAGE;
	private String CRIT_MESSAGE;
	private String  VALUE_MESSAGE;
	private String DATA_MESSAGE;
	
	public SplitedMessage(String tYPE_MESSAGE,String ID_SOURCE, String iD_MESSAGE,
			String cRIT_MESSAGE, String vALUE_MESSAGE, String dATA_MESSAGE) {
		super();
		TYPE_MESSAGE = tYPE_MESSAGE;
		this.ID_SOURCE=ID_SOURCE;
		ID_MESSAGE = iD_MESSAGE;
		CRIT_MESSAGE = cRIT_MESSAGE;
		VALUE_MESSAGE = vALUE_MESSAGE;
		DATA_MESSAGE = dATA_MESSAGE;
	}
	
	public String getTYPE_MESSAGE() {
		return TYPE_MESSAGE;
	}
	public void setTYPE_MESSAGE(String tYPE_MESSAGE) {
		TYPE_MESSAGE = tYPE_MESSAGE;
	}
	public String getID_MESSAGE() {
		return ID_MESSAGE;
	}
	public void setID_MESSAGE(String iD_MESSAGE) {
		ID_MESSAGE = iD_MESSAGE;
	}
	public String getCRIT_MESSAGE() {
		return CRIT_MESSAGE;
	}
	public void setCRIT_MESSAGE(String cRIT_MESSAGE) {
		CRIT_MESSAGE = cRIT_MESSAGE;
	}
	public String getVALUE_MESSAGE() {
		return VALUE_MESSAGE;
	}
	public void setVALUE_MESSAGE(String vALUE_MESSAGE) {
		VALUE_MESSAGE = vALUE_MESSAGE;
	}
	public String getDATA_MESSAGE() {
		return DATA_MESSAGE;
	}
	public void setDATA_MESSAGE(String dATA_MESSAGE) {
		DATA_MESSAGE = dATA_MESSAGE;
	}
	
	@Override
	public String toString() {
		return "SplitedMessage [TYPE_MESSAGE=" + TYPE_MESSAGE + ", ID_SOURCE="
				+ ID_SOURCE + ", ID_MESSAGE=" + ID_MESSAGE + ", CRIT_MESSAGE="
				+ CRIT_MESSAGE + ", VALUE_MESSAGE=" + VALUE_MESSAGE
				+ ", DATA_MESSAGE=" + DATA_MESSAGE + "]";
	}
	
	
	

}
