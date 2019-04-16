/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.demos;

/**
 *
 * @author SISTEMAS
 */
public class PruebasThis {
    
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = p1.clonar();
        
        System.out.println(p1);
        System.out.println(p2);
    }
}
