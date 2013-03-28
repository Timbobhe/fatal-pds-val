package org.esiag.isidis.gestionLigne;

/**
* @author Jadoui sabri
*donne deux point pour dessiner une ligne
*/

public class Ligne 
{
	
	    /** Abscisse du debut de la ligne */
	    private int oldx;
	    /** Ordonnee du debut de la ligne */
	    private int oldy;
	    /** Abscisse de la fin de la ligne */
	    private int x;
	    /** Ordonnee de la fin de la ligne */
	    private int y;
	    
	    /**
	     * Creates a new instance of Ligne 
	     * @param oldx l'abscisse du debut de la ligne
	     * @param oldy l'ordonnee du debut de la ligne
	     * @param x l'abscisse de la fin de la ligne
	     * @param y l'ordonnee de la fin de la ligne
	     */
	    public Ligne(int oldx, int oldy, int x, int y) 
	    {
	        this.oldx=oldx;
	        this.oldy=oldy;
	        this.x=x;
	        this.y=y;
	    }
	    
	    /**
	     * Accede a l'abscisse du debut de la ligne
	     * @return l'abscisse du debut de la ligne
	     */
	    public int getOldx(){
	        return oldx;        
	    }
	    
	    /**
	     * Accede a l'ordonnee du debut de la ligne
	     * @return l'ordonnee du debut de la ligne
	     */
	    public int getOldy(){
	        return oldy;
	    }
	    
	    /**
	     * Accede a l'abscisse de la fin de la ligne
	     * @return l'abscisse de la fin de la ligne
	     */
	    public int getX(){
	        return x;
	    }
	    
	    /**
	     * Accede a l'ordonnee de la fin de la ligne
	     * @return l'ordonnee de la fin de la ligne
	     */
	    public int getY(){
	        return y;
	    }
	    
	    public void setX(int x){
	    	this.x=x;
	    }
	    
	    public void setY(int y){
	    	this.y=y;
	    }
	    
	    public void setOldX(int x){
	    	this.oldx=x;
	    }
	    
	    public void setOldY(int y){
	    	this.oldy=y;
	    }
	    
	    
	    
	}



