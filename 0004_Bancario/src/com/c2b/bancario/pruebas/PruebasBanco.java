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
public class PruebasBanco {
    
    public static void main(String[] args) {
        //Ver el estado del banco antes de hacer operaciones
        Banco.getBanco().imprimirEstado();
        
        
        //Crear un cliente y añadirlo
        System.out.println("Prueba primer cliente ++++++++++++++++++++++++++");
        Cliente c1 = new Cliente("pepe perez", "E08888");
        System.out.println(Banco.getBanco().anadirCliente(c1));
        Banco.getBanco().imprimirEstado();
        
        //Crear otro cliente y añadirlo
        System.out.println("Prueba segundo cliente ++++++++++++++++++++++++++");
        Cliente c2 = new Cliente("aitor tilla", new CuentaCorriente("E06542", 1000.0));
        System.out.println(Banco.getBanco().anadirCliente(c2));
        Banco.getBanco().imprimirEstado();
        
        //Crear otro cliente y añadirlo
        System.out.println("Prueba tercer cliente ++++++++++++++++++++++++++");
        Cliente c3 = new Cliente("pp2", new CuentaCorriente("E0342", 100.0));
        System.out.println(Banco.getBanco().anadirCliente(c3));
        Banco.getBanco().imprimirEstado();
        
        //Crear otro cliente y añadirlo
        System.out.println("Prueba cuarto cliente ++++++++++++++++++++++++++");
        Cliente c4 = new Cliente("ass1", new CuentaCorriente("E08942", 1040.0));
        System.out.println(Banco.getBanco().anadirCliente(c4));
        Banco.getBanco().imprimirEstado();
        
        //Crear otro cliente y añadirlo
        System.out.println("Prueba quinto cliente ++++++++++++++++++++++++++");
        Cliente c5 = new Cliente("hhhah", new CuentaCorriente("E03562", 2000.0));
        System.out.println(Banco.getBanco().anadirCliente(c5));
        Banco.getBanco().imprimirEstado();
        
        //Crear otro cliente y añadirlo, deberia devolver false
        System.out.println("Prueba sexto cliente ++++++++++++++++++++++++++");
        Cliente c6 = new Cliente("geronimo", new CuentaCorriente("E03262", 2054.0));
        System.out.println(Banco.getBanco().anadirCliente(c6));
        Banco.getBanco().imprimirEstado();
        
        
        //Crear una cuenta y asignarsela a un cliente por id a traves del banco
        System.out.println("Prueba añadir cuenta a cliente ++++++++++++++++++++++++++");
        CuentaBancaria c = new CuentaCorriente("E3dere");
        System.out.println("Se añade la cuenta al cliente con id 1");
        System.out.println(Banco.getBanco().anadirCuentaACliente(1, c));
        Banco.getBanco().imprimirEstado();
        
        
        
    }
}
