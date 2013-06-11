package com.esiag.isidis.pds;

import org.rtdg.parser.ParsedMessage;

public class Traducteur {

	private ReferenceTab tab;

	public Traducteur() {
		super();
		tab=new ReferenceTab();
	}
	
	public ReferenceTab getTab() {
		return tab;
	}
	public OrdreMessage traduireFT(MessageFormater mf)
	{
		String source=mf.getSOURCE();
		String cri=criticite_to_technique(mf.getCRITICITE());
		String cap=getidcapteur_to_position(mf.getPOSITION());
		String type_cap=cap.substring(0,4);
		
		String num_cap=cap.substring(4,cap.length());
	
		String ordre=getname_evenement_to_code(mf.getCODE_TYPE_EVENEMENT());
		OrdreMessage or=new OrdreMessage(source, type_cap, num_cap, cri, "Ordre", "", ordre);
		return or;
	}
	public MessageFormater traduireTF(ParsedMessage pm)
	{
		System.out.println(pm+"_____>");
		MessageFormater f=new MessageFormater();
		f.setCRITICITE(criticite(pm.getCRIT_VALUE()));
		f.setSOURCE(pm.getSOURCE_VALUE());
		System.out.println(pm.getSOURCE_VALUE());
		String name= evenement(pm.getSENSOR_TYPE_VALUE());
		System.out.println(name);
		f.setCODE_TYPE_EVENEMENT(code_evenement(name));
		System.out.println(pm.getSENSOR_TYPE_VALUE()+"type--------------------num"+pm.getSENSOR_NUM_VALUE());
		if (pm.getSENSOR_TYPE_VALUE().equals("0110")) {
			f.setPOSITION(pm.getDATA_INDICATION());
		}
		else
		f.setPOSITION(getposition(pm.getSENSOR_TYPE_VALUE()+pm.getSENSOR_NUM_VALUE()));
		return f;
	}
	private int criticite(String s)
	{
		if (s.equals("critique"))return 5;
		return 1;
	}
	private String evenement(String capteurid)
	{
		return tab.getevenement_name_to_idcapteur(capteurid);
	}
	private Integer code_evenement(String name_evenement)
	{
		return tab.getcode_evenement_to_evenementname(name_evenement);
	}
	private String getposition(String id_capteur)
	{
		return tab.getposition_to_idcapteur(id_capteur);
	}
	private String criticite_to_technique(int criticite)
	{
		if (criticite>=3) {
			return "critique";
		}
		return "noncritique";
	}
	private String getidcapteur_to_position(String position)
	{
		return tab.getidcapteur_to_position(position);
	}
	public String getname_evenement_to_code(int code)
	{
		return tab.getname_evenement_to_code(code);
	}

}
