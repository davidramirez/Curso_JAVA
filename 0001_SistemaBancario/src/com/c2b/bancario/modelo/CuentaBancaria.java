/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.modelo;

/**
 *
 * @author SISTEMAS
 */
public class CuentaBancaria {
    
    //variable de clase
    //Se crea una sola vez al cargar la clase
    //global
    public static double interesCuenta = 0.1;
    
    //Variables de instancia
    //Se crean cada vez que se crea un objeto
    //Duran tanto como el objeto que las contiene
    public int numeroDeCuenta;
    public double saldo;
    
    
    public double generarIntereses(){
        //Variable local
        //Su ambito es el metodo. Se destruyen cuando este termina
        double total;
        total = saldo * interesCuenta;
        return total;
    }
}