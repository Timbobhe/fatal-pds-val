package pds.com.esiag.isidis.fi;

import java.io.IOException;
import java.io.StringWriter;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.esiag.isidis.pds.MessageFormater;

public class Producer {

	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	public MessageProducer pro;

	public Producer(String queueName) throws JMSException {
		
		factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queueName);

		pro = session.createProducer(destination);
	}

	private String genererMessageString(Object action) throws JAXBException,
			IOException {
		JAXBContext context;
		try {
			StringWriter outputString = new StringWriter();
			context = JAXBContext.newInstance("com.esiag.jaxb");
			Marshaller encodeur = context.createMarshaller();
			encodeur.marshal(action, outputString);
			outputString.close();
			return outputString.getBuffer().toString();
		} catch (JAXBException e) {
			System.out
					.println("Exception au niveau de la méthode genererMessageString de la classe Producer :"
							+ e);
		}
		return null;
	}

	public void sendMessage(Object action) throws JMSException {
		try {

			try {
				TextMessage message;
				message = session.createTextMessage();
				String content;
				content = genererMessageString(action);
				System.out.println(content);
				message.setText(content);
				pro.send(message);
			} catch (JAXBException e) {
				e.printStackTrace();
			}

		} catch (JMSException e) {

		} catch (IOException e) {

		}
		
		
			
	}

//	public static void main(String[] args) {
//		try {
//			Producer p = new Producer("heheojesuisla");
//			for (int i = 0; i < 10; i++) {
//				Messageinfos mi2 = new Messageinfos();
//				mi2.setCriticite(i);
//				mi2.setSource("Hamza" + i);
//				mi2.setPosition("saoudi");
//				mi2.setCodeTypeEvenement(i);
//
//				p.sendMessage(mi2);
//			}
//
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//	}
}
