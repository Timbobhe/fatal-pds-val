package com.pds.connectionActiveMq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author Hamza
 * 
 */
public class ConnectionActiveMQProducer {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "TESTQUEUE";

	// //////////////////////////////////////////////////////////////////
	Session session;
	Destination destination;
	Connection connection;

	/**
	 * 
	 * @throws JMSException
	 */
	public ConnectionActiveMQProducer() throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createQueue(subject);

	}

	/**
	 * 
	 * @param msg
	 * @throws JMSException
	 */
	public void envoiMessageMQ(String msg) throws JMSException {
		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage(msg);
		producer.send(message);
		System.out.println("Sent message '" + message.getText() + "'");
		connection.close();
	}

	public static void main(String[] args) throws JMSException {
		new ConnectionActiveMQConsumer();
	}
}
