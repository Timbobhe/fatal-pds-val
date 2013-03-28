package org.esiag.isidis.terrain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.net.URL;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



import org.esiag.isidis.gestionLigne.EffecteurLigne;
import org.esiag.isidis.gestionLigne.Ligne;
import org.esiag.isidis.gestionRame.Rame;
import org.esiag.isidis.outils.Controleur;
import org.esiag.isidis.outils.Iupdate;







/**
* @author Jadoui sabri 
*
*/
public class Trajectoire extends JFrame implements Iupdate 
{
	

	private static final long serialVersionUID = 1L;
	
	
	
	private EffecteurLigne[] effLigne;
	private Rame rame;
	private JButton start;
	private JPanel information=null;
	
	public Trajectoire( EffecteurLigne[] effLigne,Rame rame)
	{
		
		 super();
		 this.effLigne= effLigne;
		 this.rame=rame;
		 initComponents();
	     setBounds(660,0,1020,600);
	     this.setLocation(50,0);
	     this.setTitle("Simulation");
	     this.setBackground(Color.black);
	     this.setResizable(true);
	     this.setVisible(true);
 	     
	     Controleur controleur = new Controleur(this,rame);
	     start.addActionListener(controleur);
	    
	     
	    
	}
	 

	   public void drawLigne(ArrayList<Ligne> lignes, Graphics g)
	   {
		   g.fillRect(-lignes.get(0).getOldx()+(this.getSize().width / 2), -lignes.get(0).getOldy()+(this.getSize().height / 2), 30, 15);
		   for ( int i = 0 ; i < lignes.size() ; i++){ 
	        	
	            g.drawLine(-lignes.get(i).getOldx() + (this.getSize().width / 2),
	                       -lignes.get(i).getOldy()+(this.getSize().height / 2),
	                       -lignes.get(i).getX() + (this.getSize().width / 2),
	                       -lignes.get(i).getY()+(this.getSize().height / 2));
	           if(i<lignes.size())
	            g.fillRect(-lignes.get(i).getX()+(this.getSize().width / 2),-lignes.get(i).getY()+(this.getSize().height / 2), 15, 15);
	           
	            if(i==4)
		           g.fillRect(-lignes.get(i).getX()-15+(this.getSize().width / 2),-lignes.get(i).getY()+(this.getSize().height / 2), 30, 15);
	        }

	      
	    }
	   
	   public void executeSimulation(Graphics g){
		   
		   int x = (int) (-rame.getPosition().getX()+ (this.getSize().width/2));                        
		   int y = (int) (-rame.getPosition().getY()+ (this.getSize().height/2));                        
		        
	        /*g.setColor(Color.gray);
	        g.fill3DRect(x, y-15, 30, 20, true);
	        g.setColor(Color.black);
	        g.drawString("14", x+5, y);*/
		    final URL url = Thread.currentThread().getContextClassLoader().getResource("rame.gif");
		    
		    Image img =Toolkit.getDefaultToolkit().getImage(url);
		    //Image img = getToolkit().getImage("src/rame.gif");
			g.drawImage(img,x,y-15,400,25, this);
		   	   
	   }
	   
	   public void paint (Graphics g)
	   {
		   
	        super.paint(g) ;		  
			Font font = new Font("Courier", Font.BOLD, 15);
	        g.setFont(font);
	    
	        g.setColor(Color.red);
	        for(EffecteurLigne eff : effLigne){
	        	this.drawLigne(eff.getLignes(), g);
	        }
	        this.executeSimulation(g);
	        
	    }
	  
	   public void update()
	   {               
	       // this.paint(this.getGraphics());
		   this.executeSimulation( this.getGraphics());
		   this.repaint();
	       
	    }
	 
	   
	   private JButton getStart() {
			
			if (start == null) {
				start = new JButton();
				start.setIcon(new ImageIcon("outils/start.png"));
				start.setBounds(new Rectangle(460, 500, 75, 85)); 
				start.setText("start");
			
			}
			return start;
		}
	   
	   private JPanel getInformation() {
			if (information == null) {
				information = new JPanel();
				information.setLayout(null);
				information.setBounds(new Rectangle(400, 500, 700, 50));
				//information.add((, null);
				information.setBorder(BorderFactory.createTitledBorder(null, "Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), Color.gray));
			}
			return information;
		}

		
	   
	  
	  
	   private void initComponents() {

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        getContentPane().add(this.getStart());
	      //  getContentPane().add( getInformation());
	        
	        pack();
	    }  
	   
	    
	    
	   



}
