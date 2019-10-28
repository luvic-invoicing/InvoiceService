/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.controller;

import com.luvic.InvoiceService.model.Invoice;
import com.luvic.InvoiceService.model.Status;
import com.luvic.InvoiceService.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Universal
 */
@RestController
public class InvoiceCollectionController {
    @Autowired
    InvoiceService invoiceService;
    
    @GetMapping("invoice/search")
    Iterable<Invoice> findByQuery(@RequestParam(value = "secuencia", required = false) Integer secuencia, @RequestParam(value = "status", required = false) Status status) {
        if(secuencia != null && status != null) {
            return invoiceService.findBySecuenciaAndStatus(secuencia, status);
        }
        else if(secuencia != null) {
            return invoiceService.findBySecuencia(secuencia);
        }
        else if(status != null) {
            return invoiceService.findByStatus(status);
        }
        else
            return invoiceService.findAll();
    }
}
