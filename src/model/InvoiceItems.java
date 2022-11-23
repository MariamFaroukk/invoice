/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class InvoiceItems {
    
      private InvoiceHeader header ;
      //private int invoiceNumb;
    
      private String invoiceClientName ;
      private int invoiceItemCount;
      private double price ;

    public InvoiceItems(InvoiceHeader header, String invoiceClientName, int ivoiceItemCount, double price) {
        this.header = header;
        this.invoiceClientName = invoiceClientName;
        this.invoiceItemCount = ivoiceItemCount;
        this.price = price;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }
//igot confused with item and it is 9:52 i wont change it 
    
    
    public String getInvoiceClientName() {
        return invoiceClientName;
    }

    public void setInvoiceClientName(String invoiceClientName) {
        this.invoiceClientName = invoiceClientName;
    }

    public int getIvoiceItemCount() {
        return invoiceItemCount;
    }

    public void setIvoiceItemCount(int ivoiceItemCount) {
        this.invoiceItemCount = ivoiceItemCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
      
      
    public double gettotalperitem (){
            return price*invoiceItemCount ;}
}
