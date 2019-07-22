/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dvd.repository;

import java.util.Collection;
import org.dvd.model.DVDItem;

/**
 *
 * @author david
 */
public interface DVDItemsRepository {
    public Collection<DVDItem> getAllDVDs();
    public DVDItem getDVD(int id);
    public boolean addDVD(DVDItem dvd);
}
