package org.rtdg.prioriser.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			// Crée la SessionFactory
			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Problème de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
