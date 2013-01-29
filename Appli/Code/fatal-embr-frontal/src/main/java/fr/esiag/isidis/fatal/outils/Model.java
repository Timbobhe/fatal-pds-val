package fr.esiag.isidis.fatal.outils;

import java.util.ArrayList;


public abstract class Model {
	
	
	private Iupdate abonne;
	/***
	 * liste des abonnes de model
	 */
	private ArrayList<Iupdate> list = new ArrayList<Iupdate>();
	
	/***
	 * methode changed qui appele la methode update de tous les abonnes pour les mettre a jour
	 */
	public void changed()
	{
		for(Iupdate abonne:list)
		{
			abonne.update();
		}
	}
	
	/***
	 * ajoute un abonne a la liste
	 */
	public void addAbonne(Iupdate abonne)
	{
		list.add(abonne);
	}
}

