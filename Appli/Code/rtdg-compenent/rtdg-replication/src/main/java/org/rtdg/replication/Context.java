package org.rtdg.replication;


import java.io.Serializable;

import org.rtdg.prioriser.BufferManager;


public class Context implements Serializable{
	
	private BufferManager bufferManager;
	public Context() {
		bufferManager=BufferManager.getinstance();
		
	}
	

	public BufferManager getBufferManager() {
		return bufferManager;
	}


	public void setBufferManager(BufferManager bufferManager) {
		this.bufferManager = bufferManager;
	}


	public void loadContext(){
		//charger les contextes � partir de parser
	}

	
	
}
