package com.pds.traitement;

/**
 * 
 * @author Hamza
 * 
 */
public class TraitementsService {
	/**
	 * 
	 * @param message
	 *            : le msg � traiter
	 * @return : la reponse du traitement
	 */
	public ResponseMessage traitementmessage(String message) {
		ResponseMessage msg = new ResponseMessage();
		msg.setMsg(message + " en train de se trait�");
		return msg;
	}
}
