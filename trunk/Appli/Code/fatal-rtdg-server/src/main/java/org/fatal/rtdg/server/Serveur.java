package org.fatal.rtdg.server;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	private static final int port=30001;

	
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

