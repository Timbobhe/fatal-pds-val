package fr.esiag.isidis.fatal.messagegenerator.messagehelper;

import fr.esiag.isidis.fatal.messagegenerator.messages.MessageModel;



public interface MessageHelper {
	byte[] transformeMessageToByte(MessageModel message);
	byte[] transformeMessageToByte(Transformer messageModel);
	MessageModel transformeByteToMessage(byte[] data);
	MessageModel generateStream();
}
