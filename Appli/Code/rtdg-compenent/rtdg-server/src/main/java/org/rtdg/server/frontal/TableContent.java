package org.rtdg.server.frontal;


 
 import javax.swing.table.AbstractTableModel;

import org.rtdg.parser.ParsedMessage;
import org.rtdg.prioriser.BufferManager;
 

 
public class TableContent extends AbstractTableModel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferManager objTable;
	private String content ;
    private final String[] entetes = {"Source", "Id source","Nom capteur","Numéro capteur","Type capteur","Type Donnée","Indication","Valeur"};

    public TableContent(BufferManager objTable) {
        super();
        this.objTable=objTable;
     }
 
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRowCount() {
        return 500;
    }
 
    public int getColumnCount() {
        return 8;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex,int columnIndex) {
    	ParsedMessage pm =  objTable.getBuf3().get(rowIndex);
    		if(columnIndex==0)
    			return pm.getSOURCE_VALUE();
        	if(columnIndex==1)
        		return pm.getID_SOURCE();
        	if(columnIndex==2)
        		return pm.getSENSOR_TYPE_VALUE();
            if(columnIndex==3)
            	return pm.getSENSOR_NUM_VALUE();
        	if(columnIndex==4)
        		return pm.getCRIT_VALUE();
            if(columnIndex==5)
            	return pm.getDATA_TYPE_VALUE();
            if(columnIndex==6){
            	if(pm.getDATA_INDICATION()==null)
            		return "pas d'indication";
            	else
            		return pm.getDATA_INDICATION();
            }
            else  
            	 return pm.getDATA_VALUE();
            
    }
    
    
    
    
}