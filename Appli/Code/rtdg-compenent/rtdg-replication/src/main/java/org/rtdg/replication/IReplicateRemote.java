package org.rtdg.replication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import org.rtdg.parser.ParsedMessage;



public interface IReplicateRemote extends Remote{
	public String getId()throws RemoteException;
	public void abonement(String ip)throws RemoteException;
	public void desabonnement(String ip)throws RemoteException;
	public void seConnecter(String ipMaster)throws RemoteException;
	public void init(String path)throws RemoteException;
	public void addMessage(ParsedMessage e,String ipsource)throws RemoteException;
	public void addMessage(ParsedMessage e)throws RemoteException;
	public void initContext(/*Vector<CacheIDiscovery> caches*/)throws RemoteException;
	public Vector<String> getServerList()throws RemoteException;
	public Thread enpanne(final String ip)throws RemoteException;
	public Context getContext()throws RemoteException;
	public void setContext(Context context)throws RemoteException;
	public void removeIP(String ip)throws RemoteException;
	public boolean isMaster(String ip)throws RemoteException;
	public int getIndexMaster()throws RemoteException;
}
