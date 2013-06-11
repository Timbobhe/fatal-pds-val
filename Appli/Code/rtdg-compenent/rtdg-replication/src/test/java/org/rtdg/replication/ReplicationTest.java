package org.rtdg.replication;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ReplicationTest {

	Replication replication;

	@Before
	public void setUp() throws Exception {
		replication = new Replication();
	}

	@Test
	public void testAbonement() {

		String ip = "198.187.3.9";
		try {
			replication.abonement(ip);
			Assert.assertTrue(replication.getIps().contains(ip));

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testDesabonement() {
		String ip = "123.787.57.8";
		replication.getIps().add(ip);
		try {
			Assert.assertTrue(replication.getIps().contains(ip));

			replication.desabonnement(ip);
			Assert.assertTrue(!replication.getIps().contains(ip));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveIP() {
		String ip = "123.787.57.8";
		replication.getIps().add(ip);
		try {
			Assert.assertTrue(replication.getIps().contains(ip));
			replication.removeIP(ip);
			Assert.assertTrue(!replication.getIps().contains(ip));

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testIsMaster() {
		String ip = "198.168.1.1";
		replication.getIps().add(ip);
		System.out.println(replication.getIps());
		try {

			boolean result = replication.isMaster(ip);
			Assert.assertTrue(result);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}