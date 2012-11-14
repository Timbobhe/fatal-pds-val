package com.esiag.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


//               Annotation    
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)


//
public interface IWebService {
	public Boolean ajouter(Produit p);
	public Produit Get(String ref);
	public void update(String table, String key, String value, String row[]);
	public int Delete(String tablename, String key, String value);
}
