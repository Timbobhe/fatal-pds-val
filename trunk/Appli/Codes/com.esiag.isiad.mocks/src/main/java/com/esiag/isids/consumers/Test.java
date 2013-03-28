package com.esiag.isids.consumers;

import com.esiag.jaxb.MessageFormater;


public class Test {
	public static void main(String[] args) {
		try {
			Consumer c = new Consumer();
			Producer p = new Producer("heheojesuisla1");
			c.getMessage("heheojesuisla2");
			System.out.println("*************************************************");
			if(c.getMessageRecu()!=null){
				System.out.println(c.getMessageRecu().getCriticite());
			}
			
			
			for (int i = 0; i < 10; i++) {
				MessageFormater mi2 = new MessageFormater();
				mi2.setCriticite(i);
				mi2.setSource("Hamza" + i);
				mi2.setPosition("saoudi");
				mi2.setCodeTypeEvenement(i);
				p.sendMessage(mi2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
