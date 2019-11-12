/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

/**
 *
 * @author Luis Arce
 */
public class ForwardInvoiceReserve {
    private int secuencia;
    private String billKey;
    private String fiscalConsecutive; 

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getBillKey() {
        return billKey;
    }

    public void setBillKey(String billKey) {
        this.billKey = billKey;
    }

    public String getFiscalConsecutive() {
        return fiscalConsecutive;
    }

    public void setFiscalConsecutive(String fiscalConsecutive) {
        this.fiscalConsecutive = fiscalConsecutive;
    }
}
