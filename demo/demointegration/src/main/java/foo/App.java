package foo;

import fatal.pds.Produit;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Produit pro = new Produit();
        pro.setNom("produit1");
        pro.setPrix("prix1");
        System.out.println(pro.getNom());
        System.out.println(pro.getPrix());
    }
    
    
}
