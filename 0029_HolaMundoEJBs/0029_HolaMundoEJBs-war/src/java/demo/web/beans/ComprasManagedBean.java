/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import demo.servicios.CompraServiceLocal;
import demo.servicios.ProductosAppServiceLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author david
 */
@Named(value = "comprasManagedBean")
@SessionScoped
public class ComprasManagedBean implements Serializable {

    @EJB
    private CompraServiceLocal compras;
    
    @EJB
    private ProductosAppServiceLocal productos;
    
    public ComprasManagedBean() {
    }
    
    public List<String> getProductos(){
        return productos.listarProductos();
    }
    
    public String btnComprar(String producto){
        compras.comprar(producto);
        return null;
    }
    
    public String btnConfirmar(){
        compras.confirmarCompra();
        return null;
    }
}
