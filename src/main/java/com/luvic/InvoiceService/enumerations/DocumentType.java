/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.enumerations;

/**
 *
 * @author Hugo
 */

public enum DocumentType
{
    T("Tiquete"),
    F("Factura"),
    NCF("NotaCreditoFactura"),
    NCT("NotaCreditoTiquete"),
    ND("NotaDebito");
    
    private final String code;
    
    private DocumentType(String code) {
        this.code = code;
    }

    public String toString() {
        return code;
    }
}
