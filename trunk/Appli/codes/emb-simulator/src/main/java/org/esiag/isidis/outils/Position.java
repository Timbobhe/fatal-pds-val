package org.esiag.isidis.outils;

import java.io.Serializable;

/**
* @author Jadoui sabri 
*donne une position caracterisé par un x et un y
*/

public class Position implements Serializable{
	


	/** L'abscisse de la position  */
    private int x;
    /** L'ordonne de la position */
    private int y;
    
    
    /**
     * construit une instance de type position
     * @param x c'est l'abscisse de la position 
     * @param y c'est l'ordonne de la position
     */
    public Position(int x, int y){
        this.x=x;
	this.y=y;
    }
    
	public Position() {
		super();
 	}
    
    /**
     * Accede a l'abscisse de la position 
     * @return l'abscisse de la position 
     */
	
    public int getX(){
        return x;
    }
    
    /**
     * Accede a l'ordonne de la position 
     * @return l'ordonne de la position 
     */
    public int getY(){
	return y;
    }
	
    /**
     * Modifie l'abscisse de la position 
     * @param x est le nouveau abscisse de la position 
     */
    public void setX(int x){
        this.x=x;
    }
	
    /**
     * Modifie l'ordonne de la position 
     * @param y est le nouveau ordonne de la position 
     */
    public void setY(int y){
        this.y=y;
    }
        
    /**
     * Redefini la methode toString de la super classe Object
     * @return sous forme d'une chaine de caractere l'abscisse et l'odonnŽ 
     */
  
    public String toString(){
        return "("+x+", "+y+")";
    }
}



