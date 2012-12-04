/**
 * 
 */
package fatal.pds;

import org.junit.Test;

import junit.framework.Assert;



/**
 * @author uchiha
 *
 */

public class UsineTest {
	
	
	
	@Test
	public void creationProduitTest(){
	Usine usine = new Usine();
	Produit pro = usine.createProduit();
	Assert.assertEquals(pro.getNom(), "produit1");
	Assert.assertEquals(pro.getPrix(), "prix1");
		
		
	}
	
}
