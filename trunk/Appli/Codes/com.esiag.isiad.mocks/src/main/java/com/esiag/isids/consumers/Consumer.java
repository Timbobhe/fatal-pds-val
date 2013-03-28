package com.esiag.isids.consumers;

import java.io.StringReader;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.esiag.jaxb.MessageFormater;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 
 * @author Hamza
 *
 */
public class Consumer implements MessageListener {
	public static String brokerURL = "tcp://localhost:61616";
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	private String nameQueue;
	private MessageFormater messageRecu;
	
	
	
	public void getMessage(String queue) {
		try {
			this.nameQueue = queue;
			ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queue);
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				try {
					
					JAXBContext context;
					Unmarshaller decodeur;
					decodeur = JAXBContext.newInstance("com.esiag.jaxb").createUnmarshaller();
					TextMessage text = (TextMessage) message;
					System.out.println(text.getText());			
					StringReader inputString = new StringReader(text.getText());
					context = JAXBContext.newInstance("com.esiag.jaxb");
					decodeur = context.createUnmarshaller();
					messageRecu = (MessageFormater) decodeur.unmarshal(inputString);
					
					
					System.out.println(messageRecu.getCodeTypeEvenement());
					System.out.println(messageRecu.getCriticite());
					System.out.println(messageRecu.getSource());
					System.out.println(messageRecu.getPosition());
					System.out.println("==================================");
					
					
				
				} catch (JAXBException e) {
					e.printStackTrace();
				}
			} else {
			}
		} catch (JMSException e) {
		}
	}

	public static void main(String[] args) {
		try {
			Consumer c = new Consumer();
			c.getMessage("QUEUE-RTDG");
			///////////////////////////////////////
			System.out.println("*************************************************");
			if (c.getMessageRecu() != null) {
				System.out.println(c.getMessageRecu().getCriticite());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MessageFormater getMessageRecu() {
		return messageRecu;
	}

	public void setMessageRecu(MessageFormater messageRecu) {
		this.messageRecu = messageRecu;
	}

}
