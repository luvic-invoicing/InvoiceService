/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Universal
 */
@Entity
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int secuencia; //TODO: Should be unique
    private String idErp;
    private int status;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceLine> lines; 

    public List<InvoiceLine> getLines() {
        if(lines == null) {
            lines = ArrayList<InvoiceLine>();
        }
        
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public void setSecuencia(int Secuencia) {
        this.secuencia = Secuencia;
    }

    public String getIdErp() {
        return idErp;
    }

    public void setIdErp(String idErp) {
        this.idErp = idErp;
    }
}
