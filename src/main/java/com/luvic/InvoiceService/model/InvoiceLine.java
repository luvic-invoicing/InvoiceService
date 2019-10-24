/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(  schema = "luvictechlvd" )
public class InvoiceLine { //TODO: Data base object can be different to the contract - TO SIMPLIFY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int lineNumber;
    
    @JsonBackReference
    @ManyToOne
    private Invoice invoice;
    
    private String description;
    private int quantity;
    private String unidMeasure;
    private double unitPrice;
    private double amount;
    private double discountAmount;
    @JsonInclude(Include.NON_NULL)
    private String discountReason;
    private double subTotal;
    private double totalAmount;
    
    @JsonManagedReference
    @OneToMany(mappedBy= "invoiceLine", cascade = CascadeType.ALL)
    private List<InvoiceLineTax> lineTaxes;
    
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnidMeasure() {
        return unidMeasure;
    }

    public void setUnidMeasure(String unidMeasure) {
        this.unidMeasure = unidMeasure;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<InvoiceLineTax> getLineTaxes() {
        return lineTaxes;
    }

    public void setLineTaxes(List<InvoiceLineTax> lineTaxes) {
        this.lineTaxes = lineTaxes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
