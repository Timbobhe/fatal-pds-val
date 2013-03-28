package pds.com.esiag.isidis.fi;

import javax.jms.JMSException;

import org.rtdg.parser.ParsedMessage;

import com.esiag.isidis.pds.MessageFormater;
import com.esiag.isidis.pds.Traducteur;

public class MainProducer {
	public static void main(String[] args) {
			try {
				/*
				
				 */
				 Traducteur tr=new Traducteur();
					ParsedMessage p1=new ParsedMessage("Tunnel", "", "0001", "000000", "critique", "", "");
					ParsedMessage p2=new ParsedMessage("Train", "", "0002", "000001", "noncritique", "", "");
					
				MessageFormater mf=tr.traduireTF(p1);
				Producer p = new Producer("heheojesuisla");
				
				
				ProducerManager man=new ProducerManager("heheojesuisla");
				man.SendMessage(mf);

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
}
