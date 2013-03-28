package org.rtdg.prioriser;

import java.io.Serializable;


public class CriticiteValue implements Serializable{

	private String value;
	private Double equartype;
	
	public CriticiteValue(String value, Double equartype) {
		super();
		this.value = value;
		this.equartype = equartype;
	}
	public CriticiteValue() {
		super();
	
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Double getEquartype() {
		return equartype;
	}
	public void setEquartype(Double equartype) {
		this.equartype = equartype;
	}
	
	
}