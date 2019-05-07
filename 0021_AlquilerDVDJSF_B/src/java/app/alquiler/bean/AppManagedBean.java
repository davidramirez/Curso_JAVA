/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.bean;

import app.alquiler.modelo.DVDItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;

/**
 *
 * @author david
 */
@Named(value = "app")
@ApplicationScoped
public class AppManagedBean {
    private List<SelectItem> categorias;
    private String genero = new String();
    
    private LinkedHashMap<Integer, DVDItem> dvds;
    
    public AppManagedBean() {
        dvds = new LinkedHashMap();
        dvds.put(1, new DVDItem(1, "Las crónicas de Narnia : el l...", "Fantasía", false));
        dvds.put(2, new DVDItem(2, "Star Trek", "Ciencia ficción", true));
        dvds.put(3, new DVDItem(3, "Bla bla bla", "Suspense", false));
        dvds.put(4, new DVDItem(4, "Avengers:...", "Ficción", false));
        
        this.categorias = new ArrayList();
        this.categorias.add(new SelectItem("Ficción"));
        this.categorias.add(new SelectItem("Suspense"));
        this.categorias.add(new SelectItem("Ciencia ficción"));
        this.categorias.add(new SelectItem("Animación"));
        this.categorias.add(new SelectItem("Histórico"));
        this.categorias.add(new SelectItem("Terror"));
    }

    public List<SelectItem> getCategorias() {
        return categorias;
    }

    public LinkedHashMap<Integer, DVDItem> getDvds() {
        return dvds;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String anadirGenero(){
        this.categorias.add(new SelectItem(this.genero));
        this.genero = new String();
                
        return "genero";
    }
    
}
