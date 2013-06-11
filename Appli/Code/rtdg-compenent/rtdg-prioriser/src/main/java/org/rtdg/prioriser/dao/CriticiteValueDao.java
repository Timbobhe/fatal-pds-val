package org.rtdg.prioriser.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.rtdg.prioriser.CriticiteValue;
import org.rtdg.prioriser.db.SessionDB;

public class CriticiteValueDao {

	public static List<CriticiteValue> list() {
		Session session = SessionDB.getSession();
		String hql = "from CriticiteValue a";

		Query createQuery = session.createQuery(hql);
		List<CriticiteValue> list = createQuery.list();
		return list;
	}

	public static void save(CriticiteValue criticiteValue) {
		SessionDB.getSession().save(criticiteValue);
	}



	public static CriticiteValue getbyId(int id) {
		CriticiteValue criticiteValue = (CriticiteValue) SessionDB.getSession()
				.get(CriticiteValue.class, id);
		return criticiteValue;
	}

}
