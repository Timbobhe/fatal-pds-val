package org.rtdg.prioriser;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.TreeMap;

import org.hibernate.Session;
import org.rtdg.parser.ParsedMessage;
import org.rtdg.prioriser.dao.CriticiteValueDao;
import org.rtdg.prioriser.db.SessionDB;

public class BufferManager extends Observable implements Serializable {

	private static BufferManager buffermanager;
	private MessageBuffer bufCritique;
	private MessageBuffer bufNonCritique;
	private MessageBuffer bufCache;
	// private Traducteur trad;
	private TreeMap<String, CriticiteValue> tab1;

	public MessageBuffer getbuffer(String name) {
		MessageBuffer bm = new MessageBuffer(name);
		if (name.equals("Critique")) {

			for (int i = 0; i < bufCritique.size(); i++) {
				bm.add(bufCritique.get(i));
			}
		}
		if (name.equals("Non Critique")) {

			for (int i = 0; i < bufNonCritique.size(); i++) {
				bm.add(bufNonCritique.get(i));

			}
		}
		if (name.equals("Cache")) {

			for (int i = 0; i < bufCache.size(); i++) {
				bm.add(bufCache.get(i));
			}
		}

		return bm;

	}

	public static BufferManager getinstance() {
		if (buffermanager == null) {

			buffermanager = new BufferManager();
		}
		return buffermanager;
	}

	private BufferManager() {
		super();
		bufCritique = new MessageBuffer("Critique");
		bufNonCritique = new MessageBuffer("Non Critique");
		bufCache = new MessageBuffer("Cache");
		tab1 = new TreeMap<String, CriticiteValue>();
		// trad= new Traducteur();
		initialize();

	}

	public void initialize() {
	/*	SessionDB.init();
		List<CriticiteValue> criticiteValues = CriticiteValueDao.list();
		for (CriticiteValue criticiteValue : criticiteValues) {
			tab1.put(criticiteValue.getSensorType(), criticiteValue);
		}
		SessionDB.close();
		*/
		CriticiteValue cv_temp = new CriticiteValue("80", 10.0);
		CriticiteValue cv_oxy = new CriticiteValue("10", 5.0);
		CriticiteValue cv_co2 = new CriticiteValue("10", 5.0);
		CriticiteValue cv_poid = new CriticiteValue("1000", 100.0);
		cv_temp.setSensorType("CapteurTemperature");    //0000= CapteurTemperature
		cv_oxy.setSensorType("CapteurOxygene");
		cv_co2.setSensorType("CapteurCO2");
		cv_poid.setSensorType("CapteurPoids");
		//for (CriticiteValue criticiteValue : criticiteValues) {
			tab1.put("CapteurTemperature", cv_temp);
			tab1.put("CapteurOxygene", cv_oxy);
			tab1.put("CapteurCO2", cv_co2);
			tab1.put("CapteurPoids", cv_poid);
			
		//}
		
	}

	public TreeMap<String, CriticiteValue> getTab1() {
		return tab1;
	}

	public void add(ParsedMessage pm) {
		System.out.println("//"+pm);
		setChanged();
		notifyObservers(pm);
	}

	public MessageBuffer getBufCritique() {
		return bufCritique;
	}

	public void setBufCritique(MessageBuffer buf1) {
		this.bufCritique = buf1;
	}

	public MessageBuffer getBufNonCritique() {
		return bufNonCritique;
	}

	public void setBufNonCritique(MessageBuffer buf2) {
		this.bufNonCritique = buf2;
	}

	public MessageBuffer getBufCache() {
		return bufCache;
	}

	public void setBufCache(MessageBuffer buf3) {
		this.bufCache = buf3;
	}

	public void setTab1(TreeMap<String, CriticiteValue> tab1) {
		this.tab1 = tab1;
	}

	public Boolean validattype(ParsedMessage m) {
		if (m.getDATA_INDICATION() != null) {
			return true;

		}
		return false;
	}

	public void afficher() {
		System.out.println("-------------------------------------"
				+ bufCritique.getName());
		for (ParsedMessage m : bufCritique) {
			System.out.println(m);
		}

		System.out.println("-----------------------------------------"
				+ bufNonCritique.getName());
		for (ParsedMessage m : bufNonCritique) {
			System.out.println(m);
		}
		System.out.println("-----------------------------------------"
				+ bufCache.getName());

		for (ParsedMessage m : bufCache) {
			System.out.println(m);
		}

	}

	public void update() {
		super.setChanged();
		super.notifyObservers();
	}

}