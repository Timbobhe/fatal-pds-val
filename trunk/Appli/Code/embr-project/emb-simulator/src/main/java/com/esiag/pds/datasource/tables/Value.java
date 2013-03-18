package com.esiag.pds.datasource.tables;

public class Value {
	private int min, max;
	public Value() {
		// TODO Auto-generated constructor stub
	}
	public Value(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return "Value [min=" + min + ", max=" + max + "]";
	}
	
}
