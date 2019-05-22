/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import javax.ejb.Local;

/**
 *
 * @author david
 */
@Local
public interface CompraServiceLocal {
    
    public void comprar(String producto);
    
    public void confirmarCompra();
}
