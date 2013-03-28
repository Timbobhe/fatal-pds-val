package org.rtdg.replication;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.plaf.SliderUI;

import junit.framework.Assert;

import org.junit.Before;
import org.rtdg.parser.ParsedMessage;
import org.rtdg.prioriser.BufferManager;



public class TestReplication 
{
	private Vector<String> ips;
	private Replication rep;
	
	@Before
	public void init() throws RemoteException {
		ips=new Vector<String>();
		ips.add("192.168.1.1");
		ips.add("192.168.1.2");
		ips.add("192.168.1.3");
		ips.add("192.168.1.4");
		rep=new Replication();
		rep.setIps(ips);
	}
	@org.junit.Test
	public void TestgetServerList() throws RemoteException  {
		System.out.println(rep.getServerList().size());
		Assert.assertEquals(new Integer(rep.getServerList().size()), new Integer(4));
	}
	
	@org.junit.Test
	public void addMessage() throws RemoteException {
		
		Context context=new Context();
		ParsedMessage p=new ParsedMessage("Tunnel", "", "0001", "000000", "critique", "", "");
		rep.context=context;
		rep.addMessage(p);
		rep.getContext().getBufferManager().add(p);
		System.out.println("le nombre de messsage " +context.getBufferManager().getBuf1().size());
		Assert.assertEquals(rep.getContext().getBufferManager().getBuf3().size(), 0);
	}
	
}
