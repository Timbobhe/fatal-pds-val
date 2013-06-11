package pds.com.esiag.isidis.Consumer;

import javax.jms.JMSException;

import pds.com.esiag.isidis.fi.ProducerManager;

public class MainConsumer {
	public static void main(String[] args) throws JMSException {
		ProducerManager man=new ProducerManager("heheojesuisla");
		man.ReceiveMessage("QUEUE-RTDRS");
		if(man.getConsumer().getMessageRecu()!=null)
		System.out.println("tttttttt" + man.getConsumer().getMessageRecu().getCriticite());
	}
}
