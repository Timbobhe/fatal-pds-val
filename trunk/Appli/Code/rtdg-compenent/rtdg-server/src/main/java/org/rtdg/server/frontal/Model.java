package org.rtdg.server.frontal;


import java.util.ArrayList;


public abstract class Model {
	
	
	protected Iupdate abonne;
	/***
	 * liste des abonnes de model
	 */
	protected ArrayList<Iupdate> list = new ArrayList<Iupdate>();
	
	/***
	 * methode changed qui appele la methode update de tous les abonnes pour les mettre a jour
	 */
	public abstract void changed();

	
	/***
	 * ajoute un abonne a la liste
	 */
	public void addAbonne(Iupdate abonne)
	{
		list.add(abonne);
	}
}

