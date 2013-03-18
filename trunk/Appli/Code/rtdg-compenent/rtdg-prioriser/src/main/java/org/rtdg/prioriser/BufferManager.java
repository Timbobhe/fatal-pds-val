package org.rtdg.prioriser;


import java.util.Observable;
import java.util.TreeMap;

import org.rtdg.parser.ParsedMessage;



public class BufferManager extends Observable{

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

	public void add(ParsedMessage pm)
	{
		System.out.println("*********************"+pm.getSENSOR_TYPE_VALUE());
		if (pm.getSENSOR_TYPE_VALUE().equals("Capteurdeposition")) {
			buf2.add(pm);
			buf3.add(pm);
			
			
		}
		else
		{
		if(pm.getCRIT_VALUE().equals("intellegent"))
		{
			buf1.add(pm);
			buf3.add(pm);
		}
		else
		{
			
			CriticiteValue s;
			System.out.println("SENSOR"+pm.getSENSOR_TYPE_VALUE());

			if (tab1.containsKey(pm.getSENSOR_TYPE_VALUE()))
			{
				s=tab1.get(pm.getSENSOR_TYPE_VALUE());
				
				if (validattype(pm)==true)
				{
					
					if(s.getValue().equals(pm.getDATA_INDICATION()))
						{
						buf1.add(pm);
						buf3.add(pm);
						}
					else
					{
						buf2.add(pm);
						buf3.add(pm);
					}
				}
				else
				{
					
					
					double x,y,z;
					x=Double.parseDouble(s.getValue());
					y=s.getEquartype()+x;
					z=x-s.getEquartype();
					
					if(pm.getDATA_VALUE()>=z && pm.getDATA_VALUE()<=y)
					{
						buf2.add(pm);
						buf3.add(pm);
					}
					else
					{
						buf1.add(pm);
						buf3.add(pm);
					}
					
				}
				
				
			}
			}
				
				
		
			}
	}
	public MessageBuffer getBuf1() {
		return buf1;
	}
	public void setBuf1(MessageBuffer buf1) {
		this.buf1 = buf1;
	}
	public MessageBuffer getBuf2() {
		return buf2;
	}
	public void setBuf2(MessageBuffer buf2) {
		this.buf2 = buf2;
	}
	public MessageBuffer getBuf3() {
		return buf3;
	}
	public void setBuf3(MessageBuffer buf3) {
		this.buf3 = buf3;
	}
	public void setTab1(TreeMap<String, CriticiteValue> tab1) {
		this.tab1 = tab1;
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
		System.out.println("-------------------------------------"+buf1.getName());
		for (ParsedMessage m:buf1)
		{
			System.out.println(m);
		}
		
	
		System.out.println("-----------------------------------------"+buf2.getName());
		for (ParsedMessage m:buf2)
		{
			System.out.println(m);
		}
		System.out.println("-----------------------------------------"+buf3.getName());
		
		for (ParsedMessage m:buf3)
		{
			System.out.println(m);
		}
		
		
		
	}
	public  void update(){
		super.setChanged();
		super.notifyObservers();
	}
	

}

