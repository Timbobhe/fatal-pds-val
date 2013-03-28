package pds.com.esiag.isidis.fi;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

import pds.com.esiag.isidis.Consumer.Consumer;
import com.sun.codemodel.util.MS1252Encoder;


public class TestMain {
//	private static final String QUEUE = "QUEUETESTRPDS00";
//
//	public TestMain(String qeueName,Object obj) throws JMSException {
//		ConnectionFactory factory = new ActiveMQConnectionFactory();
//		Producer p = new Producer(factory, QUEUE);
//		if(obj != null){
//			p.sendMessage(obj);
//		}
//		
//	}
//
//	public static void main(String[] args) throws JMSException {
//		Messageinfos ms=new Messageinfos();
//		ms.setCodeTypeEvenement(1);
//		ms.setPosition("Test  x:y");
//		ms.setCodeTypeEvenement(20);
//		ms.setCriticite(1);
//		new TestMain(QUEUE,(Messageinfos)ms);
//		System.out.println("producer lancé : ");		
//	}
	
	
	public static void main(String[] args) {
		try {
//			InfoMessageBuffer info = new InfoMessageBuffer("inforRTDRS");
//			TransferManager t=new TransferManager();
//			Messageinfos inf=new Messageinfos();
//			info.add(inf);
//			t.setInfoMessageBuffer(info);			
			
			Consumer c = new Consumer();
			c.getMessage("heheojesuisla1");
			System.out.println("*************************************************");
			
			if(c.getMessageRecu()!=null){
				System.out.println(c.getMessageRecu().getCriticite());
			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
