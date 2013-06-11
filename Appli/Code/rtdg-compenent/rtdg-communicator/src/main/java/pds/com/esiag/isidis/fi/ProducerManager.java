package pds.com.esiag.isidis.fi;

import javax.jms.JMSException;

import pds.com.esiag.isidis.Consumer.Consumer;

import com.esiag.isidis.pds.MessageFormater;

public class ProducerManager {

	private Producer producer;
	private Consumer consumer;
	
	public ProducerManager(String queueName) throws JMSException {
		producer=new Producer(queueName);
		consumer=new Consumer();
	}
	
	public void SendMessage(MessageFormater mf) throws JMSException
	{
		//test
		com.esiag.jaxb.MessageFormater mi2=new com.esiag.jaxb.MessageFormater();
		mi2.setCodeTypeEvenement(mf.getCODE_TYPE_EVENEMENT());
		mi2.setCriticite(mf.getCRITICITE());
		mi2.setPosition(mf.getPOSITION());
		mi2.setSource(mf.getSOURCE());
		producer.sendMessage(mi2);
	}
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public MessageFormater ReceiveMessage(String queueReceiveName) throws JMSException
	{
		com.esiag.jaxb.MessageFormater mf=null;
		consumer.getMessage(queueReceiveName);
		///////////////////////////////////////
		System.out.println("*************************************************");
		if (consumer.getMessageRecu() != null) {
			mf=consumer.getMessageRecu();
		}
		if (mf!=null) {
			MessageFormater m=new MessageFormater(mf.getSource(), mf.getCodeTypeEvenement(), mf.getPosition(), mf.getCriticite());
			return m;
		}
		return new MessageFormater();
	}
}
