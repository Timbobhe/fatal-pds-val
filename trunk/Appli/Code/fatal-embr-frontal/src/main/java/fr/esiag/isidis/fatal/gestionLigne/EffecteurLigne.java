package fr.esiag.isidis.fatal.gestionLigne;

import java.util.ArrayList;


import fr.esiag.isidis.fatal.gestionStation.Station;
import fr.esiag.isidis.fatal.outils.Position;




/**
* @author Jadoui sabri 
*/

public class EffecteurLigne   implements IEffecteur {
	
	
	
	
	private int  posx;
	 
	private int posy;
	 
	private int posxf;
	
 	private int posyf;
 	
 	private int angle;
	
	private Position position;

	private int distance;
	
	
	private ArrayList<Ligne> listLignes;
	private ArrayList<Station> listStations;
	private int nombreStation;

	
	public EffecteurLigne(int x,int y,int nombreStation )
	{
		position=new Position(x,y);
		angle=0;
		listLignes=new ArrayList<Ligne>();
		listStations= new ArrayList<Station>();
		this.nombreStation=nombreStation;
		distance=150;
		calcul();
	}
	
		
	public void calcul() {
		
		for(int i=0;i<nombreStation;i++){
				
			posx=position.getX();
			posy=position.getY();
			position.setX((int)(posx+Math.cos(Math.toRadians(angle))*distance));
			position.setY((int)(posy+Math.sin(Math.toRadians(angle))*distance));
			posxf=position.getX();
			posyf=position.getY();
			
		Ligne li =new Ligne(posx,posy,posxf,posyf);
		listLignes.add(li);
		listStations.add(new Station("station"+i,new Position(posxf,posyf)));
		
		//System.out.println(" posx="+posx+"; posy= "+posy+" posxf="+posxf+"; posyf= "+posyf+"; angle="+angle) ;


	}
		
			
		//this.changed() ;
		
	}
			
	public ArrayList<Station> getListStations() {
		return listStations;
	}


	public void setListStations(ArrayList<Station> listStations) {
		this.listStations = listStations;
	}


	public int getNombreStation() {
		return nombreStation;
	}


	public void setNombreStation(int nombreStation) {
		this.nombreStation = nombreStation;
	}


	public double getPosx()
	{
		return posx;
		
	}
	
	public double getPosy()
	{
		return posy;
		
	}
	
	public double getPosxf()
	{
		return posxf;
		
	}	
	public double getPosyf()
	{
		return posyf;
		
	}
	
	public double getAngle()
	{
		return angle;
		
	}
	
	public Position getPosition()
	{
		return position;
	}
		

	public ArrayList<Ligne> getLignes()
 	
	{
		return listLignes;
	}		
	
}
