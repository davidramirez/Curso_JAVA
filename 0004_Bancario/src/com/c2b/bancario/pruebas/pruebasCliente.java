/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.pruebas;

import com.c2b.bancario.dominio.Banco;
import com.c2b.bancario.dominio.Cliente;
import com.c2b.bancario.dominio.CuentaBancaria;
import com.c2b.bancario.dominio.CuentaCorriente;

/**
 *
 * @author david
 */
public class pruebasCliente {
    public static void main(String[] args) {
        
        //Crear un cliente y añadirlo
        System.out.println("Prueba primer cliente ++++++++++++++++++++++++++");
        Cliente c1 = new Cliente("pepe perez", "E08888");
        System.out.println(Banco.getBanco().anadirCliente(c1));
        CuentaBancaria c = new CuentaCorriente("E3dere");
        System.out.println(Banco.getBanco().anadirCuentaACliente(1, c));
        Banco.getBanco().imprimirEstado();
        
        
        //TODO Hacer pruebas con un cliente y varias cuentas
        System.out.println("+++++++++++++++++++Pruebas de cuentas con un cliente+++++++++++++++++++++++");
        c1.imprimirEstadoCliente();
        System.out.println("Operacion aceptada " + c1.ingresarDinero("E3dere", 100));
        c1.imprimirEstadoCliente();
        
        System.out.println("Operacion aceptada " + c1.retirarDinero("E3dere", 1000));
        c1.imprimirEstadoCliente();
        
        System.out.println("Operacion aceptada " + c1.retirarDinero("E3dere", 10));
        c1.imprimirEstadoCliente();
    }
}
