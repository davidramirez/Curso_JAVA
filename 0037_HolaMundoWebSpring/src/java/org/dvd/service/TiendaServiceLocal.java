/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dvd.service;

import java.util.Collection;
import org.dvd.model.DVDItem;

/**
 *
 * @author david
 */
public interface TiendaServiceLocal {
    
    public Collection<DVDItem> getAllDVDs();
    public DVDItem getDVD(int id);
    public boolean addDVD(DVDItem dvd);
    
}
