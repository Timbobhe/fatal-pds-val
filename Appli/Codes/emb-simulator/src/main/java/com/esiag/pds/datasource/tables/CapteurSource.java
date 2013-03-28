package com.esiag.pds.datasource.tables;

public class CapteurSource {
	private String source;
	private String capteurSourceId;
	private String type;
	private String capteurIntelligent;
	
	public CapteurSource() {
		// TODO Auto-generated constructor stub
	}

	public CapteurSource(String source, String capteurSource, String type,
			String capteurIntelligent) {
		super();
		this.source = source;
		this.capteurSourceId = capteurSource;
		this.type = type;
		this.capteurIntelligent = capteurIntelligent;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	public String getCapteurSourceId() {
		return capteurSourceId;
	}

	public void setCapteurSourceId(String capteurSourceId) {
		this.capteurSourceId = capteurSourceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapteurIntelligent() {
		return capteurIntelligent;
	}

	public void setCapteurIntelligent(String capteurIntelligent) {
		this.capteurIntelligent = capteurIntelligent;
	}
	
}
