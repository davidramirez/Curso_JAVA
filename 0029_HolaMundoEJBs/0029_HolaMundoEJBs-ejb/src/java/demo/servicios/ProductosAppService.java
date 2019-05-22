/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author david
 */
@Singleton
public class ProductosAppService implements ProductosAppServiceLocal {

    private List<String> listaProductos;

    public ProductosAppService() {
        
    }
    
    @PostConstruct
    public void inicializar(){
        listaProductos = new ArrayList<String>();
        listaProductos.add("Libro");
        listaProductos.add("DVD");
        listaProductos.add("Pila");
        listaProductos.add("Bateria");
        listaProductos.add("Móvil");
    }
    
    
    
    public List<String> listarProductos(){
        return listaProductos;
    }
}
