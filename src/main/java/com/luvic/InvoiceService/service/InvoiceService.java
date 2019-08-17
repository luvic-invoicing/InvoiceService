/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.service;

import com.luvic.InvoiceService.model.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Universal
 */
public interface InvoiceService extends CrudRepository<Invoice, Integer> {
    Iterable<Invoice> findBySecuenciaAndStatus(int secuencia, int status);
    Iterable<Invoice> findBySecuencia(int secuencia);
    Iterable<Invoice> findByStatus(int status);
}
