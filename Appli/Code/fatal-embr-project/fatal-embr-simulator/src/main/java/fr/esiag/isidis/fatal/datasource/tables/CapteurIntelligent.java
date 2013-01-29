package fr.esiag.isidis.fatal.datasource.tables;

public class CapteurIntelligent {
	private String idCapateurIntelligent;
	private String value;
	
	public CapteurIntelligent() {
		// TODO Auto-generated constructor stub
	}

	public CapteurIntelligent(String idCapateurIntelligent, String value) {
		super();
		this.idCapateurIntelligent = idCapateurIntelligent;
		this.value = value;
	}

	public String getIdCapateurIntelligent() {
		return idCapateurIntelligent;
	}

	public void setIdCapateurIntelligent(String idCapateurIntelligent) {
		this.idCapateurIntelligent = idCapateurIntelligent;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CapteurIntelligent [idCapateurIntelligent="
				+ idCapateurIntelligent + ", value=" + value + "]";
	}
	
	
}
