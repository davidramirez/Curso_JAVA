/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.pruebas;

import com.c2b.dominio.Colores;
import com.c2b.dominio.Figuras;
import com.c2b.dominio.Punto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author david
 */
public class PruebaPuntos {

    public static void main(String[] args) {
        Punto p1 = new Punto(1, 1, Colores.AZUL);
        Punto p2 = new Punto(1, 1, Colores.ROJO);
        Punto p3 = new Punto(2, 2, Colores.AZUL);
        Punto p4 = new Punto(1, 4, Colores.VERDE);
        Punto p5 = new Punto(2, 7, Colores.ROJO);
        Punto p6 = new Punto(3, 1, Colores.ROJO);
        Punto p7 = new Punto(4, 7, Colores.AZUL);
        Punto p8 = new Punto(2, 2, Colores.VERDE);

        //Set (no guarda los duplicados)
        HashSet<Punto> set = new HashSet();//Requiere equals y hascode
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);
        set.add(p7);
        set.add(p8);

        System.out.println("Prueba dibujar figura");
        Figuras.dibujarFigura(set);

        //List (guarda los duplicados)
        List<Punto> lista = new ArrayList();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);

        //Se va a requerir un comparable
        System.out.println("Prueba listarordenadosXY");
        Figuras.listarPuntosOrdenadosXY(lista);

        System.out.println("Prueba busquedas binarias");
        System.out.println(Figuras.estaPunto(lista, p5));
        System.out.println(Figuras.estaPunto(lista, new Punto(9, 9, Colores.VERDE)));
    }
}
