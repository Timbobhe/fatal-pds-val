package fr.esiag.isidis.fatal.generator.client_embarque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import fr.esiag.isidis.fatal.*;
import fr.esiag.isidis.fatal.datasource.RandomSource;
import fr.esiag.isidis.fatal.gestionLigne.EffecteurLigne;
import fr.esiag.isidis.fatal.gestionRame.EffecteurRame;
import fr.esiag.isidis.fatal.gestionRame.Rame;
import fr.esiag.isidis.fatal.messagegenerator.messagehelper.Simulateur;
import fr.esiag.isidis.fatal.messagegenerator.messagehelper.Transformer;
import fr.esiag.isidis.fatal.messagegenerator.messages.MessageModel;
import fr.esiag.isidis.fatal.outils.Position;
import fr.esiag.isidis.fatal.terrain.Trajectoire;


public class Processor {

public static final int port=30001;
	
	public static void main(String[] args) {
	try {
		
		Socket socket=new Socket("localhost", port);
		ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		oos.writeObject("COMPOSANT EMBARQUE ");
		
		while (true) {

					
					EffecteurLigne effA = new EffecteurLigne(-400,1,5);
					
					EffecteurLigne effR = new EffecteurLigne(-400,100,5);
				
				
					EffecteurLigne efftab[] = {effA,effR};
					EffecteurRame effRame = new EffecteurRame(effA.getLignes(),effR.getLignes(),effA.getListStations(),effR.getListStations());
					Rame rame = new Rame("métro 14",effRame);
					Trajectoire tr = new Trajectoire(efftab,rame);
					rame.getEffecteur().addAbonne(tr);
					
					
					Simulateur  simulateur = new Simulateur("Train", 10, 12);
					MessageModel messageModel = new MessageModel();
					RandomSource randomSource = new RandomSource();
			        Position pos =new Position(-399,100);
					Position post=new Position();
					int compteur=0;
					
					 while(!rame.getEtat()){try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}}
					 
				     while(rame.getPosition().getX()!=pos.getX()||
				        		rame.getPosition().getY()!=pos.getY()){
				        	
				        	post=validatePosition(rame.getPosition().getX(),rame.getPosition().getY());	        	
				        	simulateur.setPosXRam(post.getX());
				        	simulateur.setPosYRam(post.getY());
				    		messageModel = simulateur.generateStream();
				    		
				    		if(compteur%10==0){
				
				    			oos.writeObject(testRandom(1,randomSource));
						        System.out.println("Random: "+messageModel);
						        

				    		}
				    		else{
				    			byte[] binaryMessage= Transformer.transformToBinary(messageModel.toString());
						        oos.writeObject(binaryMessage);
						        System.out.println("Position: "+binaryMessage);
						       
						      
				    		}
				    		compteur++;
					        
						
				    		  byte[] retour=(byte[])ois.readObject();
				    		  //System.out.println(retour);
					
				     }}}
		
			
	
	catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
	public static Position validatePosition(int x,int y){
		 
		if(x<0){
			x=x*-1;
			if(x>31){
				x=31;
			}
		}
		if(x>31){
			x=31;
		}
			 
		if(y<0){
			y=y*-1;
			if(y>31){
				y=31;
			}
		}
		if(y>31){
			y=31;
		}
		
		
		return new Position(x,y);
		
		 
	}
	private static byte[] testRandom(int x,RandomSource randomSource) {
		String stream = "";
		for(int i = 0; i < x; i++){
			int value = randomSource.randomizeValueOfData(randomSource.getKeys().length);
			stream = randomSource.generateStream(value);
			byte[] trame = Transformer.transformToBinary(stream);
			return trame;
		}
		return null;
	}
}
