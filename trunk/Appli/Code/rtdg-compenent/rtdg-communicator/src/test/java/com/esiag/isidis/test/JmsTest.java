package com.esiag.isidis.test;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import junit.framework.Assert;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * A simple JMS toplogy with one producer and consumer, both with local brokers.
 * The two brokers then communicate using TCP.
 * 
 * 
 * 
 */
public class JmsTest {

	/**
	 * The URLs used by the producer and consumer to connect to their local
	 * brokers
	 */
	
	final static String PRODUCER_LOCAL_URL = "vm://producer",
			CONSUMER_LOCAL_URL = "vm://consumer";
	/**
	 * The URL used by a remote broker to connect to the consumer broker
	 */
	final static String CONSUMER_REMOTE_URL = "tcp://localhost:12345";

	final static String MESSAGE = "Hello World";
	final static String QUEUE_NAME = "test";

	final Logger logger = Logger.getLogger(JmsTest.class);

	BrokerService consumerBroker, producerBroker;

	/**
	 * Setup the producer and consumer broker
	 * 
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		this.logger.info("Starting consumer broker");
		this.consumerBroker = new BrokerService();
		this.consumerBroker.setBrokerName("consumer");
		this.consumerBroker.addConnector(JmsTest.CONSUMER_LOCAL_URL);
		/* Explicitly add the remote URL so the broker is reachable via TCP */
		this.consumerBroker.addConnector(JmsTest.CONSUMER_REMOTE_URL);
		this.consumerBroker.start();

		this.logger.info("Starting producer broker");
		this.producerBroker = new BrokerService();
		this.producerBroker.setBrokerName("producer");
		this.producerBroker.addConnector(JmsTest.PRODUCER_LOCAL_URL);
		/*
		 * Several methods (such as multicast or discovery) are available to
		 * connect to remote brokers, this one uses a static URL
		 */
		this.producerBroker.addNetworkConnector("static:("
				+ CONSUMER_REMOTE_URL + ")");
		this.producerBroker.start();
	}

	@After
	public void tearDown() throws Exception {
		this.logger.info("Stopping consumer broker");
		this.consumerBroker.stop();
		this.logger.info("Stopping producer broker");
		this.producerBroker.stop();
	}

	@Test
	public void testLog() throws Exception {

		class ConsumerThread extends Thread {

			final Logger logger = Logger.getLogger(ConsumerThread.class);
			/**
			 * Since threads cannot throw exceptions (including AssertionError)
			 * use this flag to determine if the test was successful
			 */
			public boolean success = false;

			@Override
			public void run() {
				try {
					this.logger.info("Creating connection");
					ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
							JmsTest.CONSUMER_LOCAL_URL);
					Connection connection = connectionFactory
							.createConnection();
					connection.start();

					this.logger.info("Creating session");
					Session session = connection.createSession(false,
							Session.AUTO_ACKNOWLEDGE);
					Destination destination = session
							.createQueue(JmsTest.QUEUE_NAME);

					this.logger.info("Starting consumer");
					MessageConsumer consumer = session
							.createConsumer(destination);

					this.logger.info("Waiting for message");
					Message message = consumer.receive();

					Assert.assertNotNull("Did not receive message in time",
							message);
					Assert.assertTrue(message instanceof ObjectMessage);
					ObjectMessage objectMessage = (ObjectMessage) message;
					this.logger.info("Received message: " + objectMessage);
			//		Assert.assertTrue(objectMessage.getObject() instanceof LogObject);
			//		logObject logObject = (LogObject) objectMessage.getObject();
			//		Assert.assertEquals(JmsTest.MESSAGE, logObject.text);

					success = true;
				} catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
			}
		}

		class ProducerThread extends Thread {

			final Logger logger = Logger.getLogger(ProducerThread.class);

			@Override
			public void run() {
			//	try {
				
				
					/*
					this.logger.info("Creating connection");
					ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
							JmsTest.PRODUCER_LOCAL_URL);
					Connection connection = connectionFactory
							.createConnection();

					this.logger.info("Creating session");
					Session session = connection.createSession(false,
							Session.AUTO_ACKNOWLEDGE);
					Destination destination = session
							.createQueue(JmsTest.QUEUE_NAME);

					this.logger.info("Starting producer");
					MessageProducer producer = session
							.createProducer(destination);
					producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

					logObject logObject = new LogObject();
					logObject.text = JmsTest.MESSAGE;
					ObjectMessage message = session
							.createObjectMessage(logObject);
					this.logger.info("Sending message: " + message);

					producer.send(message);

					this.logger.info("Sent message");
				} catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
			}
		}

		Thread producer = new ProducerThread();
		producer.start();
		producer.join();

		ConsumerThread consumer = new ConsumerThread();
		consumer.start();
		consumer.join();

		Assert.assertTrue("Test failed", consumer.success);
		
	}
	*/}}}
				
}