/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.service;

import com.luvic.InvoiceService.model.Invoice;
import com.luvic.InvoiceService.model.Status;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Luis Arce
 */
public interface InvoiceService extends CrudRepository<Invoice, Integer> {
    Iterable<Invoice> findBySecuenciaAndStatus(int secuencia, Status status);
    Iterable<Invoice> findBySecuencia(int secuencia);
    Iterable<Invoice> findByStatus(Status status);
}
