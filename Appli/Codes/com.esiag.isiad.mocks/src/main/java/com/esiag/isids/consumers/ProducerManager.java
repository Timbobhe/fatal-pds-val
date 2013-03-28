package com.esiag.isids.consumers;

import javax.jms.JMSException;

import com.esiag.jaxb.MessageFormater;



public class ProducerManager {

	private Producer producer;
	private Consumer consumer;
	
	public ProducerManager(String queueName) throws JMSException {
		producer=new Producer(queueName);
		consumer=new Consumer();
	}
	
	public void SendMessage(MessageFormater mf) throws JMSException
	{
		producer.sendMessage(mf);
	}
	public MessageFormater ReceiveMessage(String queuName) throws JMSException
	{
		com.esiag.jaxb.MessageFormater mf=null;
		consumer.getMessage(queuName);//"heheojesuisla"
		///////////////////////////////////////
		System.out.println("*************************************************");
		if (consumer.getMessageRecu() != null) {
			mf=consumer.getMessageRecu();
		}
	
		return mf;
	}
}
