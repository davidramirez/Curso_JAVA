/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.pruebas;

import com.c2b.dominio.Colores;
import com.c2b.dominio.Punto;
import java.util.HashMap;

/**
 *
 * @author david
 */
public class PruebaHashMap {
    public static void main(String[] args) {
        HashMap<Punto, Colores> figuras = new HashMap();
        Punto p1 = new Punto(1, 1, Colores.AZUL);
        Punto p2 = new Punto(1, 1, Colores.ROJO);
        Punto p3 = new Punto(2, 2, Colores.AZUL);
        Punto p4 = new Punto(1, 4, Colores.VERDE);
        Punto p5 = new Punto(2, 7, Colores.ROJO);
        Punto p6 = new Punto(3, 1, Colores.ROJO);
        Punto p7 = new Punto(4, 7, Colores.AZUL);
        Punto p8 = new Punto(2, 2, Colores.VERDE);
        
        figuras.put(p1, Colores.VERDE);
        figuras.put(p2, Colores.ROJO);
        figuras.put(p3, Colores.AZUL);
        figuras.put(p4, Colores.AZUL);
        figuras.put(p5, Colores.VERDE);
        figuras.put(p6, Colores.ROJO);
        figuras.put(p7, Colores.AZUL);
        figuras.put(p8, Colores.ROJO);
        
        for(Punto p:figuras.keySet()){
            System.out.println(p +" su color asignado es "+ figuras.get(p));
        }
    }
}
