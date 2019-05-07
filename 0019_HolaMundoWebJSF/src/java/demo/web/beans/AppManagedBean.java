/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author david
 */
@Named(value = "app")
@ApplicationScoped
public class AppManagedBean {

    private List<SelectItem> categorias;
    
    public AppManagedBean() {
        this.categorias = new ArrayList();
        this.categorias.add(new SelectItem("Alimentación"));
        this.categorias.add(new SelectItem("Ropa"));
        this.categorias.add(new SelectItem("Papelería"));
        this.categorias.add(new SelectItem("Informática"));
        this.categorias.add(new SelectItem("Multimedia"));
    }

    public List<SelectItem> getCategorias() {
        return categorias;
    }
    
    
}
