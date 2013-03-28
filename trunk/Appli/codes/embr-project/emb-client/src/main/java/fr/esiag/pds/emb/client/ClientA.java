package fr.esiag.pds.emb.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.esiag.isidis.gestionLigne.EffecteurLigne;
import org.esiag.isidis.gestionRame.EffecteurRame;
import org.esiag.isidis.gestionRame.Rame;
import org.esiag.isidis.outils.Position;
import org.esiag.isidis.terrain.Trajectoire;

import com.esiag.pds.datasource.RandomSource;
import com.esiag.pds.messagegenerator.messagehelper.Simulateur;
import com.esiag.pds.messagegenerator.messagehelper.Transformer;
import com.esiag.pds.messagegenerator.messages.MessageModel;

public class ClientA {

public static final int port=30001;
	
	public static void main(String[] args) {
	try {
		
		Socket socket=new Socket("192.168.0.23", port);
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
					        
				    		Thread.sleep(1000);
					
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
