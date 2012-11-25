package com.pds.services;

import javax.xml.ws.Endpoint;

/**
 * 
 * @author Hamza @ pour publier le web service
 */
public class InformationsServicesPublish {
	public static final String url = "http://localhost:8888/InformationsServices";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InformationsServicesImpl impl = new InformationsServicesImpl();

		Endpoint endpoint = Endpoint.publish(url, impl);

		// tester la disponibilité de la endPoint
		Boolean status = endpoint.isPublished();
		System.out.println("Web service disponible ? " + status);
	}

}
