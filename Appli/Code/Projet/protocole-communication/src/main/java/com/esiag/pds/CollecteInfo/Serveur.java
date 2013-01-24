package com.esiag.pds.CollecteInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static final int port=4137;
	
	public static void main(String[] args)throws IOException,ClassNotFoundException {
		new Serveur().RunServer();
	}
	public void RunServer()
	{
		ServerSocket serversocket;
		try {
			serversocket = new ServerSocket(port);
			System.out.println("Serveur en attente de Connection ...");
			
			while(true)
			{
			Socket socket=serversocket.accept();
			new ServeurThread(socket).start();
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
