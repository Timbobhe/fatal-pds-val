package com.esiag.isidis.pds;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class BufferManager {

	private CriticalBuffer buf1;
	private CriticalBuffer buf2;
	private CriticalBuffer buf3;
	
	private TreeMap<String,CriticiteValue> tab1;
	//private TreeMap<String,CriticiteValue> tab2;
	public BufferManager(CriticalBuffer buf1, CriticalBuffer buf2,CriticalBuffer buf3) {
		super();
		this.buf1 = buf1;
		this.buf2 = buf2;
		this.buf3 = buf3;
	}
	public BufferManager() {
		super();
		buf1=new CriticalBuffer("Critique");
		buf2=new CriticalBuffer("Non Critique");
		buf3=new CriticalBuffer("Cache");
		tab1=new TreeMap<String, CriticiteValue>();
	}
	public TreeMap<String, CriticiteValue> getTab1() {
		return tab1;
	}
	public void setTab1(TreeMap<String, CriticiteValue> tab1) {
		this.tab1 = tab1;
	}
	public void add(ParsedMessage m)
	{
		if(m.getCRIT_VALUE().equals("Intel"))
		{
			buf1.add(m);
			buf3.add(m);
		}
		else
		{
			CriticiteValue s;
			if (tab1.containsKey(m.getSENSOR_NUM_VALUE()))
			{
				
				s=tab1.get(m.getSENSOR_NUM_VALUE());
				
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

