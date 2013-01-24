package com.esiag.pds.message;

import java.util.Random;
import java.util.Vector;

public class MessageRandom {
	private FormatMessage formatMessage;
	private Vector<MessageModel> messages;
	private int nbrMessageRandom;

	public MessageRandom(FormatMessage formatMessage, int nbrMessageRandom) {
		this.formatMessage = formatMessage;
		this.nbrMessageRandom = nbrMessageRandom;
		messages = new Vector<MessageModel>();
		MessageModel messageModel;
		for(int i = 0; i < nbrMessageRandom; i++){
			messageModel = new MessageModel();
			messageModel.setCrit(get(formatMessage.getCriticite()));
			messageModel.setId(get(formatMessage.getIdCapteur()));
			messageModel.setType(get(formatMessage.getType()));
			messageModel.setValue(get(formatMessage.getValue()));
			messages.add(messageModel);
		}
	}

	public Vector<MessageModel> getMessages() {
		return messages;
	}

	public void setMessages(Vector<MessageModel> messages) {
		this.messages = messages;
	}

	public FormatMessage getFormatMessage() {
		return formatMessage;
	}

	public void setFormatMessage(FormatMessage formatMessage) {
		this.formatMessage = formatMessage;
	}


	public String get(String[] tab){
		Random random = new Random();
		int index = random.nextInt(tab.length);
		//System.out.println("index: " + index + " lenght: " + (tab.length-1));
		return tab[index].toString();
	}


	public int getNbrMessageRandom() {
		return nbrMessageRandom;
	}
	
	public MessageModel getMessage(int index){
		//System.out.println(messages.elementAt(index));
		return messages.elementAt(index);
	}
	
	public void print(){
		for(int i = 0; i < messages.size(); i++){
			System.out.println(messages.get(i));
			//getMessage(i);
		}
	}
	
	
}
