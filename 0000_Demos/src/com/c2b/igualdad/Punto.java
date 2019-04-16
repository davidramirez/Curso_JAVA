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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
    
    
}
