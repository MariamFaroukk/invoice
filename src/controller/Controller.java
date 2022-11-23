/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceItems;
import model.TableForInvoices;
import model.TableForLines;
import view.FrameTrial1;
import view.HeaderDialog;

import view.LineDialog;

/**
 *
 * @author DELL
 */
public class Controller implements ActionListener ,ListSelectionListener {

    private FrameTrial1 frame;
    private HeaderDialog headerD;
    private LineDialog lineD;
   
    public Controller(FrameTrial1 frame) {
        this.frame= frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
          case "Add Invoice":
              addInvoice();
               break;
          case "Delete Invoice":
              deleteInvoice();
              break;
          case "Add Item":
              addItem();
              break;
          case "Delete Item":
              deleteItem();
              break;
          case  "Load Files":
              loadFiles(null,null);
              break;
          case  "Save Files" :
              saveFiles();
              break;
       }
        
        
    }

    private void addInvoice() {
     headerD = new HeaderDialog(frame);
     headerD.setVisible(true);
        
    }

    private void deleteInvoice() {
         int selectedRow = frame.getInvoicesTable().getSelectedRow();
            frame.getInvoices().remove(selectedRow);
            frame.getHeaderTableModel().fireTableDataChanged();
        
        
    }

    private void addItem() {
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
            lineD= new LineDialog(frame);
            lineD.setVisible(true);
        
    }

    private void deleteItem() {
        
            int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
             int selectedItem = frame.getItemsTable().getSelectedRow();
            InvoiceHeader invoice = frame.getInvoices().get(selectedInvoice);
            invoice.getInvoiceItems().remove(selectedItem);
            frame.getLineTableModel().fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
        
       
    }

    
    public void loadFiles (String headrPath, String linePath) throws IOException{
    File headerFile = null;
    File lineFile =  null;
    if (headrPath == null && linePath == null) {
        JFileChooser fc = new JFileChooser ();
        int result = fc.showOpenDialog (frame);
        if (result ==JFileChooser.APPROVE_OPTION)
            headerFile = fc.getSelectedFile();
            result = fc.showOpenDialog (frame);
        if (result == JFileChooser.APPROVE_OPTION)
            lineFile = fc.getSelectedFile();
                              

        }else {
        headerFile = new File (headrPath);
        lineFile = new File (linePath);}
    if (headerFile != null && lineFile!=null){
        
        
        
        List <String> linelines = Files.lines(Paths.get(lineFile.getAbsolutePath())) .collect (Collectors. toList());
        List <String>  headerLines = Files.lines(Paths.get(headerFile.getAbsolutePath())) .collect (Collectors. toList());
        frame.getInvoices().clear(); 
      for (String headerLine : headerLines) { 
        String[] parts = headerLine.split(",") ;
        String name = parts[2]; 
        int number = Integer.parseInt(parts[0]);
         Date date = null; 
            try {
                date = FrameTrial1.sdf.parse(parts[1]);
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
         InvoiceHeader inv = new InvoiceHeader (number, name, date); 
        frame.getInvoices().add(inv); 
    

        
    }
      frame.setHeaderTableModel(new TableForInvoices(frame.getInvoices()));


         for (String lineLine  :linelines) { 
        String[] parts = lineLine.split(","); 
        int num = Integer.parseInt(parts[0]);
        String name = parts[1]; 
        double price = Double.parseDouble(parts[2]); 
        int count = Integer.parseInt(parts[3]);
        InvoiceHeader inv = frame.getInvoiceByNum(num);
        InvoiceItems line = new InvoiceItems (inv,name,count,price);
        inv.getInvoiceItems().add(line);
    }                                                            
     
    }
    }

    private void saveFiles() {
    //tobeimplemented :(
         
        
        
        
        
        
        
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
      
            InvoiceHeader selectedInvoice = frame.getInvoices().get(selectedRow);
            frame.getCustNameLbl().setText(selectedInvoice.getInvoiceClientName());
            frame.getInvNumLbl().setText("" + selectedInvoice.getInvoiceNumb());
            frame.getInvTotalLbl().setText("" + selectedInvoice.gettotalperinvoice());
            frame.getInvDateLbl().setText(frame.sdf.format(selectedInvoice.getInvoiceDate()));
            frame.setLineTableModel(new TableForLines(selectedInvoice.getInvoiceItems()));
        
        
        
    }
    
}





     