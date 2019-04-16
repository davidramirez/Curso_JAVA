/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.figura;

/**
 *
 * @author SISTEMAS
 */
public class Circulo extends Figura{
    
    private double radio;
    
    
    public void dibujar(){
        System.out.println("centro: " + this.x + ","+ this.y+ " radio: " + this.radio);
    }
    
    public void setRadio(double radio){
        this.radio=radio;
    }
    
}
