/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luvic.InvoiceService.service;

import com.luvic.InvoiceService.model.Location;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dsalas
 */
public interface ILocationRepository extends CrudRepository<Location, Long>
{

    Location findBySupplierId( int supplierId );
}
