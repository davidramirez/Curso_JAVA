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
public class Count {
    
    private int serialNumber;
    private static int counter = 0;
    
    
    public Count(){
        this.serialNumber = counter++;
    }

    @Override
    public String toString() {
        return "Counter{" + "serialNumber=" + serialNumber + '}';
    }

    public static int getCounter() {
        return counter;
    }
    
    
}
