package org.rtdg.server.frontal;

import javax.swing.JTable;


public class TableThread extends Thread{
	private JTable infoTable = null;
	private Model bm;

	public TableThread(JTable infoTable,Model bm) {
		super();
		this.infoTable = infoTable;
		this.bm=bm;
	}

	public void run() {
		//TableContent tbm = new TableContent((BufferManager) bm,"cache");
 		//infoTable.setModel(tbm);		

	}

}
