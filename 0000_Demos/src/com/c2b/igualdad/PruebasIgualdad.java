/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.igualdad;

import java.util.HashSet;

/**
 *
 * @author SISTEMAS
 */
public class PruebasIgualdad {
    
    public static void main(String[] args) {
        Empleado e1 = new Empleado(1, "pp pp", true);
        Empleado e2 = new Empleado(1, "pp ppbhjuo", true);
        Empleado e3 = new Empleado(2, "ee pd", true);
        
        System.out.println(e1);
        
        System.out.println("es e1 == e2?" + (e1 == e2));
        System.out.println("es e1 equals e2?" + (e1.equals(e2)));
        
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(2, 2);
        Punto p3 = new Punto(2, 1);
        Punto p4 = p1;
        Punto p5 = new Punto(1, 1);
        
        //Coleccion que no permite duplicados
        //Set
        HashSet<Punto> cuadrado = new HashSet();
        
        cuadrado.add(p1);
        cuadrado.add(p2);
        cuadrado.add(p3);
        cuadrado.add(p4);
        cuadrado.add(p5);
        
        for(Punto p:cuadrado){
            System.out.println(p);
        }
    }
    
}
