/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.calculadora;

/**
 *
 * @author SISTEMAS
 */
public class Calculadora {
    
    public int suma(int n1, int n2){
        return n1 + n2;
    }
    
    public int divide(int dividendo, int divisor){
        if(divisor == 0){
            return 0;
        }
        return dividendo/divisor;
    }
}
