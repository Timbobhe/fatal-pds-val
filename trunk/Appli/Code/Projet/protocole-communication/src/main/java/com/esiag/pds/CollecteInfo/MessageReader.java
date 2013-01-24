package com.esiag.pds.CollecteInfo;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReader {
	
	
	public MessageReader(){
		
	}
	
	public void read(BinaryMessage message){
		String fichier ="informations";
		
		try{
			
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			char val;
			String s = "";
			while ((val=(char)br.read())!='F'){
				s = s + val;
				byte value=(byte) val;
				message.add(value);
			}
			br.close(); 
			
			System.out.println("----" + s);
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

}
