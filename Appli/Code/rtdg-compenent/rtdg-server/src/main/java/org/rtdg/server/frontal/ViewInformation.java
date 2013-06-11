package org.rtdg.server.frontal;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.rtdg.prioriser.BufferManager;




 
public class ViewInformation extends JFrame implements Observer  {

	private JPanel jContentPane = null;
	private JPanel information = null;
	private JTable infoTable = null;

	private JButton demarrer = null;
	private JButton arreter = null;
	private JButton quitter = null;
	

	private BufferManager bm;
	
	public ViewInformation(BufferManager bm) {
		super();
		initialize();
		this.setVisible(true);
		this.bm=bm;
		this.bm.addObserver(this);
	}

	
	private void initialize() {
		this.setSize(1050, 360);
		this.setTitle("Accueil");
		this.setContentPane(getJContentPane());
	}


	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getInformation(), null);
			jContentPane.add(getDemarrer(), null);
			jContentPane.add(getArreter(), null);
			jContentPane.add(getQuitter(), null);
			jContentPane.setBorder(BorderFactory.createTitledBorder(null, "Informations :", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return jContentPane;
	}


	private JPanel getInformation() {
		if (information == null) {
			information = new JPanel();
			information.setLayout(null);
			information.setBounds(new Rectangle(24, 58, 1000, 164));
			information.add(getInfoTable(), null);
			information.setBorder(BorderFactory.createTitledBorder(null, "Messages :", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return information;
	}

	
	 
	 
	 private JScrollPane getInfoTable() {
		   JScrollPane scroll=null;
			if (infoTable == null) {
			
				TableContent tb = new TableContent(bm);
				infoTable = new JTable(tb);

				
				infoTable.setShowVerticalLines(true);
				infoTable.setShowHorizontalLines(true);
				infoTable.setGridColor(Color.blue);
				
				scroll = new JScrollPane(infoTable);
				
				
				scroll.setBounds(new Rectangle(19, 35, 950, 100));
			}
			return scroll;
		}


	private JButton getDemarrer() {
		if (demarrer == null) {
			demarrer = new JButton();
			demarrer.setBounds(new Rectangle(30, 240, 91, 30));
			demarrer.setText("Démarrer");
			demarrer.setIcon(new ImageIcon("icon/demarrer.png"));

		}
		return demarrer;
	}


	private JButton getArreter() {
		if (arreter == null) {
			arreter = new JButton();
			arreter.setBounds(new Rectangle(150, 240, 91, 31));
			arreter.setText("Arreter");
			arreter.setIcon(new ImageIcon("icon/arreter.png"));

		}
		return arreter;
	}


	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(750, 240, 91, 31));
			quitter.setText("Quitter");
			quitter.setIcon(new ImageIcon(""));
		}
		return quitter;
	}


	


	/*public void update(Model model) {
		TableThread th = new TableThread(infoTable,model);
		th.start();
	
	}*/


	public void update(Observable arg0, Object arg1) {
		TableContent tbm = new TableContent( bm);
 		infoTable.setModel(tbm);
 		this.repaint();
	}



}  
