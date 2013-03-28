package org.rtdg.analyser;


import java.util.Vector;

public class BinaryMessage extends Vector<Byte> {
	
	
	
	
	/** Cr�e une trame vide**/
	public BinaryMessage(){
		
		
	}
	
	/** Ajoute de bytes � partire dun tableau de byte **/
	public void add(byte[] byteArray){
		for(byte b : byteArray)
			    add(b);
			
	}
	
	/** Retourne un tableau de byte, la trame convertie en tableau de byte **/
	public byte[] toByteArray(){
		byte tab [] = new byte[this.size()];
		for(int i=0 ; i< tab.length ; i++){
			tab[i] = this.get(i) ;
		}	
	
		return tab;
	}
	

	
	
	

}
