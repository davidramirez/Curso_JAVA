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
public class PruebaOperadores {
    
    public static void main(String[] args) {
        
        int a = 2;
        int b = 4;
        
        a++;
        b--;
        System.out.println("a " + a);//3
        System.out.println("b " + b);//3
        
        ++a;
        --b;
        System.out.println("a " + a);//4
        System.out.println("b " + b);//2
        
        int c;
        a = 3;
        c = a ++;//Asigna el valor de a y luego aumenta a
        System.out.println("a " + a);//4
        System.out.println("c " + c);//3
        
        a = 3;
        c = ++a;//Suma primero y luego asigna el valor de a
        System.out.println("a " + a);//4
        System.out.println("c " + c);//4
        
        
    }
    
}
