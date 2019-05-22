/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author david
 */
@Stateful
public class CompraService implements CompraServiceLocal {

    private List<String> compras = new ArrayList();
    
    @Override
    public void comprar(String producto) {
        System.out.println("Usando el service compra " + this);
        compras.add(producto);
    }

    @Override
    public void confirmarCompra() {
        System.out.println("Los productos de la lista son: "+compras);
        compras = new ArrayList();
    }
    
    @Remove
    public void liberar(){
        compras = new ArrayList<>();
    }

}
