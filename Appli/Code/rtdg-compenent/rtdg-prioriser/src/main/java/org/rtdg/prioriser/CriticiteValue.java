package org.rtdg.prioriser;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "criticiteValue")
public class CriticiteValue implements Serializable {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

//	@Id
//	@GeneratedValue
//	@Column(name = "criticiteValueId")
	private int id;

//	@Column(name = "value")
	private String value;
//	@Column(name = "equartype")
	private Double equartype;

//	@Column(name = "sensorType")
	private String sensorType;

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

	@Override
	public String toString() {
		return "CriticiteValue [value=" + value + ", equartype=" + equartype
				+ "]";
	}

}
