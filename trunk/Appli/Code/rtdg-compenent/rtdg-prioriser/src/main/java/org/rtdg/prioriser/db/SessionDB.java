package org.rtdg.prioriser.db;

import org.hibernate.Session;

public class SessionDB {

	private static Session session;

	public static void init() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	public static void close() {
		session.close();
	}

	public static void commit() {
		session.getTransaction().commit();
	}
	
	public static Session getSession() {
		return session;
	}
}
