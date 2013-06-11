package org.rtdg.server;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.ServiceUnavailableException;

import org.rtdg.replication.Context;
import org.rtdg.replication.IReplicateRemote;
import org.rtdg.replication.Replication;

public class ReplicationServeur {

	private String ipmaster=PingPDS.ADRESSES[0];
	private IReplicateRemote clientReplicate ;
	
	public ReplicationServeur()
	{
		
		serverRmi();
		client(ipmaster);
	}
	
	

	public  void serverRmi() {
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "settings/java.policy");
		}
		
		try {
			IReplicateRemote ireplicateRemote = new Replication();
			//ireplicateRemote.init("file");
			Registry r = LocateRegistry.createRegistry(1099);
			r.rebind("gca", ireplicateRemote);
			//recup�rer le contexte du Master
			System.out.println("server de l'adresse :" + InetAddress.getLocalHost().getHostAddress() + "  est bien démmaré");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void client(String ipMaster){
		if(System.getSecurityManager() == null){
			System.out.println("security");
			System.setProperty("java.security.policy", "settings/java.policy");
		}
		if (PingPDS.ping(ipmaster)) {
		try{
			 String r = "rmi://"+ipMaster+":1099/gca" ;
			 System.out.println("r : " + r);
			 clientReplicate= (IReplicateRemote) Naming.lookup(r);
			 clientReplicate.abonement(InetAddress.getLocalHost ().getHostAddress());
			 System.out.println("driss : "+InetAddress.getLocalHost ().toString());
			 if (InetAddress.getLocalHost().getHostAddress().toString().equals(ipMaster)==false) {
				System.out.println("Le serveur :"+ InetAddress.getLocalHost ().getHostAddress()+ " recupére le context du Master");
				Replication.context=clientReplicate.getContext();
				System.out.println("La taille du contexte récupére est : "+Replication.context.getBufferManager().getBufCache().size());
				//PingPDS.next=-1;
			}
			 else{
				 System.out.println("C'est moi Le Master de l'adresse suivante: " + ipMaster);
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			//int cp=PingPDS.setnext();
			String ipValide = PingPDS.ipMasterValide();
			if (ipValide != "") {
				client(ipValide);
			}
			else
			{
				System.out.println("Il n'y a aucun serveur enregistré qui est démarré");
			}
		}
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
	
	public String getIpmaster() {
		return ipmaster;
	}

	public void setIpmaster(String ipmaster) {
		this.ipmaster = ipmaster;
	}

	public IReplicateRemote getClientReplicate() {
		return clientReplicate;
	}

	public void setClientReplicate(IReplicateRemote clientReplicate) {
		this.clientReplicate = clientReplicate;
	}
}
