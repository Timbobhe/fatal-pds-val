package com.esiag.pds.messagegenerator.messagehelper;

import com.esiag.pds.messagegenerator.messages.MessageModel;



public interface MessageHelper {
	byte[] transformeMessageToByte(MessageModel message);
	byte[] transformeMessageToByte(Transformer messageModel);
	MessageModel transformeByteToMessage(byte[] data);
	MessageModel generateStream();
}
