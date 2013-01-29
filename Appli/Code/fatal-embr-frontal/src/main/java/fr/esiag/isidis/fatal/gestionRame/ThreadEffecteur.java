package fr.esiag.isidis.fatal.gestionRame;





public class ThreadEffecteur extends Thread{
	
	private EffecteurRame effRame;


	
	
	public ThreadEffecteur(EffecteurRame eff)
	{
		this.effRame=eff;
		
	}
	
	public void run()
	{
			effRame.execute();
	}

}
