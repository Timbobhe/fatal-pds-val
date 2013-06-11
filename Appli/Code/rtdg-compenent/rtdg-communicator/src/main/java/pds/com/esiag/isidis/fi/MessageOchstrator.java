package pds.com.esiag.isidis.fi;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.jms.JMSException;

import com.esiag.jaxb.MessageFormater;

import java.util.Iterator;


public class MessageOchstrator {

	// private static Messageinfos msg;

	private final static ScheduledExecutorService executorService = Executors
			.newSingleThreadScheduledExecutor();

	public String validateMsgOrPos(MessageFormater msg) {
		String s = "msg";

		if ("".equalsIgnoreCase(msg.getSource()) && msg.getCriticite() == 0) {
			return "";
		}
		return s;
	}

	public void setObj(MessageFormater msgE, MessageFormater msgS) {
		msgS.setSource(msgE.getSource());
		msgS.setCodeTypeEvenement(msgE.getCodeTypeEvenement());
		msgS.setPosition(msgE.getPosition());
		msgS.setCriticite(msgE.getCriticite());
	}

	public static void affichage(MessageFormater m, int n) {

		System.out.println("****************Message n: " + n + "*************");
		System.out.println(m.getCodeTypeEvenement());
		System.out.println(m.getCriticite());
		System.out.println(m.getPosition());
		System.out.println(m.getSource());
	}

	public static void main(String[] args) throws JMSException {
		Producer p = new Producer("heheojesuisla");
		LinkedList<MessageFormater> lisMsg = new LinkedList<MessageFormater>();
		for (int i = 0; i <= 10; i++) {
			MessageFormater mi2 = new MessageFormater();
			mi2.setCodeTypeEvenement(i);
			mi2.setCriticite(1000000);
			mi2.setSource("Hamza");
			mi2.setPosition("saoudi");
			lisMsg.add(mi2);
		}
		for (int j = 0; j < lisMsg.size(); j++) {
			affichage(lisMsg.get(j), j);
		}
		// System.out.println("#########################################");
		// affichage(lisMsg.getLast(), 22);
		//
		Iterator<MessageFormater> x = lisMsg.descendingIterator();
		while (!x.hasNext()) {
			affichage(x.next(), 0);
		}
	}
}
