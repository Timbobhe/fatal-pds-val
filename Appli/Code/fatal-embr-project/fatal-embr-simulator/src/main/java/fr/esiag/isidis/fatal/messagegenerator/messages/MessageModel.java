package fr.esiag.isidis.fatal.messagegenerator.messages;

public class MessageModel {
	private String source;
	private String idSource;
	private String capteurSource;
	private String idCapteurSource;
	private String type;
	private String capteurIntelligent;
	private String data;
	
	public MessageModel() {
		// TODO Auto-generated constructor stub
	}

	public MessageModel(String source, String idSource, String capteurSource,
			String idCapteurSource, String type, String capteurIntelligent,
			String data) {
		super();
		this.source = source;
		this.idSource = idSource;
		this.capteurSource = capteurSource;
		this.idCapteurSource = idCapteurSource;
		this.type = type;
		this.capteurIntelligent = capteurIntelligent;
		this.data = data;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIdSource() {
		return idSource;
	}

	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}

	public String getCapteurSource() {
		return capteurSource;
	}

	public void setCapteurSource(String capteurSource) {
		this.capteurSource = capteurSource;
	}

	public String getIdCapteurSource() {
		return idCapteurSource;
	}

	public void setIdCapteurSource(String idCapteurSource) {
		this.idCapteurSource = idCapteurSource;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String generateData(){
		return "";
	}
	@Override
	public String toString() {
		return source + idSource + capteurSource + idCapteurSource + type + capteurIntelligent+ data;
	}
	
}
