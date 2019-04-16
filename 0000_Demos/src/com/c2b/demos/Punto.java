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
public class Punto {
    
    private int x;
    private int y;

    public Punto() {
        this.x = 1;
        this.y = 1;
    }
    
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto clonar() {
        Punto newP = new Punto(this.x, this.y);
        return newP;
    }

    @Override
    public String toString() {
        return "x: "+this.x+",y: "+this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
