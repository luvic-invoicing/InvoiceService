/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import java.util.List;

/**
 *
 * @author Universal
 */
public class InvoiceCollection {
    public List<Invoice> invoices;
    
    public InvoiceCollection(List<Invoice> invoicesList) {
        invoices = invoicesList;
    }
}
