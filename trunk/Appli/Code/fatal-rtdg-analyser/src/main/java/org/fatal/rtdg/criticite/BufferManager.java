package org.fatal.rtdg.criticite;


import java.util.TreeMap;

import parser.edu.projet.ParsedMessage;

public class BufferManager {

	private MessageBuffer buf1;
	private MessageBuffer buf2;
	private MessageBuffer buf3;
	
	private TreeMap<String,CriticiteValue> tab1;
	
	public BufferManager(MessageBuffer buf1, MessageBuffer buf2,MessageBuffer buf3) {
		super();
		this.buf1 = buf1;
		this.buf2 = buf2;
		this.buf3 = buf3;
	}
	public BufferManager() {
		super();
		buf1=new MessageBuffer("Critique");
		buf2=new MessageBuffer("Non Critique");
		buf3=new MessageBuffer("Cache");
		tab1=new TreeMap<String, CriticiteValue>();
		initialize();
		
	}
	public void initialize(){

		
		CriticiteValue cv_temp=new CriticiteValue("80", 10.0);
		CriticiteValue cv_oxy=new CriticiteValue("10", 5.0);
		CriticiteValue cv_co2=new CriticiteValue("10", 5.0);
		CriticiteValue cv_poid=new CriticiteValue("1000", 100.0);

		tab1.put("CapteurTemperature", cv_temp);
		tab1.put("CapteurOxygene", cv_oxy);
		tab1.put("CapteurCO2", cv_co2);
		tab1.put("CapteurPoids", cv_poid);


	}
	
	public TreeMap<String, CriticiteValue> getTab1() {
		return tab1;
	}

	public void add(ParsedMessage m)
	{
		if(m.getCRIT_VALUE().equals("intellegent"))
		{
			buf1.add(m);
			buf3.add(m);
		}
		else
		{
			CriticiteValue s;
			System.out.println("SENSOR"+m.getSENSOR_TYPE_VALUE());

			if (tab1.containsKey(m.getSENSOR_TYPE_VALUE()))
			{
				s=tab1.get(m.getSENSOR_TYPE_VALUE());
				
				if (validattype(m)==true)
				{
					
					if(s.getValue().equals(m.getDATA_INDICATION()))
						{
						buf1.add(m);
						buf3.add(m);
						}
					else
					{
						buf2.add(m);
						buf3.add(m);
					}
				}
				else
				{
					
					double x,y,z;
					x=Double.parseDouble(s.getValue());
					y=s.getEquartype()+x;
					z=x-s.getEquartype();
					
					if(m.getDATA_VALUE()>=z && m.getDATA_VALUE()<=y)
					{
						buf2.add(m);
						buf3.add(m);
					}
					else
					{
						buf1.add(m);
						buf3.add(m);
					}
					
				}
				
			}
			
			}
	}
	private Boolean validattype(ParsedMessage m)
	{
		if (m.getDATA_INDICATION()!=null) {
			return true;
		
		}
		return false;
	}
	public void afficher()
	{
		System.out.println("-------"+buf1.getName());
		for (ParsedMessage m:buf1)
		{
			System.out.println(m);
		}
		System.out.println("-------"+buf2.getName());
		for (ParsedMessage m:buf2)
		{
			System.out.println(m);
		}
		System.out.println("-------"+buf3.getName());
		for (ParsedMessage m:buf3)
		{
			System.out.println(m);
		}
	}
	

}

