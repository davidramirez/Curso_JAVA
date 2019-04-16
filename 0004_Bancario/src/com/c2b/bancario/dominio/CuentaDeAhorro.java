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
        if(cantidad <= 0){
            return false;
        }
        else if(cantidad <= this.getSaldo()){
            this.saldo = this.getSaldo()-cantidad;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean ingresarDinero(double cantidad) {
        if(cantidad < 0){
            return false;
        }
        else{
            this.saldo = this.saldo + cantidad;
            return true;
        }
    }
}
