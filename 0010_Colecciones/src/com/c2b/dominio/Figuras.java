/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.dominio;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author david
 */
public class Figuras {
    
    public static void dibujarFigura(Set<Punto> puntos){
        for(Punto p:puntos){
            System.out.println(p);
        }
    }
    
    public static void listarPuntosOrdenadosXY(List<Punto> puntos){
        Collections.sort(puntos);
        for(Punto p:puntos)
            System.out.println(p);
    }
    
    public static boolean estaPunto(List<Punto> puntos, Punto punto){
        Collections.sort(puntos);
        int pos = Collections.binarySearch(puntos, punto);
        if(pos < 0) return false;
        return true;
    }
}
