/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.flota.pruebas;

import com.c2b.flota.dominio.Vehiculo;

/**
 *
 * @author SISTEMAS
 */
public class InformeVehiculo {
    
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo();
        
        System.out.println("carga actual " + v.getCargaActual());
        System.out.println("cargo 400 kg" );
        v.cargar(400);
        System.out.println("carga actual " + v.getCargaActual());
        System.out.println("cargo - 400 kg" );
        v.cargar(-400);
        System.out.println("carga actual " + v.getCargaActual());
        
        System.out.println("cargo 1000 kg" );
        v.cargar(1000);
        System.out.println("carga actual " + v.getCargaActual());
        
        System.out.println("cargo 700 kg" );
        v.cargar(700);
        System.out.println("carga actual " + v.getCargaActual());
        
        System.out.println("cargo 100 kg" );
        v.cargar(100);
        System.out.println("carga actual " + v.getCargaActual());
        
        byte pequeNum = 4;//implicito
        byte pequeNum2 = (byte) 128;//-128 a 127
        System.out.println(pequeNum2);
    }
    
    
    
}
