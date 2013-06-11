package com.esiag.isidis.test;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import junit.framework.Assert;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMQTest {
	
	@Test
	public void test() throws Exception {
	    final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
	            "vm://localhost?broker.persistent=true");
	    final Queue queue;
	    final Connection connection = connectionFactory.createConnection();
	    final Session session = connection.createSession(true,
	            Session.AUTO_ACKNOWLEDGE);
	    {
	        queue = session.createQueue("test");
	    }
	    {
	        final MessageProducer producer = session.createProducer(queue);
	        final TextMessage message = session.createTextMessage("testing");
	        connection.start();
	        producer.send(message);
	    }
	    {
	    	
	        final MessageConsumer consumer = session.createConsumer(queue);
	        final TextMessage message = (TextMessage) consumer.receiveNoWait();
	        // "message" is null at this point
	        Assert.assertEquals("testing", message.getText());
	    }
	}
	
}

