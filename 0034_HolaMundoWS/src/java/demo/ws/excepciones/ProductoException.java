/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ws.excepciones;

import javax.xml.ws.WebFault;

/**
 *
 * @author david
 */
@WebFault(name = "ProductosException")
public class ProductoException extends Exception{

    public ProductoException(String message) {
        super(message);
    }
    
    
    
}
