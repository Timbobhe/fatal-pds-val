package com.esiag.pds.CollecteInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurThread  extends Thread{

	private Socket socket=null;
	public ObjectOutputStream oos; 
	public ObjectInputStream ois; 
	static long i=1;
	private String name;
	public ServeurThread(Socket socket) {
		this.socket=socket;
	}

	public void run() {
		
		BinaryMessage msg=null;
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
			
			while ((msg=(BinaryMessage)ois.readObject())!=null) {
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
	public void DoSomething(BinaryMessage m)
	{
		//System.out.println("Serveur ==> "+m.toString());
		MessageAnalyser ma = new MessageAnalyser();
		System.out.println("message : "+ma.analyseMessage(m));
		try {
			this.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
