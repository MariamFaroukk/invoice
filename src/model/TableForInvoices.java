/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import view.FrameTrial1;

/**
 *
 * @author DELL
 */
public class TableForInvoices extends AbstractTableModel {
   private ArrayList<InvoiceHeader> invoices;
    private String[] columns = {"Num", "Customer", "Date", "Total"};

    public TableForInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }


    @Override
    public int getRowCount() {
        return invoices.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return columns.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
               InvoiceHeader inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getInvoiceNumb();
            case 1: return inv.getInvoiceClientName();
            case 2: return FrameTrial1.sdf.format(inv.getInvoiceDate());
            case 3: return inv.gettotalperinvoice();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
    
    
}
