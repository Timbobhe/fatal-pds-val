package com.esiag.pds.message;

public class MessageModel {

	private String type;
	private String id;
	private String crit;
	private String value;
	private String data;
	
	public MessageModel() {
		// TODO Auto-generated constructor stub
	}
	public MessageModel(String type, String id, String crit, String value,
			String data) {
		super();
		this.type = type;
		this.id = id;
		this.crit = crit;
		this.value = value;
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCrit() {
		return crit;
	}
	public void setCrit(String crit) {
		this.crit = crit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MessageModel [type=" + type + ", id=" + id + ", crit=" + crit
				+ ", value=" + value + ", data=" + data + "]";
	}
	
	
	
	
	
}
