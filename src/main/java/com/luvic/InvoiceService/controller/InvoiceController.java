/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.controller;

import com.luvic.InvoiceService.model.*;
import com.luvic.InvoiceService.service.ILocationRepository;
import com.luvic.InvoiceService.service.InvoiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Lists;
import com.luvic.InvoiceService.service.CreditMemoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Universal
 */
@RestController
public class InvoiceController {
    
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    CreditMemoService memosService;

    @Autowired
    ILocationRepository iLocationRepository;
    
    @PostMapping("/invoice")
    Invoice create(@RequestBody Invoice invoice) {
        if (invoiceService.findById(invoice.getId()).isPresent()) {
            invoice.setId(0); //FORWARD invoice if already exist
            invoice.setStatus(Status.CREATED);
            Random r = new java.util.Random();
            invoice.setSecuencia(r.nextInt((999 - 500) + 1) + 500);//TODO: Service that generated Secuence, FiscalSecuence and FiscalKey
            invoice.setRegistryDate(new Date());
            
            for (InvoiceLine line : invoice.getLines()) {
                line.setId(0);
                
                for(InvoiceLineTax tax : line.getLineTaxes()) {
                    tax.setId(0);
                }
            }
            
            return invoiceService.save(invoice);
        }
        else {
            return invoiceService.save(invoice);
        }
    }
    
    @GetMapping("/invoice")
    Iterable<Invoice> getAll() {
        return invoiceService.findAll();
    }
    
    @GetMapping("/creditmemo")
    Iterable<CreditMemo> getAllMemos() {
        return memosService.findAll();
    }
    
    @PutMapping("/invoice")
    Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }
    
    //Revert Authorized Invoices
    @DeleteMapping("/invoice/{secuencia}")
    void delete(@PathVariable Integer secuencia) throws Exception {
        
        List<Invoice> invoiceToRevert = Lists.newArrayList(invoiceService.findBySecuencia(secuencia));

        if (invoiceToRevert.size() == 1 && invoiceToRevert.get(0).getStatus().equals(Status.AUTHORIZED)) {
            CreditMemo memo = new CreditMemo();
            
            CreditMemoReserve reserve = reserveCMSecuence(secuencia);
            
            if (reserve == null) {
                throw new Exception("Problems to reserve CM secuence 2");
            }
            
            Random r = new java.util.Random();
            memo.setStatus(Status.CREATED);
            memo.setInvoice(invoiceToRevert.get(0));
            memo.setBillKey(reserve.getBillKey());
            memo.setFiscalConsecutive(reserve.getFiscalConsecutive());
            memo.setSecuencia(reserve.getSecuencia());
            memosService.save(memo);
        
            invoiceToRevert.get(0).setStatus(Status.REVERTED);
            invoiceService.save(invoiceToRevert.get(0)); 
        }
        else {
            throw new Exception("Invoices does not exist or it is not authorized");
        }        
    }
    
    @GetMapping("/invoice/{id}")
    Optional<Invoice> findById(@PathVariable Integer id) {
        return invoiceService.findById(id);
    }
    
    @GetMapping("/creditmemo/{id}")
    Optional<CreditMemo> findMemoById(@PathVariable Integer id) {
        return memosService.findById(id);
    }


    @GetMapping("/invoice/location/{supplierId}")
    Location findBySupplierId(@PathVariable Integer supplierId) {
        return iLocationRepository.findBySupplierId(supplierId);
    }
    
    CreditMemoReserve reserveCMSecuence(int secuencia) {
        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<CreditMemoReserve> result = restTemplate.getForEntity( "http://f7ce6d77.ngrok.io/creditMemo/" + secuencia, CreditMemoReserve.class );
            
            return result.getBody();
        }
        catch (Exception e )
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
