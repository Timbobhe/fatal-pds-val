package com.esiag.pds.source;

public class Source {
	
	private int nbrMessages;
	private DataSource dataSource;
	
	public Source(int nbrMessages, DataSource dataSource) {
		this.nbrMessages = nbrMessages;
		this.dataSource = dataSource;
	}
	public int getNbrMessages() {
		return nbrMessages;
	}
	public void setNbrMessages(int nbrMessages) {
		this.nbrMessages = nbrMessages;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
