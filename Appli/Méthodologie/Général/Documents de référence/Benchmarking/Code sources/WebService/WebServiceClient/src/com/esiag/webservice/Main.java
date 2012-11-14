package com.esiag.webservice;

import java.net.URL;
import java.util.Timer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import client.IWebService;
import client.Produit;
import client.StringArray;



public class Main {

	
	public Main()
	{
		try {
			 URL url=new URL("http://localhost:8888/WebServiceServeur?wsdl");
				QName qname=new QName("http://webservice.esiag.com/","ServiceService");
				Service service=Service.create(url, qname);
				IWebService proxy=service.getPort(IWebService.class);
				
				/*
				
				// Appel de Methode Insertion de 100000 element dans la base de donnees
				
				long start = System.currentTimeMillis();

				for (int i = 0; i <100000 ; i++) {
					
					Produit p=new Produit();
					p.setReference("C0"+i);
					p.setDesignation("Clavier");
					p.setQuantite(10);
					p.setPrix(100);
					System.out.println(proxy.ajouter(p));
					
				}
				 long end = System.currentTimeMillis();
				 System.out.println( "Temps :"+(end-start)+" ms");
				
				
				*/
				// Appel a la Methode Select sur les elements
				/*
				long start = System.currentTimeMillis();
				
				
				System.out.println(proxy.get("C025480").getDesignation());
				
				long end = System.currentTimeMillis();
				 System.out.println( "Temps :"+(end-start)+" ms");
				 */
				 /*
				
				// Appel a la methode update
				
				
				long start = System.currentTimeMillis();
				
				StringArray  tab= new StringArray();
				
				tab.getItem().add("C01");
				tab.getItem().add("Driss");
				tab.getItem().add("10");
				tab.getItem().add("105");
				proxy.update("Produit", "Ref", "C01",tab);
				
				long end = System.currentTimeMillis();
				 System.out.println( "Temps :"+(end-start)+" ms");
				*/
				
				//Appel a la methode delete
				
				
				long start = System.currentTimeMillis();
				
				
				proxy.delete("Produit", "Ref", "C02");
				
				long end = System.currentTimeMillis();
				 System.out.println( "Temps :"+(end-start)+" ms");
				 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		new Main();

	}

}
