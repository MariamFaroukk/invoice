/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class TableForLines extends AbstractTableModel {
       
    private ArrayList<InvoiceItems> lines;
    private String[] columns = {"Item", "Price Per Item", "Count", "Total"};
       public TableForLines() {
        this(new ArrayList<InvoiceItems>());
    }
    
    public TableForLines(ArrayList<InvoiceItems> lines) {
        this.lines = lines;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItems line = lines.get(rowIndex);
        switch (columnIndex) {
            case 0: return line.getInvoiceClientName();
            case 1: return line.getPrice();
            case 2: return line.getIvoiceItemCount();
            case 3: return line.gettotalperitem();
        }
        return "";
    }

   

    
}
