/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.dominio;

/**
 *
 * @author david
 */
public class Punto implements Comparable<Punto>{
    private int x;
    private int y;
    private Colores color;

    public Punto(int x, int y, Colores color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + ", color=" + color + '}';
    }

    @Override
    public int compareTo(Punto o) {

        int resx = this.x-o.getX();
        if(resx == 0){
            int resy = this.y-o.getY();
            return resy;
        }
        return resx;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
