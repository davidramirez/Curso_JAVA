/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.dominio;

/**
 *
 * @author david
 */
public class CuentaDeAhorro extends CuentaBancaria{
    
    private double interes;
    
    public CuentaDeAhorro(String numCuenta, double saldo, double interes){
        super(numCuenta,saldo);
        this.interes = interes;
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresarDinero(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
