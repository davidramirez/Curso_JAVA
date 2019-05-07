/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.bean;

import app.alquiler.modelo.DVDItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author david
 */
@Named(value = "alquiler")
@SessionScoped
public class AlquilerManagedBean implements Serializable {

    private ArrayList<DVDItem> lista;
    private DVDItem dvd = new DVDItem();

    /**
     * Creates a new instance of AlquilerManagedBean
     */
    public AlquilerManagedBean() {
        lista = new ArrayList();
        lista.add(new DVDItem(1, "Las crónicas de Narnia : el l...", "Fantasía", false));
        lista.add(new DVDItem(2, "Star Trek", "Ciencia ficción", true));
        lista.add(new DVDItem(3, "Bla bla bla", "Suspense", false));
        lista.add(new DVDItem(4, "Avengers:...", "Ficción", false));

    }

    public ArrayList<DVDItem> getLista() {
        return lista;
    }

    public DVDItem getDvd() {
        return dvd;
    }

    public void setDvd(DVDItem dvd) {
        this.dvd = dvd;
    }
    
    

    public String alquilar(int id) {

        DVDItem d = this.buscar(id);
        if (d != null) {
            if (d.isAlquilado()) {
                //Error
            } else {
                d.setAlquilado(true);
            }
        }//else error

        return null;
    }

    public String devolver(int id) {
        DVDItem d = this.buscar(id);

        if (d != null) {
            if (d.isAlquilado()) {
                d.setAlquilado(false);
            } else {
                //Error
            }
        }//else error

        return null;
    }
    
    public String crearDVD(){
        
        if(this.buscar(dvd.getId()) == null){
            lista.add(dvd);
            dvd = new DVDItem();
        }//else error
        
        return "alquiler";
    }

    private DVDItem buscar(int id) {
        for (DVDItem d : lista) {
            if (d.getId() == id) {
                return d;
            }
        }
        //error
        return null;
    }

}
