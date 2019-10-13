/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.service;

import com.luvic.InvoiceService.model.CreditMemo;
import com.luvic.InvoiceService.model.Status;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Luis Fernando Arce
 */
public interface CreditMemoService extends CrudRepository<CreditMemo, Integer>{
    Iterable<CreditMemo> findBySecuenciaAndStatus(int secuencia, Status status);
    Iterable<CreditMemo> findBySecuencia(int secuencia);
    Iterable<CreditMemo> findByStatus(Status status);
}
