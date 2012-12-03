package com.pds.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.jms.JMSException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.pds.connectionActiveMq.ConnectionActiveMQProducer;
import com.pds.connectionBase.ConnectionBaseService;
import com.pds.services.InformationsServices;
import com.pds.traitement.ResponseMessage;
import com.pds.traitement.TraitementsService;

/**
 * 
 * @author Hamza
 * 		s cette classe va recuperer l'information depuis la base de
 *         donnée et va se traiter en appelant la methode distante via le
 *         webserviice
 */
public class ClientService {
	/**
	 * 
	 * @param args
	 * @throws MalformedURLException
	 * @throws SQLException
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws MalformedURLException,
			SQLException, JMSException {
		URL url = new URL("http://localhost:8888/InformationsServices?wsdl");
		QName qName = new QName("http://services.pds.com/",
				"InformationsServicesImplService");
//
		Service service = Service.create(url, qName);
		InformationsServices objet = service
				.getPort(InformationsServices.class);
//
		ConnectionBaseService c = new ConnectionBaseService();
		String s = c.getinfoRequest(c.connect());
//
		TraitementsService t = new TraitementsService();
		ResponseMessage rep = new ResponseMessage();
		
		String messAMQ=(t.traitementmessage(s)).getMsg();
		
		System.out.println(messAMQ);
		ConnectionActiveMQProducer capMQ=new ConnectionActiveMQProducer();
		capMQ.envoiMessageMQ(messAMQ);

		System.out.print(objet.getInformation(s));
	}
}
