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
public class CuentaCorriente extends CuentaBancaria{
    
    //Crea una cuenta corriente con el número de cuenta dado. Por defecto su saldo será 0
    public CuentaCorriente(String numeroCuenta)
    {
        super(numeroCuenta);
    }
    
    /**
     * Crea una cuenta corriente con el número de cuenta y saldo dados
     * @param numeroCuenta
     * @param saldo 
     */
    public CuentaCorriente(String numeroCuenta, double saldo)
    {
        super(numeroCuenta, saldo);
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        if(cantidad <= 0)
        {
            return false;
        }
        else if(cantidad <= this.getSaldo())
        {
            this.saldo = this.getSaldo()-cantidad;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean ingresarDinero(double cantidad) {
        if(cantidad < 0)
        {
            return false;
        }
        else{
            this.saldo = this.saldo + cantidad;
            return true;
        }
    }
    
    
}
