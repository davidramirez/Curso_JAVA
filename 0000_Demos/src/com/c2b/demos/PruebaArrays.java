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
public class PruebaArrays {
    
    public static void main(String[] args) {
        //array de 10 enteros
        
        int[] numeros = new int[10];
        
        numeros[8] = 333;
        
        for(int n:numeros){
            System.out.println(n);
        }
        
        Punto[] puntos = new Punto[3];
        
        puntos[0] = new Punto(1, 2);
        puntos[1] = new Punto(4, 2);
        puntos[2] = new Punto(3, 2);
        for(Punto p:puntos){
            System.out.println(p);
        }
        
        int i = 0;
        
        while(i<puntos.length)
        {
            System.out.println("y " + puntos[i].getY());
            
            if(puntos[i].getX()>2)
            {
                System.out.println("Super punto");
                i++;
                continue;
            }
            
            System.out.println("x " + puntos[i].getX());
            i++;
        }
    }
}
