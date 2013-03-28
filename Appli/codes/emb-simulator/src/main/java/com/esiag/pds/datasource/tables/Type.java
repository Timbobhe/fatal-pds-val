package com.esiag.pds.datasource.tables;

public class Type {
	private String idType;
	private String value;
	public Type(String idType, String value) {
		super();
		this.idType = idType;
		this.value = value;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Type [idType=" + idType + ", value=" + value + "]";
	}
	
	
}
