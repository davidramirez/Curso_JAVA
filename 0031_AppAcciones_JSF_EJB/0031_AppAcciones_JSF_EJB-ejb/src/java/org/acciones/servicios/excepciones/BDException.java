/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios.excepciones;

/**
 *
 * @author david
 */
public class BDException extends MiExcepcion{

    public BDException(String msg, String messageKey) {
        super(msg, messageKey);
    }
    
    
}
