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
public class Cliente {
    
    //atributos
    public int id;
    public String nombre;
    public CuentaBancaria cuenta;
    
    
    public void ordenar(){
        ClienteOrdenadoPorDNI orden = new ClienteOrdenadoPorDNI();
    }
}