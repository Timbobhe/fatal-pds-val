package fr.esiag.isidis.fatal.messagegenerator.messagehelper;

public class Transformer {
	
	public static byte[] transformToBinary(String s){
		byte[] tab = new byte[s.length()];
		byte x;
		for(int i = 0; i < s.length(); i++){
			x = Byte.parseByte(s.charAt(i)+"");
			tab[i] = x;
		}
		return tab;	
	}
	
	
	
}
