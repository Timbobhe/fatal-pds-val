package com.esiag.pds.source;

import java.util.Vector;

import com.esiag.pds.message.MessageModel;



public interface DataSource {
	public Vector<MessageModel> generateMessage(int nbrMessagesGeneres);
}
