/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.controller;

import com.luvic.InvoiceService.model.Invoice;
import com.luvic.InvoiceService.service.InvoiceService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Universal
 */
@RestController
public class InvoiceController {
    
    @Autowired
    InvoiceService invoiceService;
    
    @PostMapping("/invoice")
    Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }
    
    @GetMapping("/invoice")
    Iterable<Invoice> getAll() {
        return invoiceService.findAll();
    }
    
    @PutMapping("/invoice")
    Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }
    
    @DeleteMapping("/invoice/{id}")
    void delete(@PathVariable Integer id) {
        invoiceService.deleteById(id);
    }
    
    @GetMapping("/invoice/{id}")
    Optional<Invoice> findById(@PathVariable Integer id) {
        return invoiceService.findById(id);
    }
}
