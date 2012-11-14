package com.esiag.webservice;

import javax.xml.ws.Endpoint;

public class Main {

	public static final String URL="http://localhost:8888/WebServiceServeur";
	public Main()
	{
		Service service=new Service();
		Endpoint endpoint=Endpoint.publish(URL,service);
		Boolean status=endpoint.isPublished();
		System.out.println("WebService disponible est :"+status);
		
	}
	public static void main(String[] args) {
		new Main();
		
	}

}
