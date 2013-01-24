package com.esiag.pds.composantembarquer.helper.structure;

import com.esiag.pds.composantembarquer.helper.MessageHelper;
import com.esiag.pds.message.MessageModel;

public class BinaryMessage implements MessageHelper{

	private MessageReferntiel messageReferntiel;
	
	public BinaryMessage() {
		messageReferntiel = new MessageReferntiel();
		messageReferntiel.initializeCapteurs();
		messageReferntiel.initializeCriticites();
		messageReferntiel.initializeSources();
		messageReferntiel.initializeTypes();
	}
	
	@Override
	public byte[] transformeMessageToByte(MessageModel message) {
		String s = MessageModelToChaine(message);
		return chaineToBinary(s);
	}

	@Override
	public MessageModel transformeByteToMessage(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public byte[] chaineToBinary(String s){
		byte[] tab = new byte[s.length()];
		byte x;
		for(int i = 0; i < s.length(); i++){
			x = Byte.parseByte(s.charAt(i)+"");
			tab[i] = x;
		}
		return tab;	
	}
	
	//il manque l'id generer et data 
	public String MessageModelToChaine(MessageModel m){
		StringBuffer sb = new StringBuffer();
		//System.out.println(messageReferntiel.getTypes().get("string"));
		sb.append(messageReferntiel.getValue(messageReferntiel.getSources(),
				m.getType()));
		sb.append(messageReferntiel.getValue(messageReferntiel.getCapteurs(),
				m.getId()));
		sb.append("000000");
		sb.append(messageReferntiel.getValue(messageReferntiel.getCriticites(), 
				m.getCrit()));
		sb.append(messageReferntiel.getValue(messageReferntiel.getTypes(), 
				m.getValue()));
		//sb.append(m.getData());
		return sb.toString();
	}

}
