/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Luis Fernando Arce
 */
@Entity
@Table(  schema = "luvictechlvd" )
public class CreditMemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique=true)
    private int secuencia;
    
    @Enumerated
    private Status status;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date authorizationDate;
    
    private String fiscalConsecutive;
    private String billKey;
    
    //TODO: Do we need to implement ReTries count?
    
    @OneToOne
    private Invoice invoice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date registryDate;

    public CreditMemo() {
        registryDate = new Date();
    }
    
    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Date authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public String getFiscalConsecutive() {
        return fiscalConsecutive;
    }

    public void setFiscalConsecutive(String fiscalConsecutive) {
        this.fiscalConsecutive = fiscalConsecutive;
    }

    public String getBillKey() {
        return billKey;
    }

    public void setBillKey(String billKey) {
        this.billKey = billKey;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
