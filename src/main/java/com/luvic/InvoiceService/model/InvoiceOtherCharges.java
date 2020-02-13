package com.luvic.InvoiceService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InvoiceOtherCharges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    private Invoice invoice;


    String documentType;
    String detail;
    double percentaje;
    double chargeAmount;
}
