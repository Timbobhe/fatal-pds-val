package com.esiag.isids.consumers;

import javax.jms.JMSException;

import com.esiag.jaxb.MessageFormater;


public class MainProducer {
	public static void main(String[] args) {
		try {
			/*
			
			 */
			
			Producer p = new Producer("QUEUE-RTDRS");
			
			for(int i=0;i<20;i++ ){
				MessageFormater mi2 = new MessageFormater();
				mi2.setCriticite(66);
				mi2.setSource("Hamza");
				mi2.setPosition("saoudi");
				mi2.setCodeTypeEvenement(88);
				
				ProducerManager man=new ProducerManager("QUEUE-RTDRS");
				man.SendMessage(mi2);
				
			}
			


		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
