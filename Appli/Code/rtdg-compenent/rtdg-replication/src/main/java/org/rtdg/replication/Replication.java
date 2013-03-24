package org.rtdg.replication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.Vector;

import org.rtdg.parser.ParsedMessage;
import org.rtdg.prioriser.BufferManager;





public class Replication extends UnicastRemoteObject implements IReplicateRemote{
	
	private static Vector<String> ips=new Vector<String>();
	public static Context context;
	private String id;	
	
	
	public Replication() throws RemoteException {
		super();
		
	}
	

	@Override
	public void abonement(String ip) throws RemoteException {
		for (int i = 0; i < ips.size(); i++) {
			if(ips.get(i).equals(ip))
				return;
		}
		ips.add(ip);
		
		for(int i = 0; i < ips.size(); i++) {
			if(System.getSecurityManager() == null){
				System.out.println("security abonement "+ip);
				System.setProperty("java.security.policy", "settings/java.policy");
			}
			IReplicateRemote gcr=null;
			try{
				System.out.println("serveur abonner de l'ip suivante: "+ip);
				String r = "rmi://"+ips.get(i)+":1099/gca" ;
				gcr= (IReplicateRemote) Naming.lookup(r);
				gcr.abonement(InetAddress.getLocalHost ().getHostAddress ());
				gcr.abonement(ip);
			}
			catch(Exception e){
				
			}
		}
	}

	@Override
	public void desabonnement(String ip) throws RemoteException {
		removeIP(ip);
		for(int i = 0; i < ips.size(); i++) {
			if(System.getSecurityManager() == null){
				System.out.println("security des");
				System.setProperty("java.security.policy", "settings/java.policy");
			}
			IReplicateRemote gcr=null;
			try{
				System.out.println("cache des "+ips.get(i));
				String r = "rmi://"+ips.get(i)+":1099/gca" ;
				gcr= (IReplicateRemote) Naming.lookup(r);
				gcr.removeIP(ip);
			}
			catch(Exception e){
				
			}
		}
		if(System.getSecurityManager() == null){
			System.out.println("security");
			System.setProperty("java.security.policy", "settings/java.policy");
		}
		IReplicateRemote gcr=null;
		try{
			System.out.println("cache");
			String r = "rmi://"+getServerList()+":1099/gca" ;
			gcr= (IReplicateRemote) Naming.lookup(r);
			/*
			for(int i = 0; i < getCaches().size(); i++){
				gcr.putInCache(getCaches().elementAt(i));
			}
			*/
			
		}
		catch(Exception e){
			
		}
	}

	@Override
	public void init(String path) throws RemoteException {
		//load configuration
	}

	

	@Override
	public void initContext() throws RemoteException {
		
	}

	@Override
	public Vector<String> getServerList() throws RemoteException {
		return ips;
	}

	@Override
	public Thread enpanne(final String ip) throws RemoteException {
		Thread hook = new Thread(){
			public void run(){
				try {
					desabonnement(ip);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		return hook;
	}

	@Override
	public Context getContext() throws RemoteException {
		context=new Context();
		return context;
	}

	@Override
	public void setContext(Context context) throws RemoteException {
		this.context=context;
		
	}

	@Override
	public void removeIP(String ip) throws RemoteException {
		for (int i = 0; i < ips.size(); i++) {
			if(ips.get(i).equals(ip))
			{
				ips.remove(i);
				return;
			}
		}
	}

	@Override
	public boolean isMaster(String ip) throws RemoteException{
		if(ip.equals(ips.elementAt(0)) == true)return true;
		return false;
	}

	@Override
	public int getIndexMaster() throws RemoteException{
		return 0;
	}



	@Override
	public void seConnecter(String ipMaster) throws RemoteException{
		if(System.getSecurityManager() == null){
			System.out.println("security");
			System.setProperty("java.security.policy", "settings/java.policy");
		}
		IReplicateRemote gcr=null;
		try{
			String r = "rmi://"+ipMaster+":1099/gca" ;
			 gcr= (IReplicateRemote) Naming.lookup(r);
			 System.out.println("HostAdresse : "+InetAddress.getLocalHost ().getHostAddress().toString());
			 gcr.abonement(InetAddress.getLocalHost ().getHostAddress());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Vector<String> getIps(){
		return ips;
	}

	public static void setIps(Vector<String> ips) {
		Replication.ips = ips;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addMessage(ParsedMessage e) throws RemoteException {
		
		System.out.println("***********************************************");
		context.getBufferManager().add(e);	
		System.out.println("le nombre de messsage " +context.getBufferManager().getBuf3().size());
	}
	@Override
	public void addMessage(ParsedMessage e,String ipsource) throws RemoteException {
		boolean arret=false;
		String iplocale="";
		
		try {
			iplocale = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (isMaster(ipsource)) {
			for (int i = 0; i < ips.size(); i++) {
				if (ips.get(i).equals(ipsource)==false) {
					if(System.getSecurityManager() == null){
						System.setProperty("java.security.policy", "settings/java.policy");
					}
					IReplicateRemote gcr=null;
					try{
						System.out.println("la donner est envoyé au serveur : "+ips.get(i));
						String r = "rmi://"+ips.get(i)+":1099/gca" ;
						gcr= (IReplicateRemote) Naming.lookup(r);
						gcr.addMessage(e);
					}
					catch(Exception ee){
					}
				}
			}
		}
		else{
			if(System.getSecurityManager() == null){
				System.setProperty("java.security.policy", "settings/java.policy");
			}
			IReplicateRemote gcr=null;
			try{
				System.out.println("la donner est envoyé au master : " + this.ips.elementAt(0));
				String r = "rmi://"+this.ips.elementAt(0).toString()+":1099/gca" ;
				gcr= (IReplicateRemote) Naming.lookup(r);
				gcr.addMessage(e);
				gcr.addMessage(e, ips.elementAt(0).toString());
			}
			catch(Exception ee){
			}
		}
		
	}

}
