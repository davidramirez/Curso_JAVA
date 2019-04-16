/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.dominio;

import java.util.Objects;

/**
 *
 * @author david
 */
public abstract class CuentaBancaria {
    
    protected String numeroDeCuenta;
    protected double saldo;
    
    /**
     * Crea una cuenta con el numero dado. Por defecto el saldo inicial será 0
     * @param numeroDeCuenta 
     */
    public CuentaBancaria(String numeroDeCuenta){
        this(numeroDeCuenta,0.0);
    }
    
    public CuentaBancaria(String numeroDeCuenta, double saldo){
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    
    public abstract boolean retirarDinero(double cantidad);
    public abstract boolean ingresarDinero(double cantidad);

    @Override
    public String toString() {
        return "CuentaBancaria{" + "numeroDeCuenta=" + numeroDeCuenta + ", saldo=" + saldo 
                + ", tipo de cuenta= " + this.getClass() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numeroDeCuenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (!Objects.equals(this.numeroDeCuenta, other.numeroDeCuenta)) {
            return false;
        }
        return true;
    }
    
    
}
