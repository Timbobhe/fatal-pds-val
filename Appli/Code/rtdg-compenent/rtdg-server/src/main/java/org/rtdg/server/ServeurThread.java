package org.rtdg.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.rtdg.analyser.BinaryMessage;
import org.rtdg.analyser.MessageAnalyser;
import org.rtdg.parser.MessageParser;
import org.rtdg.parser.SplitedMessage;
import org.rtdg.prioriser.BufferManager;
import org.rtdg.replication.IReplicateRemote;
import org.rtdg.replication.Replication;
import org.rtdg.server.frontal.ViewInformation;


public class ServeurThread  extends Thread{

	private Socket socket=null;
	private String ipmaster=PingPDS.ADRESSES[0];
	public ObjectOutputStream oos; 
	public ObjectInputStream ois; 
	private BufferManager bm;
	private ViewInformation view;
	private IReplicateRemote clientReplicate ;
	static long i=1;
	private String name;
	public ServeurThread(Socket socket,IReplicateRemote rp) {
		this.socket=socket;
		 bm =BufferManager.getinstance();
		 clientReplicate=rp;
		// server();
		// client(ipmaster);
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
				try {
					DoSomething(msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	public void DoSomething(byte[] m) throws Exception
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
		String ipLocale="";
		try {
			ipLocale = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("---------------------------------"+clientReplicate.getServerList().size());
		System.out.println(PingPDS.next+"next");
		if (ipmaster.equals(ipLocale) && PingPDS.isreplicate==true) {
			System.out.println("------master c moi");
			clientReplicate.addMessage(pm,ipmaster);
		}
		if(PingPDS.isreplicate==true && ipmaster.equals(ipLocale)==false )
		{
		//notifie le master
			System.out.println("master c pas moi");
				clientReplicate.addMessage(pm,ipLocale);
		}
		
		bm.update();
		if(view==null){
			 view = new ViewInformation(bm);
		}
		bm.afficher();


		
	}
	public boolean ping(String s)
	{
		try {
			 InetAddress addresses = InetAddress.getByName(s);
			  if (addresses.isReachable(4000))
		         return true;
			  else
				 return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	
}
