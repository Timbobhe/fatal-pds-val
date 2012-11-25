package com.pds.services;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * 
 * @author Hamza
 * 
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface InformationsServices {
	/**
	 * 
	 * @param nomComposant
	 *            : le nom du composant d'ou on obtiendra l'information
	 * @return : l'information
	 */
	public String getInformation(String nomComposant);
}
