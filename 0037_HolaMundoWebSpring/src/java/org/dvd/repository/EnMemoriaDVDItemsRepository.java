/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dvd.repository;

import java.util.Collection;
import java.util.HashMap;
import org.dvd.model.DVDItem;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class EnMemoriaDVDItemsRepository implements DVDItemsRepository {

    private HashMap<Integer, DVDItem> mapaDvds;

    public EnMemoriaDVDItemsRepository() {
        System.out.println("-----------Instanciando EnMemoriaDVDItemsRepository-----------");
        
        DVDItem d1 = new DVDItem(1, "Buscando a Nemo", "Alguien 1", false, 2000);
        DVDItem d2 = new DVDItem(2, "Buscando a Dory", "Alguien 1", false, 2016);
        DVDItem d3 = new DVDItem(3, "El señor de los anillos", "Alguien 3", false, 2001);

        mapaDvds = new HashMap<>();
        mapaDvds.put(d1.getId(), d1);
        mapaDvds.put(d2.getId(), d2);
        mapaDvds.put(d3.getId(), d3);
    }

    @Override
    public Collection<DVDItem> getAllDVDs() {
        return mapaDvds.values();
    }

    @Override
    public DVDItem getDVD(int id) {
        return mapaDvds.get(id);
    }

    @Override
    public boolean addDVD(DVDItem dvd) {
        if(!mapaDvds.containsKey(dvd.getId())){
            mapaDvds.put(dvd.getId(), dvd);
            return true;
        }
        return false;
    }

}
