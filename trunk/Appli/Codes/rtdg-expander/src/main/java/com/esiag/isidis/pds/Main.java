package com.esiag.isidis.pds;

import java.util.HashMap;

import org.rtdg.parser.ParsedMessage;

public class Main {

	public Main()
	{
		Traducteur tr=new Traducteur();
		ParsedMessage p1=new ParsedMessage("Tunnel", "", "0001", "000000", "critique", "", "");
		ParsedMessage p2=new ParsedMessage("Train", "", "0002", "000001", "noncritique", "", "");
		
	MessageFormater mf=tr.traduireTF(p1);
		System.out.println(mf);
		System.out.println("----------------------------");
		System.out.println(tr.traduireFT(mf));
	}
	public static void main(String[] args) {
		new Main();
	}

}
