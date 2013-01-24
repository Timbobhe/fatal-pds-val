package com.esiag.pds.CollecteInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static final int port=12345;
	
	public static void main(String[] args) {
	try {
		
		Socket socket=new Socket("localhost", 4137);
		ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		oos.writeObject("Driss ");
		MessageReader mr = new MessageReader();
		while (true) {
			// insertion du generateur de message
						BinaryMessage bm = new BinaryMessage();
						mr.read(bm);
						//Message msg=new Message("Driss", "krafess", 10);
						oos.writeObject(bm);
					
						BinaryMessage retour=(BinaryMessage)ois.readObject();
					//	System.out.println(retour.toString());
					
		}
		
			
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
}
