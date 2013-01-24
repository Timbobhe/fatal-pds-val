package com.esiag.pds.composantembarque.main;


import java.util.HashMap;
import java.util.Vector;

import com.esiag.pds.composantembarquer.helper.structure.BinaryMessage;
import com.esiag.pds.composantembarquer.helper.structure.MessageReferntiel;
import com.esiag.pds.message.FormatMessage;
import com.esiag.pds.message.MessageRandom;

public class Main {

	public Main() {
		testRandom();
		//testCollection();
		//parser();
		//hash();
//		MessageReferntiel mr = new MessageReferntiel();
//		mr.initializeTypes();
//		System.out.println(mr.getTypes().get("numerique"));
	}

	

	private void hash() {
		MessageReferntiel mr = new MessageReferntiel();
		mr.initializeCapteurs();
		System.out.println(mr.getValue(mr.getCapteurs(), "j"));
	}



	private void parser() {
		String s = "01000";
//		byte[] tab = new byte[5];
//		for(int i = 0; i < 5; i++){
//			byte x = Byte.parseByte(s.charAt(i)+"");
//			tab[i] = x;
//			System.out.println(x);	
//		}
//		System.out.println(":" + tab[4]);
		
		//byte x = Byte.parseByte(s);
		//Byte c = Byte.parseByte(s);
		//System.out.println(x);
		BinaryMessage bm = new BinaryMessage();
		byte[]d = new byte[s.length()];
		d = bm.chaineToBinary(s);
		//System.out.println(d);
	}



	private void testRandom() {
		FormatMessage fm = new FormatMessage();
		fm.initialize();
		MessageRandom mr = new MessageRandom(fm, 10);
		mr.print();
		BinaryMessage bm = new BinaryMessage();
		for(int i = 0; i < mr.getNbrMessageRandom(); i++){
			//c'est le tableau qu'on va envoyé au composant java
			byte[] tab = bm.transformeMessageToByte(mr.getMessage(i));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}

}
