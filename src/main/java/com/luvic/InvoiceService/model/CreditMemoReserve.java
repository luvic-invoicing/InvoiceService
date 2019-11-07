/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import java.util.Date;

/**
 *
 * @author Luis Fernando Arce
 */
public class CreditMemoReserve {
    private int secuencia;
    
    private Date authorizationDate;
    
    private String fiscalConsecutive;
    private String billKey;

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
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
}
