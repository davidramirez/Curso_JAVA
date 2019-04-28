/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

/**
 *
 * @author david
 */
public enum TipoCasilla {
    
    OCA ("imagenes/casillas/oca.png"),
    CARCEL ("imagenes/casillas/carcel.png"),
    MUERTE ("imagenes/casillas/muerte.png"),
    INICIO ("imagenes/casillas/inicio.png"),
    META ("imagenes/casillas/meta.png"),
    NORMAL ("imagenes/casillas/normal.png");
    
    private final String imagen;

    private TipoCasilla(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }
    
    
}
