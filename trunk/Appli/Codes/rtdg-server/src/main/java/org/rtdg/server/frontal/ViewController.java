package org.rtdg.server.frontal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class ViewController implements ActionListener {

	 public ViewController(){
		 
	 }
	public void actionPerformed(ActionEvent ev) {
		if(ev.getActionCommand().equals("D�marrer"))
		{
			
		}
		if(ev.getActionCommand().equals("Arreter"))
		{
			
		}
		if(ev.getActionCommand().equals("Quitter"))
		{
			System.exit(1);
		}
	}



}
