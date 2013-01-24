package com.esiag.pds.source;

import java.util.Vector;

import com.esiag.pds.message.FormatMessage;
import com.esiag.pds.message.MessageModel;
import com.esiag.pds.message.MessageRandom;


public class RandomSource implements DataSource{
	
	private FormatMessage formatMessage;
	private MessageRandom messageRandom;
	
	public RandomSource() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector<MessageModel> generateMessage(int nbrMessagesGeneres) {
		FormatMessage fm = new FormatMessage();
		fm.initialize();
		MessageRandom mr = new MessageRandom(fm, nbrMessagesGeneres);
		return mr.getMessages();
	}

	public FormatMessage getFormatMessage() {
		return formatMessage;
	}

	public void setFormatMessage(FormatMessage formatMessage) {
		this.formatMessage = formatMessage;
	}

	public MessageRandom getMessageRandom() {
		return messageRandom;
	}

	public void setMessageRandom(MessageRandom messageRandom) {
		this.messageRandom = messageRandom;
	}
	

	

}
