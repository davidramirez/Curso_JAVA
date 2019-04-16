/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.flota.pruebas;

import com.c2b.flota.dominio.Empresa;
import com.c2b.flota.dominio.Vehiculo;

/**
 *
 * @author SISTEMAS
 */
public class PruebaEmpresa {
    
    public static void main(String[] args) {
        /*
        Cear una empresa nueva con el nombre Transportes Ramos
        Mostrar una lista con los vehiculos de la empresa que tiene inicialmente: min 1, max 3
        Añadir un vehiculo
        Mostrar de nuevo la lista de los vehiculos de la empresa
        
        Añadir más de 10 vehiculos. Debe decir que no se puede
        */
        
        Empresa e = new Empresa("Transportes Ramos");
        System.out.println("Nombre de la empresa: " + e.getNombre());
        
        imprimirVehiculos(e.getFlota());
        //Mostrar el num de vehiculos de la empresa
        System.out.println("Num vehiculos de la empresa: " + e.getNumVehiculos());
        
        Vehiculo v = new Vehiculo();
        e.addVehiculo(v);
        
        imprimirVehiculos(e.getFlota());
        v = new Vehiculo();
        if(!e.addVehiculo(v))
        {
            System.out.println("No se ha añadido el vehiculo");
        }
        
        v = new Vehiculo();
        if(!e.addVehiculo(v))
        {
            System.out.println("No se ha añadido el vehiculo");
        }
        
        v = new Vehiculo();
        if(!e.addVehiculo(v))
        {
            System.out.println("No se ha añadido el vehiculo");
        }
        
        imprimirVehiculos(e.getFlota());
    }
    
    private static void imprimirVehiculos(Vehiculo[] vehiculos){
        System.out.println("Vehiculos de la empresa: ");
        for(Vehiculo v:vehiculos){
            if(v != null)
            {
                System.out.println("- "+v);
            }
        }
    }
    
}
