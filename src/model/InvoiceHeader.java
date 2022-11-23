/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author
 */
public class InvoiceHeader {
       
    private int invoiceNumb;
    private String invoiceClientName ;
    private Date invoiceDate;
    private ArrayList<InvoiceItems> invoiceItems ;

    public InvoiceHeader(int invoiceNumb, String invoiceClientName, Date invoiceDate) {
        this.invoiceNumb = invoiceNumb;
        this.invoiceClientName = invoiceClientName;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceNumb() {
        return invoiceNumb;
    }

    public void setInvoiceNumb(int invoiceNumb) {
        this.invoiceNumb = invoiceNumb;
    }

    public String getInvoiceClientName() {
        return invoiceClientName;
    }

    public void setInvoiceClientName(String invoiceClientName) {
        this.invoiceClientName = invoiceClientName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceItems> getInvoiceItems() {
        if (invoiceItems==null){invoiceItems= new ArrayList();}
        return invoiceItems;
    }

    public void setInvoiceItems(ArrayList<InvoiceItems> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNumb=" + invoiceNumb + ", invoiceClientName=" + invoiceClientName + ", invoiceDate=" + invoiceDate + ", invoiceItems=" + invoiceItems + '}';
    }
    
    
    //needheretocalculatethetotal
    
    public double gettotalperinvoice(){
    double total=0; 
    for(InvoiceItems item : getInvoiceItems()){total=item.gettotalperitem() + total;}
    return total;}
}
