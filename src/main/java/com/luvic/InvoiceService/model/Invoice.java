/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Luis Fernando Arce
 */
@Entity
public class Invoice { //TODO: Add Validations to TotalAmounts - According to Hacienda - CALL ANOTHER SERVICE FOR THAT???
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique=true)
    private int secuencia;
    
    private String idErp;
    @Enumerated
    private Status status; //TODO: Verfiy status acording to Database?
    
    private String clientName;
    private String clientEmail;
    private String clientId;
    private String clientIdType; //01 Cédula Física, 02 Cédula Jurídica, 03 DIMEX, 04 NITE
    private double totalSell;
    private double totalDiscount;
    private double totalNetSell;
    private double totalTaxes;
    private double totalBill;
    private double totalSellExempt;
    @JsonInclude(Include.NON_NULL)
    private String codeSellCondition;
    private String codePaidMethod1;
    @JsonInclude(Include.NON_NULL)
    private String codePaidMethod2;
    @JsonInclude(Include.NON_NULL)
    private String codePaidMethod3;
    @JsonInclude(Include.NON_NULL)
    private String codePaidMethod4;
    @JsonInclude(Include.NON_NULL)
    private Date authorizationDate;
    @JsonInclude(Include.NON_NULL)
    private Date registryDate;
    private String fiscalConsecutive;
    private String billKey;
    private boolean isInvoice;
    
    @JsonManagedReference
    @OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
    private List<InvoiceLine> lines; 
    
    public Invoice() {
        registryDate = new Date();
    }
    
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientIdType() {
        return clientIdType;
    }

    public void setClientIdType(String clientIdType) {
        this.clientIdType = clientIdType;
    }

    public double getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(double totalSell) {
        this.totalSell = totalSell;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalNetSell() {
        return totalNetSell;
    }

    public void setTotalNetSell(double totalNetSell) {
        this.totalNetSell = totalNetSell;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getTotalSellExempt() {
        return totalSellExempt;
    }

    public void setTotalSellExempt(double totalSellExempt) {
        this.totalSellExempt = totalSellExempt;
    }

    public String getCodeSellCondition() {
        return codeSellCondition;
    }

    public void setCodeSellCondition(String codeSellCondition) {
        this.codeSellCondition = codeSellCondition;
    }

    public String getCodePaidMethod1() {
        return codePaidMethod1;
    }

    public void setCodePaidMethod1(String codePaidMethod1) {
        this.codePaidMethod1 = codePaidMethod1;
    }

    public String getCodePaidMethod2() {
        return codePaidMethod2;
    }

    public void setCodePaidMethod2(String codePaidMethod2) {
        this.codePaidMethod2 = codePaidMethod2;
    }

    public String getCodePaidMethod3() {
        return codePaidMethod3;
    }

    public void setCodePaidMethod3(String codePaidMethod3) {
        this.codePaidMethod3 = codePaidMethod3;
    }

    public String getCodePaidMethod4() {
        return codePaidMethod4;
    }

    public void setCodePaidMethod4(String codePaidMethod4) {
        this.codePaidMethod4 = codePaidMethod4;
    }

    public Date getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Date authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
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

    public boolean isIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(boolean isInvoice) {
        this.isInvoice = isInvoice;
    }

    public List<InvoiceLine> getLines() {
        if(lines == null) {
            lines = new ArrayList<InvoiceLine>();
        }
        
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
