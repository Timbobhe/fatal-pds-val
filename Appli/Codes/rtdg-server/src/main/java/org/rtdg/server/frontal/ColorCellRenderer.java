package org.rtdg.server.frontal;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;




public class ColorCellRenderer implements TableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        if (value instanceof Color) {
            label.setBackground((Color) value);
        }
        return label;
    }


}