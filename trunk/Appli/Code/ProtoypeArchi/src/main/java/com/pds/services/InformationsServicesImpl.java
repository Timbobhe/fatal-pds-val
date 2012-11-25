package com.pds.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author Hamza
 * 
 */
@WebService(endpointInterface = "com.pds.services.InformationsServices")
public class InformationsServicesImpl implements InformationsServices {

	@Override
	@WebMethod
	/**
	 * 
	 */
	public String getInformation(String nomComposant) {
		return "Information reçu :  " + nomComposant;
	}
}
