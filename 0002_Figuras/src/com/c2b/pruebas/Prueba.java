/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.pruebas;

import com.c2b.figura.Circulo;
import com.c2b.figura.Figura;

/**
 *
 * @author SISTEMAS
 */
public class Prueba {
    
    public static void main(String[] args) {
        Figura f = new Figura();
        f.setX(1);
        f.setY(2);
        System.out.println("Centro de la figura: "+f.getX()+","+f.getY());
        
        Circulo c = new Circulo();
        c.setRadio(5);
        c.dibujar();
        
        Triangulo t = new Triangulo();
        t.lado1=12;
        t.lado2=45;
        t.lado3=23;
        t.dibujar();
    }
    
}

class Triangulo extends Figura{
    int lado1;
    int lado2;
    int lado3;
    
    public void dibujar(){
        System.out.println("centro: "+this.x+","+this.y+" lados: "+this.lado1+" "+this.lado2+" "+this.lado3);
    }
}