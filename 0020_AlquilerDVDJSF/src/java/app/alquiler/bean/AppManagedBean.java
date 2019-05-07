/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.bean;

import java.util.ArrayList;
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
    
    public AppManagedBean() {
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
}
