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
public abstract class MiExcepcion extends Exception{
    
    private String messsageKey;

    public MiExcepcion(String messsageKey, String message) {
        super(message);
        this.messsageKey = messsageKey;
    }

    public String getMesssageKey() {
        return messsageKey;
    }
    
}
