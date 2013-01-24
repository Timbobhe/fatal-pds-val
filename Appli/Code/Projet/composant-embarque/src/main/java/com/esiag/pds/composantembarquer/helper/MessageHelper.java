package com.esiag.pds.composantembarquer.helper;

import com.esiag.pds.message.MessageModel;




public interface MessageHelper {

	byte[] transformeMessageToByte(MessageModel message);
	MessageModel transformeByteToMessage(byte[] data);
	
}
