/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import javax.swing.ImageIcon;

/**
 *
 * @author david
 */
class Jugador {
    
    private int numero;
    private ImageIcon ficha;
    private int numTurnosInactivo;
    private int casillaActual;

    public Jugador(int numero) {
        this.numero = numero;
        this.ficha = new ImageIcon("imagenes/fichas/j"+numero+".png");
        this.numTurnosInactivo = 0;
        this.casillaActual = 0;
    }

    public ImageIcon getFicha() {
        return ficha;
    }

    boolean estaEliminado() {
        return this.numTurnosInactivo == -1;
    }

    boolean estaCastigado() {
        return this.numTurnosInactivo > 0;
    }

    public void setNumTurnosInactivo(int numTurnosInactivo) {
        this.numTurnosInactivo = numTurnosInactivo;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public int getNumero() {
        return numero;
    }

    void restarTurnoEspera() {
        this.numTurnosInactivo--;
    }

    public int getCasillaActual() {
        return casillaActual;
    }
    
    
}
