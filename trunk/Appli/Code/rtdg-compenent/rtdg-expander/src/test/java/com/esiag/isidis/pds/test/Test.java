package com.esiag.isidis.pds.test;


import junit.framework.Assert;

import com.esiag.isidis.pds.MessageFormater;
import com.esiag.isidis.pds.OrdreMessage;

import org.junit.Ignore;
import org.rtdg.parser.ParsedMessage;
import com.esiag.isidis.pds.ReferenceTab;
import com.esiag.isidis.pds.Traducteur;

@Ignore
public class Test {

	private Traducteur traducteur;
	private ParsedMessage pm;
	private MessageFormater mf;
	private OrdreMessage om;
	private ReferenceTab tab;
	public Test()
	{
		traducteur=new Traducteur();
		tab=traducteur.getTab();
		pm=new org.rtdg.parser.ParsedMessage("Tunnel", "", "0001", "000000", "critique", "", "");
		mf=new MessageFormater("Tunnel",2, "X:1000Y:0000", 5);
		om=new OrdreMessage("Tunnel", "0001", "000000", "critique", "Ordre", "", "Suicide");
	}

	@org.junit.Test
	public void traduireFT() {
		OrdreMessage p1=traducteur.traduireFT(mf);
		System.out.println(om);
		System.out.println(p1);
		Assert.assertEquals(p1, om);
	}
	@org.junit.Test
	public void traduireTF() {
		MessageFormater mm=traducteur.traduireTF(pm);
		System.out.println(mm);
		System.out.println(mf);
		Assert.assertEquals(mm, mf);
	}
	
	@org.junit.Test
	public void evenement()
	{
		Assert.assertEquals(tab.getevenement_name_to_idcapteur("0001"), "Suicide");	
	}
	@org.junit.Test
	public void getidcapteur_to_incident()
	{
		Assert.assertEquals(tab.getidcapteur_to_incident(1), "0000");
	}
	@org.junit.Test
	public void getposition_to_idcapteur()
	{
		Assert.assertEquals(tab.getposition_to_idcapteur("0001000000"), "X:1000Y:0000");
	}
	@org.junit.Test
	public void getevenement_name_to_idcapteur( )
	{
		Assert.assertEquals(tab.getevenement_name_to_idcapteur("0001"), "Suicide");
	}
	@org.junit.Test
	public void getidcapteur_to_evenementname( )
	{
		Assert.assertEquals(tab.getidcapteur_to_evenementname("Suicide"), "0001000000");
	}
	@org.junit.Test
	public void getcode_evenement_to_evenementname( )
	{
		Assert.assertEquals(tab.getcode_evenement_to_evenementname("Suicide"),new Integer(2));
	}
	@org.junit.Test
	public void getidcapteur_to_position( )
	{
		Assert.assertEquals(tab.getidcapteur_to_position("X:1000Y:0000"), "0001000000");
	}
	@org.junit.Test
	public void getname_evenement_to_code()
	{
		Assert.assertEquals(tab.getname_evenement_to_code(2), "Suicide");
	}
}
