/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.ascensor.excepciones;

/**
 *
 * @author SISTEMAS
 */
public class ExcesoPasajerosException extends Exception{
    private int excesoPasajeros;

    public ExcesoPasajerosException(int excesoPasajeros, String message) {
        super(message);
        this.excesoPasajeros = excesoPasajeros;
    }

    public int getExcesoPasajeros() {
        return excesoPasajeros;
    }
    
}
