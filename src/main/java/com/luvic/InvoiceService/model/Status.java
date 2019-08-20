/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

/**
 *
 * @author Universal
 */
public enum Status {
    CREATED("created"), //Ready to be send to Hacienda First time 
    AUTHORIZED("authorized"), //Authorized by Hacienda 
    NO_AUTHORIZED("noAuthorized"), //Failed on Hacienda Authorization
    IN_PROGRESS("inProgress"),  //Send to Hacienda - waiting for reply
    ERROR("error"), //Failed to send to Hacienda
    REVERTED("reverted"), //Authorized Invoice and Reverted with Credit Memo
    FORWARDED("forwarded"); //NO-AUTHORIZED && FORWARDED - OR - AUTHORIZED && REVERTED && FORWARDED 
    
    private final String code;
    
    private Status(String code) {
        this.code = code;
    }

    public String toString() {
        return code;
    }
}
