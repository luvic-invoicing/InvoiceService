package com.luvic.InvoiceService.model;

import javax.persistence.*;

@Entity
@Table( name = "location", schema = "luvictechlvd" )
public class Location
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private int matriz;

    @Column( name = "punto_venta" )
    private int puntoVenta;

    @Column( name = "nombre_punto_venta" )
    private String nombrePuntoVenta;

    private String numIdentification;

    private Integer supplierId;

    private Boolean prodSequence;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public int getMatriz()
    {
        return matriz;
    }

    public void setMatriz( int matriz )
    {
        this.matriz = matriz;
    }

    public int getPuntoVenta()
    {
        return puntoVenta;
    }

    public void setPuntoVenta( int puntoVenta )
    {
        this.puntoVenta = puntoVenta;
    }

    public String getNombrePuntoVenta()
    {
        return nombrePuntoVenta;
    }

    public void setNombrePuntoVenta( String nombrePuntoVenta )
    {
        this.nombrePuntoVenta = nombrePuntoVenta;
    }

    public String getNumIdentification()
    {
        return numIdentification;
    }

    public void setNumIdentification( String numIdentification )
    {
        this.numIdentification = numIdentification;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId( Integer supplierId )
    {
        this.supplierId = supplierId;
    }

    public Boolean getProdSequence()
    {
        return prodSequence;
    }

    public void setProdSequence( Boolean prodSequence )
    {
        this.prodSequence = prodSequence;
    }
}
