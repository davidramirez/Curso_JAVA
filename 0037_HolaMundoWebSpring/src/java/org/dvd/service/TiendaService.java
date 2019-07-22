/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dvd.service;

import java.util.Collection;
import org.dvd.model.DVDItem;
import org.dvd.repository.DVDItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class TiendaService implements TiendaServiceLocal {

    @Autowired
    private DVDItemsRepository repositorio;

    public TiendaService() {
        System.out.println("++++++++++++++instanciando TiendaService+++++++++++++++");
    }
    
    @Override
    public Collection<DVDItem> getAllDVDs() {
        return repositorio.getAllDVDs();
    }

    @Override
    public DVDItem getDVD(int id) {
        return repositorio.getDVD(id);
    }

    @Override
    public boolean addDVD(DVDItem dvd) {
        return repositorio.addDVD(dvd);
    }
    
}
