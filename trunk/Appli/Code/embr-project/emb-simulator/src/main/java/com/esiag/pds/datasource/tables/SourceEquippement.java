package com.esiag.pds.datasource.tables;

public class SourceEquippement {
	
	private String idSourceEquipement;
	private String value;
	
	public SourceEquippement(String idSourceEquipement, String value) {
		super();
		this.idSourceEquipement = idSourceEquipement;
		this.value = value;
	}
	public String getIdSourceEquipement() {
		return idSourceEquipement;
	}
	public void setIdSourceEquipement(String idSourceEquipement) {
		this.idSourceEquipement = idSourceEquipement;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "[idSourceEquipement=" + idSourceEquipement
				+ ", value=" + value + "]";
	}
	
}
