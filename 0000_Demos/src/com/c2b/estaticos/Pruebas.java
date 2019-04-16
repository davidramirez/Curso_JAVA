/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.estaticos;

/**
 *
 * @author SISTEMAS
 */
public class Pruebas {

    public static void main(String[] args) {
        System.out.println(Count.getCounter());
        
        Count c1 = new Count();
        System.out.println(c1);
        
        Count c2 = new Count();
        System.out.println(c2);
    }
}
