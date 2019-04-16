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
public class ExcesoPesoException extends Exception{
    
    private double excesoPeso;

    public ExcesoPesoException(double excesoPeso, String message) {
        super(message);
        this.excesoPeso = excesoPeso;
    }

    public double getExcesoPeso() {
        return excesoPeso;
    }
}
