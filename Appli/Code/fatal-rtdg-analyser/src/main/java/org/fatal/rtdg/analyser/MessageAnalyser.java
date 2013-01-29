package org.fatal.rtdg.analyser;

import org.fatal.rtdg.message.BinaryMessage;

import parser.edu.projet.SplitedMessage;




public class MessageAnalyser {
	
	
	String TYPE_MESSAGE="";
	String ID_SOURCE="";
	String ID_MESSAGE="";
	String CRIT_MESSAGE="";
	String  VALUE_MESSAGE="";
	String DATA_MESSAGE="";
	
	
	public MessageAnalyser(){
	}
	
	
	
	public SplitedMessage analyseMessage(BinaryMessage binMessage){
		
		/**On r�cup�re la source de la trame envoy�e**/
		TYPE_MESSAGE+=binMessage.get(0).toString();
		TYPE_MESSAGE+=binMessage.get(1).toString();
		
		for(int i=2;i<10;i++)
			ID_SOURCE+=binMessage.get(i).toString();
		/**On r�cup�re l'ID de sensor qui a envoy� le message**/
		for(int i=10;i<20;i++)
			ID_MESSAGE+=binMessage.get(i);

		
		/**On recup�re le type des donn�es de message**/
		VALUE_MESSAGE+=binMessage.get(20);
		VALUE_MESSAGE+=binMessage.get(21);
		
		/**On r�cup�re la criticit� de message envoy�**/
		CRIT_MESSAGE+=binMessage.get(22);
		CRIT_MESSAGE+=binMessage.get(23);
		
		
		
		/**On r�cup�re les donn�es**/
		for(int i=24;i<binMessage.size();i++)
			DATA_MESSAGE+=binMessage.get(i);		

		return  new SplitedMessage(TYPE_MESSAGE,ID_SOURCE,ID_MESSAGE,CRIT_MESSAGE,
								   VALUE_MESSAGE,DATA_MESSAGE);
	}

}
