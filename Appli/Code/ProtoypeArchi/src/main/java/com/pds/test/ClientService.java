package com.pds.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.pds.connectionBase.ConnectionBaseService;
import com.pds.services.InformationsServices;
import com.pds.traitement.ResponseMessage;
import com.pds.traitement.TraitementsService;

/**
 * 
 * @author Hamza cette classe va recuperer l'information depuis la base de
 *         donnée et va se traiter en appelant la methode distante via le
 *         webserviice
 */
public class ClientService {
	/**
	 * 
	 * @param args
	 * @throws MalformedURLException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws MalformedURLException,
			SQLException {
		URL url = new URL("http://localhost:8888/InformationsServices?wsdl");
		QName qName = new QName("http://services.pds.com/",
				"InformationsServicesImplService");

		Service service = Service.create(url, qName);
		InformationsServices objet = service
				.getPort(InformationsServices.class);

		ConnectionBaseService c = new ConnectionBaseService();
		String s = c.getinfoRequest(c.connect());

		TraitementsService t = new TraitementsService();
		ResponseMessage rep = new ResponseMessage();
		System.out.println((t.traitementmessage(s)).getMsg());

		System.out.print(objet.getInformation(s));
	}
}
