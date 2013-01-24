package com.esiag.pds.CollecteInfo;




public class MessageAnalyser {
	
	
	String TYPE_MESSAGE="";
	String ID_MESSAGE="";
	String CRIT_MESSAGE="";
	String  VALUE_MESSAGE="";
	String DATA_MESSAGE="";
	
	public MessageAnalyser(){
		
	}
	
	
	
	public String analyseMessage(BinaryMessage binMessage){
		
		
		TYPE_MESSAGE+=binMessage.get(0).toString();
		TYPE_MESSAGE+=binMessage.get(1).toString();
		
		
		for(int i=2;i<12;i++)
			ID_MESSAGE+=binMessage.get(i);
			
		
		
		
		CRIT_MESSAGE+=binMessage.get(13);
		CRIT_MESSAGE+=binMessage.get(14);
		
		
		VALUE_MESSAGE+=binMessage.get(15);
		VALUE_MESSAGE+=binMessage.get(16);
		
		
		for(int i=17;i<binMessage.size();i++)
			DATA_MESSAGE+=binMessage.get(i);		
		
		return   "TYPE:["+TYPE_MESSAGE+"]\n"
				+"ID_MESSAGE:["+ID_MESSAGE+"]\n"
				+"CRIT_MESSAGE:["+CRIT_MESSAGE+"]\n"
				+"VALUE_MESSAGE:["+VALUE_MESSAGE+"]\n"
				+"DATA_MESSAGE:["+DATA_MESSAGE+"]\n";
	}

}
