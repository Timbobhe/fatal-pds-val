package com.esiag.isidis.pds;

import java.util.TreeMap;

public class Main {

	public Main()
	{
		BufferManager m=new BufferManager();
		
		ParsedMessage par1=new ParsedMessage("Metro 12","capteur de frein", "0000000000", " non critique", "pas d'indication ",80);
		ParsedMessage par2=new ParsedMessage("Metro 13","capteur de frein", "0000000001", " non critique", "pas indicaaa ","false");
		ParsedMessage par3=new ParsedMessage("Metro 14","capteur de frein", "0000000010", " non critique", "pas d'indication",30);
		
		CriticiteValue cv1=new CriticiteValue("20", 10.0);
		CriticiteValue cv2=new CriticiteValue("false", 0.0);
		CriticiteValue cv3=new CriticiteValue("20", 5.0);
	
		
		TreeMap<String, CriticiteValue> t=new TreeMap<String, CriticiteValue>();
		t.put(par1.getSENSOR_NUM_VALUE(), cv1);
		t.put(par2.getSENSOR_NUM_VALUE(), cv2);
		t.put(par3.getSENSOR_NUM_VALUE(), cv3);
		
		m.setTab1(t);
		
		
		m.add(par1);
		m.add(par2);
		m.add(par3);
		m.afficher();
		
	}
	public static void main(String[] args) {
		new Main();

	}

}
