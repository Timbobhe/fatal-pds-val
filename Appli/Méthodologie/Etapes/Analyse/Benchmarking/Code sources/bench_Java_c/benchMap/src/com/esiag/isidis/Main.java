package com.esiag.isidis;

public class Main {

	public Main()
	{
	
		ListeProduit tab=new ListeProduit();
		
		
		long start=System.currentTimeMillis();
		
		for (int i = 0; i <100000; i++) {
			tab.insert(new Produit("C0"+i, "Clavier", 100, 10));
		}
		
		long end=System.currentTimeMillis();
		System.out.println("Temps d'insertion de 100000 element :"+(end-start) );
		
		
		start=System.currentTimeMillis();
		
		Produit p=tab.select("C099999");
		 end=System.currentTimeMillis();
		System.out.println("Temps select d'un element "+p.toString()+" est de :"+(end-start) );
	}
	public static void main(String[] args) {
		new Main();
	}

}
