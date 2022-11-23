/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author DELL
 */
//couldnot do it with using linaatt or headeratt
//was tryig also to not implement two more clases and use this mentod to read or write on tables deafult table model 
//no exception handling is added 

import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class HeaderDialog extends JDialog {
    
    
    
    



/**
 *
 * @author DELL
 */

    private JTextField clientName;
    private JTextField date;
    private JLabel clientNamelb;
    private JLabel datelb;
 

    public HeaderDialog(FrameTrial1 frame) {
        clientNamelb = new JLabel("Clinet Name:");
        clientName = new JTextField(30);
        datelb = new JLabel("Date (dd-MM-yyyy):");
        date = new JTextField(30);
       
        setLayout(new GridLayout(3, 2));
        
        add(datelb);
        add(date);
        add(clientNamelb);
        add(clientName);
       
        setModal(true);
        pack();
        
    }

    public JTextField getCustNameField() {
        return clientName;
    }

    public JTextField getInvDateField() {
        return date;
    }
    
}
    

