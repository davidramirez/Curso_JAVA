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
public class CuentaCredito extends CuentaBancaria{
    
    /**
     * tanto por 1 de credito adicional disponible sobre el saldo de la cuenta
     */
    private double credito;
   
    /**
     * Crea una cuenta de credito con 100 de credito por defecto
     * @param numCuenta
     * @param saldo 
     */
    public CuentaCredito(String numCuenta, double saldo){
        super(numCuenta, saldo);
        this.credito = 100;
    }
    
    public CuentaCredito(String numCuenta, double saldo, double credito){
        super(numCuenta, saldo);
        this.credito = credito;
    }

    public double getCredito() {
        return credito;
    }
    
    /**
     * Devuelve la cantidad de dinero disponible para la cuenta de crédito de acuerdo al credito concedido.
     * Si el saldo de la cuenta más el crédito es negativo, devuelve 0
     * @return La cantidad de dinero disponible para gasto. 0 en caso de que el saldo fuera negativo
     */
    public double getSaldoDisponible(){
        double saldoDisponible = this.getSaldo()+this.credito;
        if(saldoDisponible < 0){
            return 0;
        }
        else
        {
            return saldoDisponible;
        }
    }

    /**
     * retira la cantidad si no es negativa y el saldo disponible de la 
     * cuenta es suficiente. El saldo de la cuenta puede acabar en negativo
     * @param cantidad
     * @return true si se puede realizar la operación. False si el saldo disponible 
     * no es suficiente para realizar la operación o la cantidad dada es negativa
     */
    @Override
    public boolean retirarDinero(double cantidad) {
        if(cantidad < 0)
        {
            return false;
        }
        else if(this.getSaldoDisponible() < cantidad)
        {
            //No se puede devolver, no hay dinero suficiente
            return false;
        }
        else{
            //actualizar el saldo
            this.saldo = this.saldo - cantidad;
            return true;
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

    @Override
    public String toString() {
        return "CuentaCredito{"+ "numeroDeCuenta=" + numeroDeCuenta + ", saldo=" + saldo + "credito=" + credito + '}';
    }
    
    
}
