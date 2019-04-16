/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.herencia;

/**
 *
 * @author SISTEMAS
 */
public class NominasService {
    
    public static void generarNomina(Empleado e){
        
        System.out.println("................................................");
        System.out.println("..................NOMINA........................");
        System.out.println("................................................");
        
        double importe = e.calcularSalario();
        
        System.out.println("salario base " + e.salario);
        System.out.println("salario    " + importe);
        System.out.println("................");
    }
}
