/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.igualdad;

/**
 *
 * @author SISTEMAS
 */
public class PruebaCompararCadenas {

    public static void main(String[] args) {
        //TODO rfrfrf
        String s1 = "hola";//Pull de ¿streams?, un objeto en memoria por cada literal en el codigo
        String s2 = "hola";
        String s3 = new String("hola");//Aqui crea un nuevo objeto en la heap memory
        
        s1.toUpperCase(); //crea y devuelve otra cadena, no cambia el propio por que modificaria todos los que apuntaran al string
        s1 = s1.toUpperCase();//Ahora apuntará al nuevo string
        
        System.out.println("s1 == s2"+(s1 == s2));
        System.out.println("s1 equals s2" + (s1.equals(s2)));
        System.out.println("s1 == s3"+(s1 == s3));
        System.out.println("s1 equals s3" + (s1.equals(s3)));
    }
}
