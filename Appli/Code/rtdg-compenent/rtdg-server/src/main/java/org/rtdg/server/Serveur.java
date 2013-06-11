package org.rtdg.server;


import java.io.IOException;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.rtdg.replication.IReplicateRemote;



public class Serveur {

	private static final int port=30001;
	private  static  IReplicateRemote rmt;

	
	

	public static void main(String[] args)throws IOException,ClassNotFoundException {

		/*System.out.println(PingPDS.setnext());
		System.out.println(PingPDS.setnext());
		System.out.println(PingPDS.setnext());
		*/
		
		ReplicationServeur rs=new ReplicationServeur(); // demarer replication
		rmt=rs.getClientReplicate();
		new Serveur().RunServer();    //demarer serveur master	
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
			new ServeurThread(socket,rmt).start();
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
		
	}

