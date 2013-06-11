package org.rtdg.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Vector;


public  class PingPDS {

	public static String[] ADRESSES=new String[]{"localhost","",""};
 	public static int next=-1;
	public static Boolean isreplicate=false;
	public static String ipMaster = "";
	/*public static int setnext()
	{
		if (next>=ADRESSES.length-1) {
			isreplicate=false;
			return -1;
		}
		isreplicate=true;
		next=next+1;
		return next;
	}*/
	public static boolean ping(String s)
	{
		try {
			 InetAddress addresses = InetAddress.getByName(s);
			  if (addresses.isReachable(4000))
		         return true;
			  else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String ipMasterValide(){
		for(int i = 0; i < ADRESSES.length; i++){
			if(ping(ADRESSES[i]) == true){
				permute(ADRESSES[0], ADRESSES[i]);
				ipMaster = ADRESSES[0];
				return ipMaster;	
			}
		}
		return "";
	}
	
	public static void permute(String ipValide, String ip1){
		String tmp = "";
		tmp = ipValide;
		ipValide = ip1;
		ip1 = tmp;
	}
	
	/*public static String[] Read(String fichier)
	{
		String chaine="";
		String[] tab=new String[0];
		Vector<String > tab1=new Vector<String>();
	
		try {
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				chaine+=ligne+"\n";
				tab1.add(chaine);
				
			}
			br.close(); 
			//ADRESSES=new String[tab1.size()];
			tab1.toArray(ADRESSES);
			System.out.println("000000"+ADRESSES[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tab;
	}*/

	
	

}
