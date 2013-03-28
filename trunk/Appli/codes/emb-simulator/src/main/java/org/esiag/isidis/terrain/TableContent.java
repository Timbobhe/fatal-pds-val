package org.esiag.isidis.terrain;
import java.awt.Color;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

 
public class TableContent extends AbstractTableModel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Object[][] data={{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","knfdnlfd"},{"mon_nom","mon_prenom","kdjfkdj"},{"mon_nom","mon_prenom","dlkjfldj"}};
 
    private final String[] entetes = {"Prénom", "Nom", "Couleur"};
 
    public TableContent() {
        super();
 
       
    }
 
    public int getRowCount() {
        return data.length;
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}