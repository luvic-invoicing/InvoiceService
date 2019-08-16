/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Universal
 */
@Entity
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Secuencia; //TODO: Should be unique
    private String idErp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecuencia() {
        return Secuencia;
    }

    public void setSecuencia(int Secuencia) {
        this.Secuencia = Secuencia;
    }

    public String getIdErp() {
        return idErp;
    }

    public void setIdErp(String idErp) {
        this.idErp = idErp;
    }
}
