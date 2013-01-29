package fr.esiag.isidis.fatal.outils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;


import fr.esiag.isidis.fatal.gestionRame.Rame;
import fr.esiag.isidis.fatal.gestionRame.ThreadEffecteur;
import fr.esiag.isidis.fatal.terrain.Trajectoire;





public class Controleur implements ActionListener
{

	private Rame rame;
	private Trajectoire trajectoire;

	/****
	 * constructeur
	 ****/
	public Controleur(Trajectoire trajectoire,Rame rame) 
	{
		super();
		this.rame=rame;
		this.trajectoire=trajectoire;	
		
	}

	public void actionPerformed(ActionEvent e ) 
	{

		if(e.getActionCommand().equals("start"))
		{
			ThreadEffecteur th=new  ThreadEffecteur(rame.getEffecteur());
			th.start();
			rame.setEtat(true);
		}

	}}