/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import demo.web.modelo.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author david
 */
@Named(value = "gestionarProductos")
@SessionScoped
public class GestionarProductosManagedBean implements Serializable {
    
    private Producto producto = new Producto();
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    /**
     * Creates a new instance of GestionarProductosManagedBean
     */
    public GestionarProductosManagedBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public String altaProducto(){
        //ya está el producto cargado en el atributo
        System.out.println("..alta producto" + producto);
        listaProductos.add(producto);
        producto = new Producto();
        System.out.println("La lista es " + listaProductos);
        return "productos";
    }
}
