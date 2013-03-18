package org.rtdg.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.rtdg.analyser.BinaryMessage;
import org.rtdg.analyser.MessageAnalyser;
import org.rtdg.parser.MessageParser;
import org.rtdg.parser.SplitedMessage;
import org.rtdg.prioriser.BufferManager;
import org.rtdg.server.frontal.ViewInformation;


public class ServeurThread  extends Thread{

	private Socket socket=null;
	public ObjectOutputStream oos; 
	public ObjectInputStream ois; 
	private BufferManager bm;
	private ViewInformation view;
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
		System.out.println("Serveur ==> "+m.toString());
		MessageAnalyser ma = new MessageAnalyser();
		BinaryMessage binMessage =new BinaryMessage();
		
		for (int i = 0; i < m.length; i++) {
			binMessage.add(m[i]);
		}

		SplitedMessage sp=ma.analyseMessage(binMessage);

		MessageParser mp = new MessageParser();
		org.rtdg.parser.ParsedMessage pm=mp.parse(sp);
	

		bm.add(pm);
		bm.update();
		if(view==null){
			 view = new ViewInformation(bm);
		}
		bm.afficher();


		
	}
	
	
	
}
