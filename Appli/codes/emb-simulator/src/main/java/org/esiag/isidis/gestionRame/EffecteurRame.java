package org.esiag.isidis.gestionRame;

import java.util.ArrayList;

import org.esiag.isidis.gestionLigne.Ligne;
import org.esiag.isidis.gestionStation.Station;
import org.esiag.isidis.outils.Model;
import org.esiag.isidis.outils.Position;


public class EffecteurRame extends Model  {



	private Position position;

	private ArrayList<Position>listPosition ;
	private ArrayList<Ligne>listLignes;
	private ArrayList<Station>listStations;
	private int retour;
	

	

	public EffecteurRame(ArrayList<Ligne>listLignes,ArrayList<Ligne>listLigneRetour,
			ArrayList<Station>ListStationA,ArrayList<Station>ListStationR)
	{
		position= new Position(-400,1);
		listPosition = new  ArrayList<Position>();
		listStations = new  ArrayList<Station>();
		this.listLignes=listLignes;
		retour=listLignes.size();
		for(int i=listLigneRetour.size()-1;i>=0;i--)
			listLignes.add(listLigneRetour.get(i));
		addStations(ListStationA);
		addStations(ListStationR);

	}



	public void execute() 
	{
			
			 for (int i = 0 ; i < listLignes.size() ; i++){        	
		        	calculPositionLigne(listLignes.get(i),retour);
		        	retour--;           
		       }
			 
			 for(int i=0;i<listPosition.size();i++)
			 {
				 try {
				 position.setX(listPosition.get(i).getX());
				 position.setY(listPosition.get(i).getY());
				 
				 for(Station station:listStations){
					 if(position.getX()==station.getPosition().getX()&&
					 	position.getY()==station.getPosition().getY()){
							Thread.sleep(1000);
					 }
				 }
				
					Thread.sleep(10);
					this.changed() ;
				 
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			 }

	}

	private void calculPositionLigne(Ligne ligne,int retour) {
		
		int a = ((ligne.getOldy()-ligne.getY())/(ligne.getOldx()-ligne.getX()));
		int b = ligne.getY()-a*(ligne.getX());

		if(retour<=0)
			for(int x=ligne.getX();x>ligne.getOldx();x--)
			{
				int y=a*x+b;
				listPosition.add(new Position(x,y));
				
			}
		else
			for(int x=ligne.getOldx();x<ligne.getX();x++)
			{
				int y=a*x+b;
				listPosition.add(new Position(x,y));
			
			}
		
	}


	public Position getPosition()
	{
		return position;
	}
	
	public void addStations(ArrayList<Station>list){
		for(Station station:list)
			listStations.add(station);
	}



}
