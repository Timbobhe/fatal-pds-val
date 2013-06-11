package org.rtdg.prioriser;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import org.rtdg.parser.ParsedMessage;

public class AddToBufferObserver implements Observer {

	public void update(Observable o, Object arg) {

		BufferManager bufferManager = (BufferManager) o;
		MessageBuffer buf1 = bufferManager.getBufCritique();
		MessageBuffer buf2 = bufferManager.getBufNonCritique();
		MessageBuffer buf3 = bufferManager.getBufCache();
		TreeMap<String, CriticiteValue> tab1 = bufferManager.getTab1();
		ParsedMessage pm = (ParsedMessage) arg;
		System.out.println("ha hya");
		if (pm.getSENSOR_TYPE_VALUE().equals("Capteurdeposition")) {
			addToBuffer(buf2, buf3, pm, "noncritique");

		} else {
			if (pm.getCRIT_VALUE().equals("intelligent")) {
				addToBuffer(buf1, buf3, pm, "critique");
			} else {

				CriticiteValue s;
				if (tab1.containsKey(pm.getSENSOR_TYPE_VALUE())) {
					s = tab1.get(pm.getSENSOR_TYPE_VALUE());

					if (bufferManager.validattype(pm)) {

						if (s.getValue().equals(pm.getDATA_INDICATION())) {
							addToBuffer(buf2, buf3, pm, "noncritique");
						} else {
							if (compareDataIndication(pm, s)) {
								addToBuffer(buf2, buf3, pm, "noncritique");
							} else {
								addToBuffer(buf1, buf3, pm, "critique");
							}
						}
					} else {

						if (compareDataValue(pm, s)) {
							addToBuffer(buf2, buf3, pm, "noncritique");
						} else {
							addToBuffer(buf1, buf3, pm, "critique");
						}
					}
				}
			}

		}
	}

	public void addToBuffer(MessageBuffer buf2, MessageBuffer buf3,
			ParsedMessage pm, String criticite) {
		pm.setCRIT_VALUE(criticite);
		buf2.add(pm);
		buf3.add(pm);
	}

	public boolean compareDataIndication(ParsedMessage pm, CriticiteValue s) {
		boolean result = false;
		double x, y, z;
		x = Double.parseDouble(s.getValue());
		// max
		y = s.getEquartype() + x;
		// min
		z = x - s.getEquartype();
		if (Double.parseDouble(pm.getDATA_INDICATION()) >= z
				&& Double.parseDouble(pm.getDATA_INDICATION()) <= y)
			result = true;
		return result;
	}

	public boolean compareDataValue(ParsedMessage pm, CriticiteValue s) {
		boolean result = false;
		double x, y, z;
		x = Double.parseDouble(s.getValue());
		// max
		y = s.getEquartype() + x;
		// min
		z = x - s.getEquartype();
		if (pm.getDATA_VALUE() >= z && pm.getDATA_VALUE() <= y)
			result = true;
		return result;
	}

}
