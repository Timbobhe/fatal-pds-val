package org.fatal.rtdg.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.esiag.isdis.fi.projet.rtdg.message.BinaryMessage;
import org.esiag.isidis.fi.projet.Analyser.MessageAnalyser;

import criticite.edu.projet.BufferManager;

import parser.edu.projet.MessageParser;
import parser.edu.projet.ParsedMessage;
import parser.edu.projet.SplitedMessage;

public class ServeurThread  extends Thread{

	private Socket socket=null;
	public ObjectOutputStream oos; 
	public ObjectInputStream ois; 
	private BufferManager bm;
	static long i=1;
	private String name;
	public ServeurThread(Socket socket) {
		this.socket=socket;
		 bm = new BufferManager();

	}

public void run() {
		
		byte[] msg=null;
		try {
			 ois=new ObjectInputStream(socket.getInputStream());
			 oos=new ObjectOutputStream(socket.getOutputStream());
			
			 String user=(String)ois.readObject();
			 if(user==null)
				{
					socket.close();
				}
			 name=user;
			 System.out.println(user+socket.getInetAddress()+" est Connecte "+i++);
			
			while ((msg=(byte[])ois.readObject())!=null) {
				DoSomething(msg);
				oos.writeObject(msg);
				
			}
			 socket.close();
			
		} catch (IOException io) {
			System.out.println(name+"  "+" s'est deconnecté");
			
		}
		catch (ClassNotFoundException cnf) {
			
			cnf.printStackTrace();
		}
	}
	public void DoSomething(byte[] m)
	{
		String s="";
		MessageAnalyser ma = new MessageAnalyser();
		BinaryMessage binMessage =new BinaryMessage();
		
		for (int i = 0; i < m.length; i++) {
			binMessage.add(m[i]);
		}

		SplitedMessage sp=ma.analyseMessage(binMessage);
		System.out.println(sp);
		
		MessageParser mp = new MessageParser();
		ParsedMessage pm=mp.parse(sp);
		System.out.println("----------------------Debut------------------------");
		System.out.println(pm);
		System.out.println("----------------------Fin------------------------");
		bm.add(pm);
		bm.afficher();
		

		
	}
	
	
	
}
