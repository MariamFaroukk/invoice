/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author DELL
 */
public class LineDialog extends JDialog {
    
    private JTextField itemName;
    private JTextField itemCount;
    private JTextField itemPrice;
    private JLabel itemNamelb;
    private JLabel itemCountlb;
    private JLabel itemPricelb;

    
    public LineDialog(FrameTrial1 frame) {
        itemName = new JTextField(20);
        itemNamelb = new JLabel("Item           :");
        
        itemCount = new JTextField(20);
        itemCountlb = new JLabel("Count         :");
        
        itemPrice = new JTextField(20);
        itemPricelb = new JLabel("Price per Item  :");
        
        
        setLayout(new GridLayout(4, 2));
        
        add(itemNamelb);
        add(itemName);
        add(itemCountlb);
        add(itemCount);
        add(itemPricelb);
        add(itemPrice);
     
        setModal(true);
        pack();
    }

    public JTextField getItemNameField() {
        return itemName;
    }

    public JTextField getItemCountField() {
        return itemCount;
    }

    public JTextField getItemPriceField() {
        return itemPrice;
    }
}
