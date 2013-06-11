package org.rtdg.prioriser.main;

import java.util.List;
import java.util.TreeMap;

import org.rtdg.parser.ParsedMessage;
import org.rtdg.prioriser.AddToBufferObserver;
import org.rtdg.prioriser.BufferManager;
import org.rtdg.prioriser.CriticiteValue;
import org.rtdg.prioriser.dao.CriticiteValueDao;
import org.rtdg.prioriser.db.SessionDB;

public class Main {

	public static void main(String[] args) {
		//addInfoToBD();
		testAlgo();
	}

	public static void addInfoToBD() {
		SessionDB.init();
		CriticiteValue cv_temp = new CriticiteValue("80", 10.0);
		CriticiteValue cv_oxy = new CriticiteValue("10", 5.0);
		CriticiteValue cv_co2 = new CriticiteValue("10", 5.0);
		CriticiteValue cv_poid = new CriticiteValue("1000", 100.0);
		cv_temp.setSensorType("CapteurTemperature");
		cv_oxy.setSensorType("CapteurOxygene");
		cv_co2.setSensorType("CapteurCO2");
		cv_poid.setSensorType("CapteurPoids");
		CriticiteValueDao.save(cv_temp);
		CriticiteValueDao.save(cv_oxy);
		CriticiteValueDao.save(cv_co2);
		CriticiteValueDao.save(cv_poid);
		SessionDB.commit();
		SessionDB.close();
	}

	public static void testAlgo() {
		ParsedMessage parsedMessage = new ParsedMessage("Station", "00000000",
				"CapteurTemperature", "000000", "nonIntelligent",
				"pas dindication", 85);
		
		ParsedMessage parsedMessage1 = new ParsedMessage("Metro 12",
				"iD_SOURCE", "CapteurTemperature", "sENSOR_NUM_VALUE",
				"nonIntelligent", "dATA_VALUE", "80");
		
		ParsedMessage parsedMessage2 = new ParsedMessage("Metro 1", "iD_SOURCE",
				"Capteurdeposition", "sENSOR_NUM_VALUE", "nonIntelligent",
				"dATA_VALUE", 92);
		BufferManager m = BufferManager.getinstance();

		AddToBufferObserver observer = new AddToBufferObserver();
		m.addObserver(observer);

		// m.add(par1);
		// m.add(par2);
		// m.add(par3);
		m.add(parsedMessage);
		//m.add(parsedMessage1);
		//m.add(parsedMessage2);
		m.afficher();
	}

}
